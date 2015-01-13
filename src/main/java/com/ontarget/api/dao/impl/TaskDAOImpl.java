package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * Created by Owner on 11/6/14.
 */
@Repository
public class TaskDAOImpl implements TaskDAO {

    private Logger logger = Logger.getLogger(AddressDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addTask(Task task, int userId) throws Exception {

        logger.info("Adding address: " + task);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_TASK, new String[]{"id"});
                        ps.setInt(1, task.getProject().getProjectId());
                        ps.setString(2, task.getTitle());
                        ps.setString(3, task.getDescription());
                        ps.setInt(4, task.getParentTask().getProjectTaskId());

                        ps.setInt(4, 0);
                        ps.setString(5, task.getStatus());
                        ps.setString(6, task.getSeverity());
                        ps.setDate(7, new java.sql.Date(task.getStartDate().getTime()));
                        ps.setDate(8, new java.sql.Date(task.getEndDate().getTime()));

                        ps.setInt(9, userId);
                        ps.setInt(10, userId);

                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added address with id: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Task> getTask(int projectId) throws Exception {
        List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK, new Object[]{projectId});
        List<Task> tasks = new ArrayList<>();
        if (taskList != null && taskList.size() > 0) {
            for (Map<String, Object> taskMap : taskList) {
                Task task = new Task();
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

    public List<Task> getChildTasks(int taskId) throws Exception {
        List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_CHILD_TASKS, new Object[]{taskId});
        List<Task> tasks = new ArrayList<>();
        if (taskList != null && taskList.size() > 0) {
            for (Map<String, Object> taskMap : taskList) {
                Task task = new Task();
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
        List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_TASK_COUNT_BY_STATUS, new Object[]{projectId});
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
    public boolean updateComment(TaskComment comment) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_COMMENT, new Object[]{comment.getTaskCommentId(), comment.getComment(), comment.getCommentedBy()});
        if (row == 0) {
            throw new Exception("Unable to update task comment");
        }
        return true;
    }

    @Override
    public int addComment(TaskComment comment) throws Exception {
        logger.info("Adding task comment: " + comment);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_TASK_COMMENT, new String[]{"id"});
                        ps.setInt(1, comment.getTaskId());
                        ps.setString(2, comment.getComment());
                        ps.setInt(3, comment.getCommentedBy());

                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added task comment with id: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }

    public int addDependentTask(DependentTask dependentTask) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.DependentTask.ADD_DEPENDENT_TASK, new String[]{"id"});
                        ps.setInt(1, dependentTask.getTaskId());
                        ps.setInt(2, dependentTask.getDependentTaskId());
                        ps.setInt(3, dependentTask.getCategory_id());
                        ps.setInt(4, dependentTask.getCreatedBy());

                        return ps;
                    }
                },
                keyHolder);
        return keyHolder.getKey().intValue();
    }

    @Override
    public List<Task> getTask(int projectId, int completed) throws Exception {
        List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_TASK_BY_PROJECT_BY_STATUS, new Object[]{projectId, completed});
        List<Task> tasks = new ArrayList<>();
        if (taskList != null && taskList.size() > 0) {
            for (Map<String, Object> taskMap : taskList) {
                Task task = new Task();
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
        List<Map<String, Object>> taskList = jdbcTemplate.queryForList(OnTargetQuery.GET_TASK_COMMENT, new Object[]{projectTaskId});
        List<TaskComment> comments = new ArrayList<>();
        if (taskList != null && taskList.size() > 0) {
            for (Map<String, Object> commentMap : taskList) {
                TaskComment comment = new TaskComment();
                comment.setTaskCommentId((Integer) commentMap.get("task_comment_id"));
                comment.setTaskId((Integer) commentMap.get("task_id"));
                comment.setComment((String) commentMap.get("comment"));
                comment.setCommentedBy((Integer)commentMap.get("commented_by"));
                comment.setCommentedDate((Date) commentMap.get("commented_date"));
                comments.add(comment);
            }
        }

        return comments;
    }

    @Override
    public boolean updateTask(Task task, int userId) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK, new Object[]{task.getTitle(), task.getDescription(), task.getParentTask().getProjectTaskId(), task.getStatus(), task.getStartDate(), task.getEndDate(), task.getPercentageComplete(), task.getSeverity(), userId, task.getProjectTaskId()});
        if (row == 0) {
            throw new Exception("Unable to update task comment");
        }

        return true;
    }

    @Override
    public boolean updateTaskStatus(long taskId, String taskStatus, int userId) throws Exception {
        int updates = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_STATUS, new Object[]{taskStatus, userId, taskId});
        return updates > 0;
    }

    public Set<Long> getTaskMembers(long taskId) throws Exception {
        List<Long> users = jdbcTemplate.queryForList(OnTargetQuery.GET_TASK_MEMBERS, Long.class, new Object[]{taskId});
        return new HashSet<Long>(users);
    }

    public boolean addTaskMember(long projectId, long taskId, long memberId) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.ADD_TASK_MEMBER, new Object[]{taskId, projectId, memberId});
        return row > 0;
    }

    @Override
    public boolean assignTaskToUser(long taskId, long userId) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.ASSIGN_TASK_USER, new Object[]{taskId, userId});
        return row > 0;
    }

    @Override
    public boolean updateTaskAssignee(long taskId, long userId) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_TASK_USER, new Object[]{userId, taskId});
        return row > 0;
    }

    @Override
    public Long getAssignedUser(long taskId) throws Exception {
        User user = new User();
       jdbcTemplate.query(OnTargetQuery.GET_TASK_ASSIGNEE, new Object[]{taskId}, new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                user.setUserId(resultSet.getInt("task_assignee"));
                return null;
            }
        });
        return new Long(user.getUserId());
    }

    @Override
    public Task getTaskDetail(long taskId) throws Exception {
        Task task = new Task();
        jdbcTemplate.query(OnTargetQuery.GET_TASK, new Object[]{taskId}, new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                task.setProjectTaskId(resultSet.getInt("project_task_id"));
                Project project=new Project();
                project.setProjectId(resultSet.getInt("project_id"));
                task.setProject(project);
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
    public List<Task> getDependentTasks(long taskId) throws Exception {
        List<Task> tasks = new LinkedList<>();
        jdbcTemplate.query(OnTargetQuery.DependentTask.GET_DEPENDENT_TASK, new Object[]{taskId}, new RowMapper<Void>() {
            @Override
            public Void mapRow(ResultSet resultSet, int i) throws SQLException {
                Task task = new Task();
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
}
