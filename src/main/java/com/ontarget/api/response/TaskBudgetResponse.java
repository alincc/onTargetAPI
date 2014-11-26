package com.ontarget.api.response;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;
import com.ontarget.dto.OnTargetResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/22/14.
 */
public class TaskBudgetResponse extends OnTargetResponse{

    public TaskBudgetResponse() {
    }

    private List<TaskInterval> taskIntervals;

    private Map<Task, List<TaskEstimatedCost>> taskCosts;

    public List<TaskInterval> getTaskIntervals() {
        return taskIntervals;
    }

    public void setTaskIntervals(List<TaskInterval> taskIntervals) {
        this.taskIntervals = taskIntervals;
    }

    public Map<Task, List<TaskEstimatedCost>> getTaskCosts() {
        return taskCosts;
    }

    public void setTaskCosts(Map<Task, List<TaskEstimatedCost>> taskCosts) {
        this.taskCosts = taskCosts;
    }
}
