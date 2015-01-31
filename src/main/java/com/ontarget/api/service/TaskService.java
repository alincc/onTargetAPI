package com.ontarget.api.service;

import com.ontarget.bean.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskService {

    public boolean addTaskService(Task task, int userId) throws Exception;

    public List<Task> getTask(int projectId) throws Exception;

    public boolean isTaskAdd(Task task);

    public int addDependentTask(DependentTask dependentTask) throws Exception;

    public Task getTaskDetail(int taskId) throws Exception;

    public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception;

    Contact addTaskComment(TaskComment comment) throws Exception;

    public boolean updateTaskStatus(long taskId, String taskStatus, int userId) throws Exception;

    public Set<Long> getTaskMembers(long taskId) throws Exception;

    public boolean addTaskMember(long projectId, long taskId, long memberId) throws Exception;

    public long saveTaskFile(long taskid, long userId, String fileName, String location) throws Exception;

    public List<FileAttachment> getTaskAttachments(long taskId) throws Exception;

    public void assignTaskToUser(long taskId, List<Long> users, int assigningUser) throws Exception;

    public List<Task> getDependentTasks(long taskId) throws Exception;

    public List<Task> getUserTasks(int userId) throws Exception;
}
