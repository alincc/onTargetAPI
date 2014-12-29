package com.ontarget.api.response;

import com.ontarget.bean.Task;
import com.ontarget.bean.TaskEstimatedCost;
import com.ontarget.bean.TaskInterval;
import com.ontarget.dto.OnTargetResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/25/14.
 */
public class TaskBudgetListResponse extends OnTargetResponse{

    public TaskBudgetListResponse() {
    }

    private Task task;


    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
