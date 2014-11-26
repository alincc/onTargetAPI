package com.ontarget.api.response;

import com.ontarget.bean.TaskEstimatedCost;

import java.util.List;

/**
 * Created by Owner on 11/25/14.
 */
public class TaskBudgetListResponse {

    public TaskBudgetListResponse() {
    }

    private List<TaskEstimatedCost> costList;

    public List<TaskEstimatedCost> getCostList() {
        return costList;
    }

    public void setCostList(List<TaskEstimatedCost> costList) {
        this.costList = costList;
    }
}
