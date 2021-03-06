package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.request.bean.BaseRequest;

/**
 * Created by Owner on 11/25/14.
 */
public class TaskBudgetRequest extends BaseRequest {

    public TaskBudgetRequest() {
    }

    private List<TaskEstimatedCost> costList;

    public List<TaskEstimatedCost> getCostList() {
        return costList;
    }

    public void setCostList(List<TaskEstimatedCost> costList) {
        this.costList = costList;
    }
}
