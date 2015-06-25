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
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.FileAttachment;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskStatusCount;
import com.ontarget.bean.UserDTO;
import com.ontarget.dto.ProjectTask;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;

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

	@Override
	public List<ProjectTask> getTasksByProject(Integer projectId) throws Exception {
		return taskDAO.getTasksByProject(projectId);
	}

	public int addDependentTask(DependentTaskDTO dependentTask) throws Exception {
		return taskDAO.addDependentTask(dependentTask);
	}

	public ProjectTask getTaskDetail(int taskId) throws Exception {
		ProjectTask task = taskDAO.getTaskDetail(taskId);
		int assignedUserId = taskDAO.getAssignedUser(task.getProjectTaskId());

		Set<Integer> assignees = taskDAO.getTaskMembers(task.getProjectTaskId());

		List<UserDTO> assignedUsers = new ArrayList<>();
		task.setAssignee(assignedUsers);
		if (assignees != null && assignees.size() > 0) {
			for (Integer id : assignees) {
				Contact contact = contactDAO.getContact(id);
				UserDTO assignedToUser = new UserDTO();
				assignedToUser.setContact(contact);
				assignedToUser.setUserId(assignedUserId);
				assignedUsers.add(assignedToUser);
			}
		} else {
			logger.info("task is unassigned");
		}

		setTaskLevel(task, 1);
		return task;
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
        if(taskStatusUpdated){
            ProjectTaskInfo task = taskDAO.getTaskInfo(taskId);

            Set<Integer> assignees = this.getTaskMembers(taskId);
            if(assignees!=null && assignees.size() > 0){
                for(Integer assignee : assignees) {
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
	public void assignTaskToUser(int taskId, List<Integer> users, int assigningUser) throws Exception {
		logger.info("clearing task assignees");
		taskDAO.deleteAllTaskAssignedUsers(taskId);
		for (Integer userId : users) {
			logger.info("inserting user " + userId + " for task " + taskId);
			taskDAO.assignTaskToUser(taskId, userId, assigningUser);

			// get contact detail by userId
			Contact contact = contactDAO.getContact(userId);
			ProjectTaskInfo task = taskDAO.getTaskInfo(taskId);
			if (contact != null) {
				emailService.sendTaskAssignmentEmail(task, contact);
			}
		}
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

}
