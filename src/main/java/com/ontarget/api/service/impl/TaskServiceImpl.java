package com.ontarget.api.service.impl;

import com.ontarget.api.dao.*;
import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.FieldWorkerInfo;
import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectTask;
import com.ontarget.entities.FieldWorker;
import com.ontarget.entities.TaskFieldWorker;
import com.ontarget.entities.UserProjectProfile;
import com.ontarget.enums.UserType;
import com.ontarget.exception.DateAfterException;
import com.ontarget.exception.DateBeforeException;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.response.bean.TaskResponse;
import com.ontarget.util.EmailConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class TaskServiceImpl implements TaskService {

	private Logger logger = Logger.getLogger(TaskServiceImpl.class);

	@Autowired
	@Qualifier("taskJpaDAOImpl")
	private TaskDAO taskDAO;

	@Autowired
	@Qualifier("taskPlannedEstimatedCostJpaDAOImpl")
	private TaskEstimatedCostDAO taskEstimatedCostDAO;

	@Autowired
	@Qualifier("projectTaskFileJpaDAOImpl")
	private ProjectTaskFileDAO projectTaskFileDAO;

	@Autowired
	private EmailService emailService;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Autowired
	@Qualifier("projectJpaDAOImpl")
	private ProjectDAO projectDAO;

    @Autowired
    UserProjectProfileDAO userProjectProfileDAO;

	@Autowired
	private ProjectTaskRepository projectTaskRepository;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public TaskResponse addTaskService(Task task, int userId) throws Exception {
		logger.info("Add/Update task: " + task);

		Integer taskId = task.getProjectTaskId();
		logger.info("task id:: " + taskId);


//        // validate start date and end date to be aligned with  project start date and end date
//        Date startDate = task.getStartDate();
//        Date endDate = task.getEndDate();
//
//        java.sql.Date startDateSQL = new java.sql.Date(startDate.getTime());
//        java.sql.Date endDateSQL = new java.sql.Date(endDate.getTime());
//
//
//        if (task.getProjectId() == 0) {
//            throw new Exception("Task project is null");
//        } else {
//
//            ProjectDTO projectDTO = projectDAO.getProject(task.getProjectId());
//
//            Date projectStartDate = projectDTO.getStartDate();
//            Date projectEndDate = projectDTO.getEndDate();
//
//            if (startDateSQL.getTime() < projectStartDate.getTime()) {
//                    logger.info(startDate.toString() + " less than " + projectStartDate.toString());
//                throw new DateBeforeException("Task starts before Activity start date");
//            } else {
//                if (endDateSQL.getTime() > projectEndDate.getTime()) {
//                    logger.info(endDate.toString() + " more than " + projectEndDate.toString());
//                    throw new DateAfterException("Task ends after Activity end date");
//                }
//            }
//        }

        // validation ends.


		if (isTaskAdd(taskId)) {
			taskId = taskDAO.addTask(task, userId);
			if (taskId > 0) {
				List<Integer> assignees = task.getAssignees();
				for (Integer assigneeId : assignees) {
					Contact contact = contactDAO.getContact(assigneeId);

					if (contact != null && (contact.getEmail() != null && contact.getEmail().trim().length() > 0)) {
						ProjectTaskInfo taskInfo = taskDAO.getTaskInfo(taskId);
						emailService.sendTaskAssignmentEmail(taskInfo, contact);
					}
				}
			}
		} else {
			boolean updated = taskDAO.updateTask(task, userId);
			if (!updated) {
				throw new Exception("Add/update task failed.");
			}
		}

		if (taskId == 0) {
			throw new Exception("Add/update task failed.");
		}


        return this.getTaskDetail(taskId);

	}

	public boolean isTaskAdd(Task task) {
		Integer taskId = task.getProjectTaskId();
		return isTaskAdd(taskId);
	}

	private boolean isTaskAdd(Integer taskId) {
		return taskId == null;
	}

	@Override
	public List<TaskInfo> getTask(Integer projectId) throws Exception {
		return taskDAO.getTask(projectId);
	}

	/**
	 * get all tasks by activity for that user
	 * 
	 * @param projectId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ProjectTask> getTasksByProjectAndUser(Integer projectId, Integer userId) throws Exception {
		return taskDAO.getTasksByActivityAndUser(projectId, userId);
	}

	/**
	 * get all tasks for that project for a user
	 * 
	 * @param projectId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Override
	public com.ontarget.response.bean.TaskListResponse getTaskListByProjectAndUser(Integer projectId, Integer userId) throws Exception {
        logger.debug("Getting users task for user: "+userId+" and  by project: "+ projectId);

        long startTime = System.currentTimeMillis();
        com.ontarget.response.bean.TaskListResponse taskListResponse = new com.ontarget.response.bean.TaskListResponse();


        /**
         * if super user return all tasks
         */
        UserProjectProfile userProjectProfile = userProjectProfileDAO.findProfileByUserAndProject(projectId, userId);
        List<com.ontarget.entities.ProjectTask> projectTaskList=null;
        if(userProjectProfile.getProfile().getProfileCode().equals(UserType.SUPERUSER.getCode())){
            projectTaskList = projectTaskRepository.findAllUndeletedTasksByProject(projectId);
        }else {
            projectTaskList = projectTaskRepository.findAllUndeletedTasksByProjectAndUser(projectId,userId);
        }

        long endTime=System.currentTimeMillis();
        logger.info("Time taken to fetch just task:"+ (endTime - startTime) +" ms");

        //if no tasks found return null
        if(projectTaskList == null || projectTaskList.size() == 0){
            taskListResponse.setTasks(null);
            return taskListResponse;
        }


		List<com.ontarget.response.bean.Task> taskList = new ArrayList<com.ontarget.response.bean.Task>();

        long startTaskLoop=System.currentTimeMillis();

		for (com.ontarget.entities.ProjectTask projectTask : projectTaskList) {
			com.ontarget.response.bean.Task task = new com.ontarget.response.bean.Task();
			task.setTitle(projectTask.getTitle());
			task.setDescription(projectTask.getDescription());
			task.setStatus(String.valueOf(projectTask.getStatus()));
			task.setSeverity(projectTask.getSeverity());
			task.setProjectTaskId(projectTask.getProjectTaskId());
			task.setStartDate(projectTask.getStartDate());
			task.setEndDate(projectTask.getEndDate());
            task.setActivityId(projectTask.getProject().getProjectId());

			if (projectTask.getStatus() == OnTargetConstant.TaskStatus.COMPLETED) {
				task.setCompleted(true);
			} else {
				task.setCompleted(false);
			}
			task.setPercentageComplete(projectTask.getTaskPercentage().doubleValue());

			// add assigned to as well.

            long startAssigneesAndContactLoop = System.currentTimeMillis();

			Set<Integer> assignees = getTaskMembers(task.getProjectTaskId());
			List<UserDTO> assignedUsers = new ArrayList<>();
			task.setAssignee(assignedUsers);
			if (assignees != null && assignees.size() > 0) {
				for (Integer id : assignees) {
					Contact contact = taskDAO.getContact(id);
					UserDTO assignedToUser = new UserDTO();
					assignedToUser.setContact(contact);
					assignedToUser.setUserId((id.intValue()));
					assignedUsers.add(assignedToUser);
				}
			}
            long endAssigneesAndContactLoop = System.currentTimeMillis();
            logger.info("Total time take to loop and create Assignees for DTO for:  "+ (endAssigneesAndContactLoop - startAssigneesAndContactLoop) +" ms");
			taskList.add(task);
		}
        long endTaskLoop = System.currentTimeMillis();
        logger.info("Total time take to loop and create DTO for:  "+taskList.size()+" tasks : "+ (endTaskLoop - startTaskLoop) +" ms");

		taskListResponse.setTasks(taskList);

        endTime = System.currentTimeMillis();

        logger.info("Total time take to fetch "+taskList.size()+" tasks : "+ (endTime - startTime) +" ms");

		return taskListResponse;
	}

    @Override
    public List<TaskStatusCount> getTaskCountByStatusByUserByProject(Integer userId, Integer projectId) throws Exception {
        return taskDAO.getTaskCountByStatusByUserByProject(userId, projectId);
    }

    private com.ontarget.response.bean.Task getTaskInfo(com.ontarget.entities.ProjectTask projectTask) throws Exception {
		com.ontarget.response.bean.Task task = new com.ontarget.response.bean.Task();
		task.setTitle(projectTask.getTitle());
		task.setDescription(projectTask.getDescription());
		task.setStatus(String.valueOf(projectTask.getStatus()));
		task.setSeverity(projectTask.getSeverity());
		task.setProjectTaskId(projectTask.getProjectTaskId());
		task.setStartDate(projectTask.getStartDate());
		task.setEndDate(projectTask.getEndDate());

		if (projectTask.getStatus() == OnTargetConstant.TaskStatus.COMPLETED) {
			task.setCompleted(true);
		} else {
			task.setCompleted(false);
		}

		Map<Integer, Contact> contactMap = new HashMap<>();

		List<TaskComment> comments = taskDAO.getTaskComments(task.getProjectTaskId());
		for (TaskComment comment : comments) {
			int commentedBy = comment.getCommentedBy();
			if (contactMap.containsKey(commentedBy)) {
				comment.setCommenterContact(contactMap.get(commentedBy));
			} else {
				Contact contact = taskDAO.getContact(commentedBy);
				contactMap.put(commentedBy, contact);
				comment.setCommenterContact(contact);
			}
		}
		task.setComments(comments);

		task.setPercentageComplete(projectTask.getTaskPercentage().doubleValue());

		Set<Integer> assignees = getTaskMembers(task.getProjectTaskId());
		List<UserDTO> assignedUsers = new ArrayList<>();
		task.setAssignee(assignedUsers);
		if (assignees != null && assignees.size() > 0) {
			for (Integer id : assignees) {
				Contact contact = taskDAO.getContact(id);
				UserDTO assignedToUser = new UserDTO();
				assignedToUser.setContact(contact);
				assignedToUser.setUserId((id.intValue()));
				assignedUsers.add(assignedToUser);
			}
		}
		return task;
	}

	public int addDependentTask(DependentTaskDTO dependentTask) throws Exception {
		return taskDAO.addDependentTask(dependentTask);
	}

	// new
	public TaskResponse getTaskDetail(int taskId) throws Exception {
		com.ontarget.entities.ProjectTask projectTask = taskDAO.getProjectTaskById(taskId);
		TaskResponse taskResponse = new TaskResponse();
		com.ontarget.response.bean.Task task = getTaskInfo(projectTask);
		taskResponse.setTask(task);
		return taskResponse;
	}

	public List<ProjectTask> setTaskLevel(ProjectTask task, int level) throws Exception {
		List<ProjectTask> childTasks = taskDAO.getChildTasks(task.getProjectTaskId());
		if (level < 20 && childTasks != null && !childTasks.isEmpty()) {
			level++;
			for (ProjectTask p : childTasks) {
				setTaskLevel(p, level);
			}
		}

		task.setChildTasks(childTasks);
		return childTasks;
	}

	@Override
	public List<TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception {
		return taskDAO.getTaskCountByStatus(projectId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public com.ontarget.bean.TaskComment addTaskComment(TaskCommentRequest comment) throws Exception {
        com.ontarget.entities.TaskComment taskComment = null;
        if (comment.getTaskCommentId() > 0) {
            taskComment = taskDAO.updateComment(comment);
        } else {
            taskComment = taskDAO.addComment(comment);
            if (taskComment.getTaskCommentId() <= 0) {
                throw new Exception("Task not added");
            }
        }

        //convert to task bean. TODO: write util class
        com.ontarget.bean.TaskComment taskCommentObj = new TaskComment();
        taskCommentObj.setComment(taskComment.getComment());
        taskCommentObj.setTaskCommentId(taskComment.getTaskCommentId());
        taskCommentObj.setCommentedBy(taskComment.getCommentedBy().getUserId());
        taskCommentObj.setTaskId(taskComment.getProjectTask().getProjectTaskId());
        Contact contact = taskDAO.getContact(taskComment.getCommentedBy().getUserId());
        taskCommentObj.setCommenterContact(contact);

        return taskCommentObj;
    }


	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean updateTaskStatus(int taskId, String taskStatus, int userId) throws Exception {
		boolean taskStatusUpdated = taskDAO.updateTaskStatus(taskId, taskStatus, userId);
		/**
		 * change of status email.
		 */
		if (taskStatusUpdated) {
			ProjectTaskInfo task = taskDAO.getTaskInfo(taskId);

			Set<Integer> assignees = this.getTaskMembers(taskId);
			if (assignees != null && assignees.size() > 0) {
				for (Integer assignee : assignees) {
					emailService.sendTaskStatusChangeEmail(task, assignee.intValue());
				}
			}
		}
		return taskStatusUpdated;
	}

	@Override
	public Set<Integer> getTaskMembers(int taskId) throws Exception {
		return taskDAO.getTaskMembers(taskId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addTaskMember(int projectId, int taskId, int memberId) throws Exception {
		return taskDAO.addTaskMember(projectId, taskId, memberId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public long saveTaskFile(int taskid, int userId, String fileName, String location) throws Exception {
		long attachmentId = projectTaskFileDAO.saveTaskFile(taskid, fileName, userId, location);
		if (attachmentId > 0) {
			Contact contact = contactDAO.getContact(userId);

			ProjectTaskInfo task = taskDAO.getTaskInfo(taskid);

			Set<Integer> assignees = this.getTaskMembers(taskid);
			if (assignees != null && assignees.size() > 0) {
				for (Integer assignee : assignees) {
					emailService.sendTaskAttachmentEmail(task, contact, assignee.intValue());
				}
			}
		}
		return attachmentId;
	}

	@Override
	public List<FileAttachment> getTaskAttachments(int taskId) throws Exception {
		List<FileAttachment> taskAttachments = projectTaskFileDAO.getTaskAttachments(taskId);
		Map<Long, Contact> contactSet = new HashMap<>();
		for (FileAttachment fileAttachment : taskAttachments) {
			long userId = fileAttachment.getUserId();
			if (contactSet.containsKey(userId)) {
				fileAttachment.setContact(contactSet.get(userId));
			} else {
				Contact c = contactDAO.getContact((int) userId);
				contactSet.put(userId, c);
				fileAttachment.setContact(c);
			}
		}

		return taskAttachments;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse deleteTaskAttachment(Integer taskFileId, int userId) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		boolean success = projectTaskFileDAO.deleteTaskAttachment(taskFileId, userId);
		if (success) {
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Task attachment deleted successfully");
		} else {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Task attachment delete request failed");
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void assignTaskToUser(int taskId, List<Integer> users, int assigningUser) throws Exception {
		List<Integer> assignees = taskDAO.assignTaskToUser(taskId, assigningUser, users);
		logger.info("assignees: " + assignees);

        ProjectTaskInfo task = taskDAO.getTaskInfo(taskId);
        Contact sender = contactDAO.getContact(task.getCreatorId());

		for (Integer userId : assignees) {
			logger.info("user id: " + userId);
			Contact contact = contactDAO.getContact(userId);

			if (contact != null && (contact.getEmail() != null && contact.getEmail().trim().length() > 0)) {
                Map<String, Object> emailAttributes = new HashMap<>();
                emailAttributes.put("task", task);
                emailAttributes.put("assigneeUser",contact);
                emailAttributes.put("sender",sender);
                emailAttributes.put("emailType", EmailConstant.SendEmailType.TASK_ASSIGNMENT);
				emailService.sendEmail(emailAttributes);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean assignTaskToFieldworker(int taskId, List<Integer> fieldWorkerIds, int assigningUser) throws Exception {
		return taskDAO.assignTaskToFieldworker(taskId, assigningUser, fieldWorkerIds);
	}

	public List<ProjectTask> getDependentTasks(int taskId) throws Exception {
		return taskDAO.getDependentTasks(taskId);
	}

	public List<ProjectTask> getUserTasks(int userId) throws Exception {
		return taskDAO.getUserTasks(userId);
	}

	@Override
	public boolean deleteTask(int taskId, int userId) throws Exception {
		return taskDAO.deleteTask(taskId, userId);
	}

	@Override
	public FieldWorkerResponse getFieldWorkersByTask(int taskId) throws Exception {
		FieldWorkerResponse response = new FieldWorkerResponse();
		List<FieldWorkerInfo> fieldWorkerInfoList = new ArrayList<>();
		response.setFieldWorkers(fieldWorkerInfoList);
		try {
			List<TaskFieldWorker> taskFieldWorkers = taskDAO.getTaskFieldWorkersByTask(taskId);

			if (taskFieldWorkers != null && !taskFieldWorkers.isEmpty()) {
				for (TaskFieldWorker taskFieldWorker : taskFieldWorkers) {
					if (taskFieldWorker.getStatus().equals(OnTargetConstant.TaskFieldWorkerStatus.ASSIGNED)) {
						FieldWorker fieldWorker = taskFieldWorker.getFieldWorker();
						FieldWorkerInfo fieldWorkerInfo = new FieldWorkerInfo();
						fieldWorkerInfo.setId(fieldWorker.getId());
						fieldWorkerInfo.setFirstName(fieldWorker.getFirstName());
						fieldWorkerInfo.setLastName(fieldWorker.getLastName());
						fieldWorkerInfo.setEmailAddress(fieldWorker.getEmailAddress());
						fieldWorkerInfo.setPhoneNumber(fieldWorker.getPhoneNumber());
						fieldWorkerInfo.setDisciplineId(fieldWorker.getDiscipline().getId());
						fieldWorkerInfo.setDiscipline(fieldWorker.getDiscipline().getName());
						fieldWorkerInfo.setAddedDate(fieldWorker.getAddedDate());
						fieldWorkerInfoList.add(fieldWorkerInfo);
					}
				}
			}
			response.setFieldWorkers(fieldWorkerInfoList);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved task field workers");
		} catch (Exception e) {
			logger.error(e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error while retrieving task field workers");
		}
		return response;
	}
//
//
//    public static void main(String[] args) throws Exception{
//        String date1="2015-01-07";
//        String date2="2015-01-07'T'00:00:00";
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date d1=dateFormat.parse(date1);
//
//        Date d2=dateFormat.parse(date2);
//
//        System.out.println(d1.getTime());
//        System.out.println(d2.getTime());
//
//
//
//
//    }


}
