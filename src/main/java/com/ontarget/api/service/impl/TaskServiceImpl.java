package com.ontarget.api.service.impl;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
=======
import com.ontarget.api.dao.*;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.TaskService;
import com.ontarget.bean.*;
import com.ontarget.exception.DateAfterException;
import com.ontarget.exception.DateBeforeException;
import com.ontarget.util.DateFormater;
>>>>>>> origin/ontarget.phase4

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.ontarget.exception.DateAfterException;
import com.ontarget.exception.DateBeforeException;
import com.ontarget.request.bean.Project;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.util.DateFormater;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class TaskServiceImpl implements TaskService {

	private Logger logger = Logger.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private TaskEstimatedCostDAO taskEstimatedCostDAO;

	@Autowired
	private ProjectTaskFileDAO projectTaskFileDAO;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ContactDAO contactDAO;

	@Autowired
	private ProjectDAO projectDAO;

<<<<<<< HEAD
	private static final SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final TimeZone cst = TimeZone.getTimeZone("America/Chicago");

	static {
		format.setTimeZone(cst);
	}

=======
>>>>>>> origin/ontarget.phase4
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addTaskService(Task task, int userId) throws Exception {
		logger.info("Add/Update task: " + task);

<<<<<<< HEAD
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

=======
		int taskId = task.getProjectTaskId();
		logger.info("task id:: " + taskId);

		Date startDate = DateFormater.getFormattedDate(task.getStartDate());
		Date endDate = DateFormater.getFormattedDate(task.getEndDate());

		logger.info("task start date after formatting:: " + startDate);
		logger.info("task end date after formatting:: " + endDate);

		if (task.getProject() == null) {
			throw new Exception("task project is null");
		} else {
			Date projectStartDate = task.getProject().getStartDate();
			Date projectEndDate = task.getProject().getEndDate();
			if (projectStartDate == null || projectEndDate == null) {
				Project project = projectDAO.getProject(task.getProject()
						.getProjectId());
				logger.info("start and end date of project is null so getting new project "
						+ project.toString());
				if (project == null) {
					throw new Exception("project is invalid for task");
				}
				task.setProject(project);
				projectStartDate = project.getStartDate();
				projectEndDate = project.getEndDate();
			}

			projectStartDate = DateFormater.getFormattedDate(projectStartDate);
			projectEndDate = DateFormater.getFormattedDate(projectEndDate);

			logger.info("project start date:: " + projectStartDate);
			logger.info("project end date:: " + projectEndDate);

			if (startDate.before(projectStartDate)) {
				logger.info(startDate.toString() + " less than "
						+ projectStartDate.toString());
				throw new DateBeforeException(
						"Task starts before project start date");
			} else {
				if (endDate.after(projectEndDate)) {
					logger.info(endDate.toString() + " more than "
							+ projectEndDate.toString());
					throw new DateAfterException(
							"Task ends after project end date");
				}
			}
		}

		/*Task parentTask = task.getParentTask();
		logger.info("parent task:: " + parentTask);
		if (parentTask != null) {
			Date parentTaskStartDate = parentTask.getStartDate();
			Date parentTaskEndDate = parentTask.getEndDate();

			logger.info("parent task start date:: " + parentTaskStartDate);
			logger.info("parent task end date:: " + parentTaskEndDate);

			if (parentTaskStartDate == null || parentTaskEndDate == null) {
				parentTask = taskDAO.getTaskDetail(parentTask
						.getProjectTaskId());
				if (parentTask == null) {
					throw new Exception("parent task does not exists");
				}
				parentTaskStartDate = parentTask.getStartDate();
				parentTaskEndDate = parentTask.getEndDate();
			}

			parentTaskStartDate = DateFormater
					.getFormattedDate(parentTaskStartDate);
			parentTaskEndDate = DateFormater
					.getFormattedDate(parentTaskEndDate);

			logger.info("parent task start date from db:: "
					+ parentTaskStartDate);
			logger.info("parent task end date from db:: " + parentTaskEndDate);
			logger.info("task start date:: " + startDate);
			logger.info("task end date:: " + endDate);

			if (parentTaskStartDate != null
					&& startDate.before(parentTaskStartDate)) {
				logger.info(startDate.toString() + " less than "
						+ parentTaskStartDate.toString());
				throw new DateBeforeException(
						"Task starts before parent task start date");
			} else {
				if (parentTaskEndDate != null
						&& endDate.after(parentTaskEndDate)) {
					logger.info(endDate.toString() + " more than "
							+ parentTaskEndDate.toString());
					throw new DateAfterException(
							"Task ends after parent task end date");
				}
			}
		}*/

>>>>>>> origin/ontarget.phase4
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

<<<<<<< HEAD
=======

>>>>>>> origin/ontarget.phase4
		return true;
	}

	public boolean isTaskAdd(Task task) {
<<<<<<< HEAD
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
	public List<ProjectTask> getTasksByProject(Integer projectId)
			throws Exception {
		return taskDAO.getTasksByProject(projectId);
	}

	public int addDependentTask(DependentTaskDTO dependentTask)
			throws Exception {
		return taskDAO.addDependentTask(dependentTask);
	}

	public ProjectTask getTaskDetail(int taskId) throws Exception {
		ProjectTask task = taskDAO.getTaskDetail(taskId);
		int assignedUserId = taskDAO.getAssignedUser(task.getProjectTaskId());

		Set<Integer> assignees = taskDAO
				.getTaskMembers(task.getProjectTaskId());

		List<UserDTO> assignedUsers = new ArrayList<>();
		task.setAssignee(assignedUsers);
		if (assignees != null && assignees.size() > 0) {
			for (Integer id : assignees) {
				Contact contact = contactDAO.getContact(id);
				UserDTO assignedToUser = new UserDTO();
				assignedToUser.setContact(contact);
				assignedToUser.setUserId(assignedUserId);
=======
		int taskId = task.getProjectTaskId();
		return isTaskAdd(taskId);
	}

	private boolean isTaskAdd(int taskId) {
		return taskId <= 0;
	}

	@Override
	public List<Task> getTask(int projectId) throws Exception {
		return taskDAO.getTask(projectId);
	}

	public int addDependentTask(DependentTask dependentTask) throws Exception {
		return taskDAO.addDependentTask(dependentTask);
	}

	public Task getTaskDetail(int taskId) throws Exception {
		Task task = taskDAO.getTaskDetail(taskId);
		Long assignedUserId = taskDAO.getAssignedUser(task.getProjectTaskId());

		Set<Long> assignees = taskDAO.getTaskMembers(task.getProjectTaskId());

		List<User> assignedUsers = new ArrayList<>();
		task.setAssignee(assignedUsers);
		if (assignees != null && assignees.size() > 0) {
			for (Long id : assignees) {
				Contact contact = contactDAO.getContact(id);
				User assignedToUser = new User();
				assignedToUser.setContact(contact);
				assignedToUser.setUserId(assignedUserId.intValue());
>>>>>>> origin/ontarget.phase4
				assignedUsers.add(assignedToUser);
			}
		} else {
			logger.info("task is unassigned");
		}

<<<<<<< HEAD
=======
		//
		//
		// if (assignedUserId > 0) {
		// User assignedToUser = new User();
		// assignedToUser.setUserId(assignedUserId.intValue());
		// task.setAssignedTo(assignedToUser);
		// }
		// else {
		// logger.info("task is unassigned");
		// }
>>>>>>> origin/ontarget.phase4
		setTaskLevel(task, 1);
		return task;
	}

<<<<<<< HEAD
	public List<ProjectTask> setTaskLevel(ProjectTask task, int level)
			throws Exception {
		List<ProjectTask> childTasks = taskDAO.getChildTasks(task
				.getProjectTaskId());
		if (level < 20 && childTasks != null && !childTasks.isEmpty()) {
			level++;
			for (ProjectTask p : childTasks) {
=======
	public List<Task> setTaskLevel(Task task, int level) throws Exception {
		List<Task> childTasks = taskDAO.getChildTasks(task.getProjectTaskId());
		if (level < 20 && childTasks != null && !childTasks.isEmpty()) {
			level++;
			for (Task p : childTasks) {
>>>>>>> origin/ontarget.phase4
				setTaskLevel(p, level);
			}
		}

		task.setChildTasks(childTasks);
		return childTasks;
	}

	@Override
	public List<TaskStatusCount> getTaskCountByStatus(int projectId)
			throws Exception {
		return taskDAO.getTaskCountByStatus(projectId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
<<<<<<< HEAD
	public Contact addTaskComment(TaskCommentRequest comment) throws Exception {
=======
	public Contact addTaskComment(TaskComment comment) throws Exception {
>>>>>>> origin/ontarget.phase4
		if (comment.getTaskCommentId() > 0) {
			if (taskDAO.updateComment(comment)) {
				Contact contact = contactDAO.getContact(comment
						.getCommentedBy());
				return contact;
			} else
				throw new Exception("task not updated");
		} else {
			int taskCommentId = taskDAO.addComment(comment);
			if (taskCommentId > 0) {
				Contact contact = contactDAO.getContact(comment
						.getCommentedBy());
				return contact;
			} else {
				throw new Exception("Task not added");
			}
		}

	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
<<<<<<< HEAD
	public boolean updateTaskStatus(int taskId, String taskStatus, int userId)
=======
	public boolean updateTaskStatus(long taskId, String taskStatus, int userId)
>>>>>>> origin/ontarget.phase4
			throws Exception {
		return taskDAO.updateTaskStatus(taskId, taskStatus, userId);
	}

	@Override
<<<<<<< HEAD
	public Set<Integer> getTaskMembers(int taskId) throws Exception {
=======
	public Set<Long> getTaskMembers(long taskId) throws Exception {
>>>>>>> origin/ontarget.phase4
		return taskDAO.getTaskMembers(taskId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addTaskMember(int projectId, int taskId, int memberId)

			throws Exception {
		return taskDAO.addTaskMember(projectId, taskId, memberId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public long saveTaskFile(int taskid, int userId, String fileName,
			String location) throws Exception {
		return projectTaskFileDAO.saveTaskFile(taskid, fileName, userId,
				location);
	}

	@Override
	public List<FileAttachment> getTaskAttachments(int taskId) throws Exception {

		List<FileAttachment> taskAttachments = projectTaskFileDAO
				.getTaskAttachments(taskId);
		Map<Long, Contact> contactSet = new HashMap<>();
		for (FileAttachment fileAttachment : taskAttachments) {
			long userId = fileAttachment.getUserId();
			if (contactSet.containsKey(userId)) {
				fileAttachment.setContact(contactSet.get(userId));
			} else {
				Contact c = contactDAO.getContact(userId);
				contactSet.put(userId, c);
				fileAttachment.setContact(c);
			}
		}

		return taskAttachments;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void assignTaskToUser(int taskId, List<Integer> users,
			int assigningUser) throws Exception {
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

}
