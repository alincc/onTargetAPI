package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.bean.Contact;
import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskObj;
import com.ontarget.bean.TaskPercentage;
import com.ontarget.bean.TaskStatusCount;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.dto.ProjectTask;
import com.ontarget.entities.TaskFieldWorker;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;

/**
 * Created by Owner on 11/6/14.
 */
@Repository("taskDAOImpl")
public class TaskDAOImpl implements TaskDAO {

	private Logger logger = Logger.getLogger(AddressDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addTask(Task task, int userId) throws Exception {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.ADD_TASK, new String[] { "id" });
				ps.setLong(1, task.getProjectId());
				ps.setString(2, task.getTitle());
				ps.setString(3, task.getDescription());
				ps.setInt(4, 0);
				ps.setString(5, task.getStatus());
				ps.setString(6, task.getSeverity());
				ps.setDate(7, task.getStartDate());
				ps.setDate(8, task.getEndDate());
				ps.setInt(9, userId);
				ps.setInt(10, userId);
				return ps;
			}
		}, keyHolder);
		logger.debug("Added task with id: " + keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<TaskInfo> getTask(int projectId) throws Exception {
		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK, new Object[] { projectId });
		List<TaskInfo> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (Map<String, Object> taskMap : taskList) {
				TaskInfo task = new TaskInfo();
				task.setTitle((String) taskMap.get("title"));
				task.setDescription((String) taskMap.get("description"));
				task.setStatus((String) taskMap.get("status"));
				task.setSeverity((String) taskMap.get("severity"));
				task.setProjectTaskId((Integer) taskMap.get("project_task_id"));
				task.setStartDate((Date) taskMap.get("start_date"));
				task.setEndDate((Date) taskMap.get("end_date"));
				task.setStatus((String) taskMap.get("status"));

				long status = (Long) taskMap.get("completed");
				if (status == 0) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;
	}

	@Override
	public List<TaskObj> getTaskObjList(int projectId) throws Exception {
		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK, new Object[] { projectId });
		List<TaskObj> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (Map<String, Object> taskMap : taskList) {
				TaskObj task = new TaskObj();
				task.setTitle((String) taskMap.get("title"));
				task.setDescription((String) taskMap.get("description"));
				task.setStatus((String) taskMap.get("status"));
				task.setSeverity((String) taskMap.get("severity"));
				task.setProjectTaskId((Integer) taskMap.get("project_task_id"));
				task.setStartDate((Date) taskMap.get("start_date"));
				task.setEndDate((Date) taskMap.get("end_date"));
				task.setStatus((String) taskMap.get("status"));

				long status = (Long) taskMap.get("completed");
				if (status == 0) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;
	}

//	@Override
//	public List<ProjectTask> getTasksByProjectAndUser(int projectId,int userId) throws Exception {
//		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK, new Object[] { projectId });
//		List<ProjectTask> tasks = new ArrayList<>();
//		if (taskList != null && taskList.size() > 0) {
//			for (Map<String, Object> taskMap : taskList) {
//				ProjectTask task = new ProjectTask();
//				task.setTitle((String) taskMap.get("title"));
//				task.setDescription((String) taskMap.get("description"));
//				task.setStatus((String) taskMap.get("status"));
//				task.setSeverity((String) taskMap.get("severity"));
//				task.setProjectTaskId((Integer) taskMap.get("project_task_id"));
//				task.setStartDate((Date) taskMap.get("start_date"));
//				task.setEndDate((Date) taskMap.get("end_date"));
//				task.setStatus((String) taskMap.get("status"));
//
//				long status = (Long) taskMap.get("completed");
//				if (status == 0) {
//					task.setCompleted(false);
//				} else {
//					task.setCompleted(true);
//				}
//				tasks.add(task);
//			}
//		}
//		return tasks;
//	}

	public List<ProjectTask> getChildTasks(int taskId) throws Exception {
		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_CHILD_TASKS, new Object[] { taskId });
		List<ProjectTask> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (Map<String, Object> taskMap : taskList) {
				ProjectTask task = new ProjectTask();
				task.setTitle((String) taskMap.get("title"));
				task.setDescription((String) taskMap.get("description"));
				task.setStatus((String) taskMap.get("status"));
				task.setSeverity((String) taskMap.get("severity"));
				task.setProjectTaskId((Integer) taskMap.get("project_task_id"));
				task.setStartDate((Date) taskMap.get("start_date"));
				task.setEndDate((Date) taskMap.get("end_date"));
				task.setStatus((String) taskMap.get("status"));

				long status = (Long) taskMap.get("completed");
				if (status == 0) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;
	}

	@Override
	public List<TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception {
		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK_COUNT_BY_STATUS,
				new Object[] { projectId });
		List<TaskStatusCount> taskCountByStatus = new ArrayList<>();

		if (taskList != null && taskList.size() > 0) {
			for (Map<String, Object> taskMap : taskList) {
				TaskStatusCount count = new TaskStatusCount();
				count.setStatusType((String) taskMap.get("status_name"));
				count.setTaskCount((Long) taskMap.get("count"));
				taskCountByStatus.add(count);
			}
		}
		return taskCountByStatus;
	}

	@Override
	public boolean updateComment(TaskCommentRequest comment) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_COMMENT, new Object[] { comment.getTaskCommentId(), comment.getComment(),
				comment.getCommentedBy() });
		if (row == 0) {
			throw new Exception("Unable to update task comment");
		}
		return true;
	}

	@Override
	public int addComment(TaskCommentRequest comment) throws Exception {
		logger.info("Adding task comment: " + comment);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.ADD_TASK_COMMENT, new String[] { "id" });
				ps.setInt(1, comment.getTaskId());
				ps.setString(2, comment.getComment());
				ps.setInt(3, comment.getCommentedBy());

				return ps;
			}
		}, keyHolder);
		logger.debug("Added task comment with id: " + keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}

	public int addDependentTask(DependentTaskDTO dependentTask) throws Exception {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.DependentTask.ADD_DEPENDENT_TASK, new String[] { "id" });
				ps.setInt(1, dependentTask.getTaskId());
				ps.setInt(2, dependentTask.getDependentTaskId());
				ps.setInt(3, dependentTask.getCategory_id());
				ps.setInt(4, dependentTask.getCreatedBy());

				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public List<TaskInfo> getTask(int projectId, int completed) throws Exception {
		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_TASK_BY_PROJECT_BY_STATUS, new Object[] {
				projectId, projectId, completed });
		List<TaskInfo> tasks = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (Map<String, Object> taskMap : taskList) {
				TaskInfo task = new TaskInfo();
				task.setTitle((String) taskMap.get("title"));
				task.setDescription((String) taskMap.get("description"));
				task.setStatus((String) taskMap.get("status"));
				task.setSeverity((String) taskMap.get("severity"));
				task.setProjectTaskId((Integer) taskMap.get("project_task_id"));
				task.setStartDate((Date) taskMap.get("start_date"));
				task.setEndDate((Date) taskMap.get("end_date"));
				task.setStatus((String) taskMap.get("status"));

				long status = (Long) taskMap.get("completed");
				if (status == 0) {
					task.setCompleted(false);
				} else {
					task.setCompleted(true);
				}
				tasks.add(task);
			}
		}

		return tasks;

	}

	@Override
	public List<TaskComment> getTaskComments(int projectTaskId) throws Exception {
		List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_TASK_COMMENT, new Object[] { projectTaskId });
		List<TaskComment> comments = new ArrayList<>();
		if (taskList != null && taskList.size() > 0) {
			for (Map<String, Object> commentMap : taskList) {
				TaskComment comment = new TaskComment();
				comment.setTaskCommentId((Integer) commentMap.get("task_comment_id"));
				comment.setTaskId((Integer) commentMap.get("task_id"));
				comment.setComment((String) commentMap.get("comment"));
				comment.setCommentedBy((Integer) commentMap.get("commented_by"));
				comment.setCommentedDate((Date) commentMap.get("commented_date"));
				comments.add(comment);
			}
		}

		return comments;
	}

	@Override
	public boolean updateTask(Task task, int userId) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK, new Object[] { task.getTitle(), task.getDescription(), 0,
				task.getStatus(), task.getStartDate(), task.getEndDate(), task.getSeverity(), userId, task.getProjectTaskId() });
		if (row == 0) {
			throw new Exception("Unable to update task comment");
		}
		return true;
	}

	@Override
	public boolean updateTaskStatus(int taskId, String taskStatus, int userId) throws Exception {
		int updates = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_STATUS, new Object[] { taskStatus, userId, taskId });
		return updates > 0;
	}

	public Set<Integer> getTaskMembers(int taskId) throws Exception {
		List<Integer> users = jdbcTemplate.queryForList(OnTargetQuery.GET_TASK_ASSIGNEE, Integer.class, new Object[] { taskId });
		return new HashSet<Integer>(users);
	}

	public boolean addTaskMember(int projectId, int taskId, int memberId) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.ADD_TASK_MEMBER, new Object[] { taskId, projectId, memberId });
		return row > 0;
	}

	public boolean deleteAllTaskAssignedUsers(int taskId) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.DELETE_TASK_USER, new Object[] { taskId });
		return row > 0;
	}

	@Override
	public boolean updateTaskAssignee(int taskId, int userId, int assigningUser) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_USER, new Object[] { userId, assigningUser, taskId });
		return row > 0;
	}

	@Override
	public Integer getAssignedUser(int taskId) throws Exception {
		UserDTO user = new UserDTO();
		jdbcTemplate.query(OnTargetQuery.GET_TASK_ASSIGNEE, new Object[] { taskId }, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet resultSet, int i) throws SQLException {
				user.setUserId(resultSet.getInt("task_assignee"));
				return null;
			}
		});

		return user.getUserId();
	}

	@Override
	public ProjectTaskInfo getTaskInfo(int taskId) throws Exception {
		ProjectTaskInfo task = new ProjectTaskInfo();
		jdbcTemplate.query(OnTargetQuery.GET_TASK, new Object[] { taskId }, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet resultSet, int i) throws SQLException {
				task.setProjectTaskId(resultSet.getInt("project_task_id"));
				task.setProjectId(resultSet.getInt("project_id"));
				task.setTitle(resultSet.getString("title"));
				task.setStatus(resultSet.getString("status"));
				task.setStartDate(resultSet.getDate("start_date"));
				task.setEndDate(resultSet.getDate("end_date"));
				task.setDescription(resultSet.getString("description"));
				task.setSeverity(resultSet.getString("severity"));
				return null;
			}
		});

		return task;
	}

	@Override
	public ProjectTask getTaskDetail(int taskId) throws Exception {
		ProjectTask task = new ProjectTask();
		jdbcTemplate.query(OnTargetQuery.GET_TASK, new Object[] { taskId }, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet resultSet, int i) throws SQLException {
				task.setProjectTaskId(resultSet.getInt("project_task_id"));
				ProjectTask project = new ProjectTask();
				task.setTitle(resultSet.getString("title"));
				task.setStatus(resultSet.getString("status"));
				task.setStartDate(resultSet.getDate("start_date"));
				task.setEndDate(resultSet.getDate("end_date"));
				task.setDescription(resultSet.getString("description"));
				task.setSeverity(resultSet.getString("severity"));
				return null;
			}
		});

		return task;
	}

	@Override
	public List<ProjectTask> getDependentTasks(int taskId) throws Exception {
		List<ProjectTask> tasks = new LinkedList<>();
		jdbcTemplate.query(OnTargetQuery.DependentTask.GET_DEPENDENT_TASK, new Object[] { taskId }, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet resultSet, int i) throws SQLException {
				ProjectTask task = new ProjectTask();
				task.setProjectTaskId(resultSet.getInt("project_task_id"));
				task.setTitle(resultSet.getString("title"));
				task.setStatus(resultSet.getString("status"));
				task.setStartDate(resultSet.getDate("start_date"));
				task.setEndDate(resultSet.getDate("end_date"));
				task.setDescription(resultSet.getString("description"));
				task.setSeverity(resultSet.getString("severity"));
				tasks.add(task);

				return null;
			}
		});

		return tasks;
	}

	@Override
	public List<ProjectTask> getUserTasks(int userId) throws Exception {
		List<ProjectTask> tasks = new LinkedList<>();
		jdbcTemplate.query(OnTargetQuery.GET_USER_TASKS, new Object[] { userId }, new RowMapper<Void>() {
			@Override
			public Void mapRow(ResultSet resultSet, int i) throws SQLException {
				ProjectTask task = new ProjectTask();
				task.setProjectTaskId(resultSet.getInt("project_task_id"));
				task.setTitle(resultSet.getString("title"));
				task.setStatus(resultSet.getString("status"));
				task.setStartDate(resultSet.getDate("start_date"));
				task.setEndDate(resultSet.getDate("end_date"));
				task.setDescription(resultSet.getString("description"));
				task.setSeverity(resultSet.getString("severity"));
				tasks.add(task);

				return null;
			}
		});

		return tasks;
	}

	@Override
	public List<TaskInfo> getAssignedTasksByProjectId(int projectId, int userId) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean deleteTask(int taskId, int userId) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public com.ontarget.entities.ProjectTask getProjectTaskById(int projectTaskId) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean assignTaskToFieldworker(int taskId, int userId, List<Integer> fieldWorkerIds) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<TaskFieldWorker> getTaskFieldWorkersByTask(int taskId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> assignTaskToUser(int taskId, int userId, List<Integer> assignees) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.ontarget.entities.ProjectTask> getProjectTaskByProjectId(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContact(int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPercentage> getTaskPercentageByTask(int projectTaskId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public int getCompletedTaskCount(int projectId) throws Exception {
        return 0;
    }

    @Override
	public List<ProjectTask> getTasksByActivityAndUser(int projectId, int userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
