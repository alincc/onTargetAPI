package com.ontarget.api.dao;

import com.ontarget.bean.DependentTask;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskComment;

import java.util.List;
import java.util.Set;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskDAO {

    public int addTask(Task task, int userId) throws Exception;

    public List<Task> getTask(int projectId) throws Exception;

    public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception;

    public boolean updateComment(TaskComment comment) throws Exception;

    public int addComment(TaskComment comment) throws Exception;

    public List<TaskComment> getTaskComments(int projectTaskId) throws Exception;

    public boolean updateTask(Task task, int userId) throws Exception;

    public boolean updateTaskStatus(long taskId, String taskStatus, int userId) throws Exception;

    public Set<Long> getTaskMembers(long taskId) throws Exception;

    public boolean addTaskMember(long projectId, long taskId, long memberId) throws Exception;

    public boolean assignTaskToUser(long taskId, long userId, int assigningUser) throws Exception;

    boolean updateTaskAssignee(long taskId, long userId, int assigningUser) throws Exception;

    Long getAssignedUser(long taskId) throws Exception;

    public Task getTaskDetail(long taskId) throws Exception;

    public List<Task> getChildTasks(int taskId) throws Exception;

    public List<Task> getDependentTasks(long taskId) throws Exception;

    public int addDependentTask(DependentTask dependentTask) throws Exception;

    public List<Task> getTask(int projectId, int completed) throws Exception;
}
