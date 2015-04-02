package com.ontarget.api.response;

import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.dto.OnTargetResponse;

/**
 * Created by Owner on 11/25/14.
 */
public class TaskBudgetListResponse extends OnTargetResponse{

    public TaskBudgetListResponse() {
    }

    private ProjectTaskInfo task;


    public ProjectTaskInfo getTask() {
        return task;
    }

    public void setTask(ProjectTaskInfo task) {
        this.task = task;
    }
}
