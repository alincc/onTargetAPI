package com.ontarget.api.dao;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetDAO {

    public Map<String, Object> getMinStartMaxEndDate(int projectId, String costType) throws Exception;


    public Map<Task,List<TaskEstimatedCost>> getTaskToCostMap(int projectId,String costType) throws Exception;


    List<TaskEstimatedCost> getTaskCostByTask(int projectTaskId) throws Exception;
}
