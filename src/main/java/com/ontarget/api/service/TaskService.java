package com.ontarget.api.service;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskComment;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskService {

    public boolean addTaskService(Task task) throws Exception;

    public List<Task> getTask(int projectId) throws Exception;

    public Map<String,Integer> getTaskCountByStatus(int projectId) throws Exception;

    boolean addTaskComment(TaskComment comment) throws Exception;
}
