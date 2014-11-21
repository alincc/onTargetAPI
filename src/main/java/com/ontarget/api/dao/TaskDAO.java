package com.ontarget.api.dao;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskComment;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskDAO {

    public int addTask(Task task) throws  Exception;

    public List<Task> getTask(int projectId) throws Exception;

    public List<com.ontarget.bean.TaskStatusCount> getTaskCountByStatus(int projectId) throws Exception;

    public boolean updateComment(TaskComment comment) throws Exception;

    public int addComment(TaskComment comment) throws Exception;

    public List<TaskComment> getTaskComments(int projectTaskId) throws Exception;

    public boolean updateTask(Task task) throws Exception;
}
