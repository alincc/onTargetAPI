package com.ontarget.api.dao;

import com.ontarget.bean.Task;

import java.util.List;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskDAO {

    public int addTask(Task task) throws  Exception;

    public List<Task> getTask(int projectId) throws Exception;

}
