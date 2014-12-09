package com.ontarget.api.service;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskComment;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskService {

    public long addTaskService(Task task) throws Exception;

    public List<Task> getTask(int projectId) throws Exception;

    public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception;

    boolean addTaskComment(TaskComment comment) throws Exception;

    public boolean updateTaskStatus(long taskId, String taskStatus) throws Exception;

    public Set<Long> getTaskMembers(long taskId) throws Exception;

    public boolean addTaskMember(long projectId, long taskId, long memberId) throws Exception;
}
