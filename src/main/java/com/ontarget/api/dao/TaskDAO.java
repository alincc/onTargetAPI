package com.ontarget.api.dao;

import com.ontarget.bean.Task;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/6/14.
 */
public interface TaskDAO {

    public int addTask(Task task) throws  Exception;

    public List<Task> getTask(int projectId) throws Exception;

    public Map<String,Integer> getTaskCountByStatus(int projectId) throws Exception;
}
