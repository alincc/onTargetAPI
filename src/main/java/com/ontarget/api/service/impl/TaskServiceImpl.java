package com.ontarget.api.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

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
import com.ontarget.bean.TaskDTO;
import com.ontarget.bean.TaskStatusCount;
import com.ontarget.bean.UserDTO;
import com.ontarget.dto.ProjectTask;
import com.ontarget.request.bean.ParentTask;
import com.ontarget.request.bean.Project;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;
import com.ontarget.util.DateConverter;

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

	private static final SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final TimeZone cst = TimeZone.getTimeZone("America/Chicago");

	static {
		format.setTimeZone(cst);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean addTaskService(Task task, int userId) throws Exception {
		logger.info("Add/Update task: " + task);

		int taskId = task.getProjectTaskId();
		// validate times
		Date startDate = task.getStartDate();
		Date endDate = task.getEndDate();
		if (task.getProject() == null) {
			throw new Exception("task project is null");
		} else {
			Date projectStartDate = task.getProject().getStartDate();
			Date projectEndDate = task.getProject().getEndDate();
			if (projectStartDate == null || projectEndDate == null) {
				ProjectDTO projectDTO = projectDAO.getProject(task.getProject()
						.getProjectId());
				logger.info("start and end date of project is null so getting new project "
						+ projectDTO.toString());
				if (projectDTO == null) {
					throw new Exception("project is invalid for task");
				}

				Project project = new Project();
				project.setProjectId(projectDTO.getProjectId());
				project.setStartDate(DateConverter.convertUtilToSql(projectDTO
						.getStartDate()));
				project.setEndDate(DateConverter.convertUtilToSql(projectDTO
						.getEndDate()));

				task.setProject(project);
				projectStartDate = project.getStartDate();
				projectEndDate = project.getEndDate();
			}

		}

		ParentTask parentTask = task.getParentTask();
		if (parentTask != null) {
			Date parentTaskStartDate = parentTask.getStartDate();
			Date parentTaskEndDate = parentTask.getEndDate();
			if (parentTaskStartDate == null || parentTaskEndDate == null) {
				ProjectTask parentTaskDTO = taskDAO.getTaskDetail(parentTask
						.getProjectTaskId());
				if (parentTaskDTO == null) {
					throw new Exception("parent task does not exists");
				}

				parentTaskStartDate = parentTaskDTO.getStartDate();
				parentTaskEndDate = parentTaskDTO.getEndDate();
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

		// add project task assignee.

		return true;
	}

	public boolean isTaskAdd(Task task) {
		int taskId = task.getProjectTaskId();
		return isTaskAdd(taskId);
	}

	private boolean isTaskAdd(int taskId) {
		return taskId <= 0;
	}

	@Override
	public List<TaskDTO> getTask(Integer projectId) throws Exception {
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
				assignedUsers.add(assignedToUser);
			}
		} else {
			logger.info("task is unassigned");
		}

		setTaskLevel(task, 1);
		return task;
	}

	public List<ProjectTask> setTaskLevel(ProjectTask task, int level) throws Exception {
		List<ProjectTask> childTasks = taskDAO.getChildTasks(task
				.getProjectTaskId());
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
	public List<TaskStatusCount> getTaskCountByStatus(int projectId)
			throws Exception {
		return taskDAO.getTaskCountByStatus(projectId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public Contact addTaskComment(TaskCommentRequest comment) throws Exception {
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
	public boolean updateTaskStatus(int taskId, String taskStatus, int userId)
			throws Exception {
		return taskDAO.updateTaskStatus(taskId, taskStatus, userId);
	}

	@Override
	public Set<Integer> getTaskMembers(int taskId) throws Exception {
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
			TaskDTO task = taskDAO.getTaskInfo(taskId);
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
