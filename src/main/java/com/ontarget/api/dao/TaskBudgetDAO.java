package com.ontarget.api.dao;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInfo;
import com.ontarget.bean.TaskInterval;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetDAO {

    public Map<String, Object> getMinStartMaxEndDate(long projectId, String costType) throws Exception;


    public Map<ProjectTaskInfo,List<TaskEstimatedCost>> getTaskToCostMap(long projectId,String costType) throws Exception;


    Map<TaskInfo, Map<TaskInterval,TaskEstimatedCost>> getTaskToCostMapByMonthYear(int projectId, String costType) throws Exception;

    Map<TaskInfo, Map<TaskInterval, List<TaskEstimatedCost>>> getTaskCostMapByTask(int projectTaskId) throws Exception;

    TaskInfo getTaskCostByTask(TaskInfo task) throws Exception;

    Map<TaskInterval, List<TaskEstimatedCost>> getTaskCostByTaskMonthYear(int projectTaskId) throws Exception;
}
