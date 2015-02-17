package com.ontarget.api.dao;

import java.util.List;
import java.util.Set;

import com.ontarget.bean.DependentTaskDTO;
import com.ontarget.bean.TaskComment;
import com.ontarget.bean.TaskDTO;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskCommentRequest;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskDAO {

    public int addTask(Task task, int userId) throws Exception;

    public List<TaskDTO> getTask(int projectId) throws Exception;

    public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception;

    public boolean updateComment(TaskCommentRequest comment) throws Exception;

    public int addComment(TaskCommentRequest comment) throws Exception;

    public List<TaskComment> getTaskComments(int projectTaskId) throws Exception;

    public boolean updateTask(Task task, int userId) throws Exception;

    public boolean updateTaskStatus(int taskId, String taskStatus, int userId) throws Exception;

    public Set<Integer> getTaskMembers(int taskId) throws Exception;

    public boolean addTaskMember(int projectId, int taskId, int memberId) throws Exception;

    public boolean deleteAllTaskAssignedUsers(int taskId) throws Exception;

    public boolean assignTaskToUser(int taskId, int userId, int assigningUser) throws Exception;

    boolean updateTaskAssignee(int taskId, int userId, int assigningUser) throws Exception;

    public Integer getAssignedUser(int taskId) throws Exception;

    public TaskDTO getTaskDetail(int taskId) throws Exception;

    public List<TaskDTO> getChildTasks(int taskId) throws Exception;

    public List<TaskDTO> getDependentTasks(int taskId) throws Exception;

    public List<TaskDTO> getUserTasks(int userId) throws Exception;

    public int addDependentTask(DependentTaskDTO dependentTask) throws Exception;

    public List<TaskDTO> getTask(int projectId, int completed) throws Exception;
}
