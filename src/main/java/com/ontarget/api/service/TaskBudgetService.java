package com.ontarget.api.service;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetService {

   public  List<TaskInterval> getTaskIntervals(int projectId) throws Exception;

   public Map<Task, List<TaskEstimatedCost>> getTaskCostByMonthAndYear(int projectId) throws Exception;

   public boolean addTaskBudget(List<TaskEstimatedCost> costs) throws  Exception;

    public boolean updateTaskBudget(List<TaskEstimatedCost> costs) throws  Exception;

    List<TaskEstimatedCost> getTaskBudgetByTask(int taskId) throws Exception;
}
