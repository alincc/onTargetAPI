package com.ontarget.api.service;

import com.ontarget.bean.Task;

import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskService {

    public boolean addTaskService(Task task) throws Exception;

    public List<Task> getTask(int projectId) throws Exception;

}
