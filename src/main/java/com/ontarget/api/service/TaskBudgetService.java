package com.ontarget.api.service;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;

/**
 * Created by Owner on 11/22/14.
 */
public interface TaskBudgetService {

	public List<TaskInterval> getTaskIntervals(int projectId) throws Exception;

	public Map<ProjectTaskInfo, List<TaskEstimatedCost>> getTaskCostByMonthAndYear(
			int projectId) throws Exception;

	public boolean addTaskBudget(List<TaskEstimatedCost> costs)
			throws Exception;

	public boolean updateTaskBudget(List<TaskEstimatedCost> costs)
			throws Exception;

	public ProjectTaskInfo getTaskBudgetByTaskAndMonthYear(int taskId)
			throws Exception;
}
