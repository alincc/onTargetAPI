package com.ontarget.api.response;

import java.util.List;
import java.util.Map;

import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;
import com.ontarget.dto.OnTargetResponse;

/**
 * Created by Owner on 11/22/14.
 */
public class TaskBudgetResponse extends OnTargetResponse{

    public TaskBudgetResponse() {
    }

    private List<TaskInterval> taskIntervals;

    private Map<ProjectTaskInfo, List<TaskEstimatedCost>> taskCosts;

    public List<TaskInterval> getTaskIntervals() {
        return taskIntervals;
    }

    public void setTaskIntervals(List<TaskInterval> taskIntervals) {
        this.taskIntervals = taskIntervals;
    }

    public Map<ProjectTaskInfo, List<TaskEstimatedCost>> getTaskCosts() {
        return taskCosts;
    }

    public void setTaskCosts(Map<ProjectTaskInfo, List<TaskEstimatedCost>> taskCosts) {
        this.taskCosts = taskCosts;
    }
}
