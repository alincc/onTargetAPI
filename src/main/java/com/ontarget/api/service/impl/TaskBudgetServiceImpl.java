package com.ontarget.api.service.impl;

import com.ontarget.api.dao.TaskBudgetDAO;
import com.ontarget.api.dao.TaskDAO;
import com.ontarget.api.dao.TaskEstimatedCostDAO;
import com.ontarget.api.service.TaskBudgetService;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskEstimatedCostByMonthYear;
import com.ontarget.bean.TaskInterval;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Owner on 11/22/14.
 */
@Service
public class TaskBudgetServiceImpl implements TaskBudgetService {

    private Logger logger = Logger.getLogger(TaskBudgetServiceImpl.class);

    @Autowired
    private TaskBudgetDAO taskBudgetDAO;

    @Autowired
    private TaskEstimatedCostDAO taskPlannedEstimatedCostDAO;

    @Autowired
    TaskDAO taskDAO;


    @Override
    public List<TaskInterval> getTaskIntervals(int projectId) throws Exception {
        logger.info("Getting yearly intervals of task for " + projectId);
        Map<String, Object> taskIntervalMap = taskBudgetDAO.getMinStartMaxEndDate(projectId, OnTargetConstant.CostType.PLANNED);
        List<TaskInterval> taskIntervals = new ArrayList<>();
        if (!taskIntervalMap.isEmpty()) {

            Date minDate = (Date) taskIntervalMap.get("min_date");
            Date maxDate = (Date) taskIntervalMap.get("max_date");

            int minYear = 0;
            int maxYear = 0;
            if (minDate != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(minDate);
                minYear = cal.get(Calendar.YEAR);
            }

            if (maxDate != null) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(maxDate);
                minYear = cal.get(Calendar.YEAR);
            }

            for (int i = minYear; i <= maxYear; i++) {
                TaskInterval taskInterval = new TaskInterval();
                taskInterval.setYear(i);
                taskIntervals.add(taskInterval);
            }
        }
        return taskIntervals;
    }

    @Override
    public Map<Task, List<TaskEstimatedCost>> getTaskCostByMonthAndYear(int projectId) throws Exception {
        logger.debug("Getting task cost by month and year for project: " + projectId);
        return taskBudgetDAO.getTaskToCostMap(projectId, OnTargetConstant.CostType.PLANNED);
    }

    @Override
    public boolean addTaskBudget(List<TaskEstimatedCost> costs) throws Exception {
        logger.debug("Adding task budget: " + costs);
        if (costs != null && costs.size() > 0) {
            for (TaskEstimatedCost taskEstimatedCost : costs) {
                int id = taskPlannedEstimatedCostDAO.addPlannedAcutalCost(taskEstimatedCost);
                if (id <= 0) {
                    throw new Exception("Error while adding task budget by month" + taskEstimatedCost);
                }
            }
        }

        return true;
    }

    @Override
    public boolean updateTaskBudget(List<TaskEstimatedCost> costs) throws Exception {
        logger.debug("Updating task budget: " + costs);
        if (costs != null && costs.size() > 0) {
            for (TaskEstimatedCost taskEstimatedCost : costs) {
                boolean updated = taskPlannedEstimatedCostDAO.updatePlannedActualCost(taskEstimatedCost);
                if (!updated) {
                    throw new Exception("Error while updating task budget by month" + taskEstimatedCost);
                }
            }
        }

        return true;
    }

    @Override
    public Task getTaskBudgetByTask(int taskId) throws Exception {
        logger.debug("Getting list of task budget for task: " + taskId);
        Task task = taskDAO.getTaskDetail(taskId);
        return taskBudgetDAO.getTaskCostByTask(task);
    }

    @Override
    public Task getTaskBudgetByTaskAndMonthYear(int taskId) throws Exception {
        logger.debug("Getting list of task budget for task differentiated by month year: " + taskId);

        Task task = taskDAO.getTaskDetail(taskId);
        List<TaskEstimatedCostByMonthYear> taskEstimatedCostByMonthYears = new LinkedList<>();
        task.setCostsByMonthYear(taskEstimatedCostByMonthYears);

        Map<TaskInterval, List<TaskEstimatedCost>> taskIntervalListMap = taskBudgetDAO.getTaskCostByTaskMonthYear(taskId);

        for (Map.Entry<TaskInterval, List<TaskEstimatedCost>> entry : taskIntervalListMap.entrySet()) {
            TaskEstimatedCostByMonthYear taskEstimatedCostByMonthYear = new TaskEstimatedCostByMonthYear();
            taskEstimatedCostByMonthYear.setTaskInterval(entry.getKey());
            taskEstimatedCostByMonthYear.setCosts(entry.getValue());

        }

        return taskBudgetDAO.getTaskCostByTask(task);
    }


}
