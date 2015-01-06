package com.ontarget.dto;

import com.ontarget.bean.Task;

/**
 * Created by sumit on 1/4/15.
 */
public class TaskResponse extends OnTargetResponse {
    private Task task;

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
