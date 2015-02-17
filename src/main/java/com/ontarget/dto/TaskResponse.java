package com.ontarget.dto;

import com.ontarget.bean.TaskDTO;

/**
 * Created by sumit on 1/4/15.
 */
public class TaskResponse extends OnTargetResponse {
    private TaskDTO task;

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}
