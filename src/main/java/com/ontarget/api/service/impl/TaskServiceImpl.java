package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.ProjectTaskFileDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TaskEstimatedCostDAO;
import com.ontarget.api.repository.ProjectTaskRepository;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.FileAttachment;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskStatusCount;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.FieldWorkerInfo;
import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectTask;
import com.ontarget.entities.FieldWorker;
import com.ontarget.entities.TaskFieldWorker;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.response.bean.TaskResponse;

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
	private ProjectTaskRepository projectTaskRepository;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addTaskService(Task task, int userId) throws Exception {
		logger.info("Add/Update task: " + task);

		Integer taskId = task.getProjectTaskId();
		logger.info("task id:: " + taskId);

		if (task.getProjectId() == null) {
			throw new Exception("task project is null");
		} else {
			ProjectDTO project = projectDAO.getProject(task.getProjectId());
			if (project.getProjectId() == null) {
				throw new Exception("project is invalid for task");
			}
		}

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

		return true;
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
		List<com.ontarget.entities.ProjectTask> projectTaskList = projectTaskRepository.findAllUndeletedTasksByProjectAndUser(projectId,
				userId);

		List<com.ontarget.response.bean.Task> taskList = new ArrayList<com.ontarget.response.bean.Task>();

		for (com.ontarget.entities.ProjectTask projectTask : projectTaskList) {
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
			task.setPercentageComplete(projectTask.getTaskPercentage().doubleValue());

			// add assigned to as well.

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

			taskList.add(task);
		}

		com.ontarget.response.bean.TaskListResponse taskListResponse = new com.ontarget.response.bean.TaskListResponse();
		taskListResponse.setTasks(taskList);
		return taskListResponse;
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
	public Contact addTaskComment(TaskCommentRequest comment) throws Exception {
		if (comment.getTaskCommentId() > 0) {
			if (taskDAO.updateComment(comment)) {
				Contact contact = contactDAO.getContact(comment.getCommentedBy());
				return contact;
			} else
				throw new Exception("task not updated");
		} else {
			int taskCommentId = taskDAO.addComment(comment);
			if (taskCommentId > 0) {
				Contact contact = contactDAO.getContact(comment.getCommentedBy());
				return contact;
			} else {
				throw new Exception("Task not added");
			}
		}

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
		return projectTaskFileDAO.saveTaskFile(taskid, fileName, userId, location);
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
		for (Integer userId : assignees) {
			logger.info("user id: " + userId);
			Contact contact = contactDAO.getContact(userId);

			if (contact != null && (contact.getEmail() != null && contact.getEmail().trim().length() > 0)) {
				ProjectTaskInfo task = taskDAO.getTaskInfo(taskId);
				emailService.sendTaskAssignmentEmail(task, contact);
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

}
