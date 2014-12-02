package com.ontarget.api.response;

import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.dto.OnTargetResponse;

import java.util.List;

/**
 * Created by Owner on 11/25/14.
 */
public class TaskBudgetListResponse extends OnTargetResponse{

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
