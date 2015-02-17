package com.ontarget.api.dao;

import com.ontarget.bean.TaskDTO;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetDAO {

    public Map<String, Object> getMinStartMaxEndDate(long projectId, String costType) throws Exception;


    public Map<TaskDTO,List<TaskEstimatedCost>> getTaskToCostMap(long projectId,String costType) throws Exception;


    Map<TaskDTO, Map<TaskInterval,TaskEstimatedCost>> getTaskToCostMapByMonthYear(int projectId, String costType) throws Exception;

    Map<TaskDTO, Map<TaskInterval, List<TaskEstimatedCost>>> getTaskCostMapByTask(int projectTaskId) throws Exception;

    TaskDTO getTaskCostByTask(TaskDTO task) throws Exception;

    Map<TaskInterval, List<TaskEstimatedCost>> getTaskCostByTaskMonthYear(int projectTaskId) throws Exception;
}
