package com.ontarget.api.response;

import com.ontarget.bean.TaskDTO;
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

    private TaskDTO task;


    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}
