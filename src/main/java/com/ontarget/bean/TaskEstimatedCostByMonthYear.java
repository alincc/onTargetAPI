package com.ontarget.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Owner on 1/7/15.
 */
public class TaskEstimatedCostByMonthYear implements Serializable{


    private TaskInterval taskInterval;
    private List<TaskEstimatedCost> costs;

    public TaskEstimatedCostByMonthYear() {
    }


    public List<TaskEstimatedCost> getCosts() {
        return costs;
    }

    public void setCosts(List<TaskEstimatedCost> costs) {
        this.costs = costs;
    }

    public TaskInterval getTaskInterval() {
        return taskInterval;
    }

    public void setTaskInterval(TaskInterval taskInterval) {
        this.taskInterval = taskInterval;
    }
}
