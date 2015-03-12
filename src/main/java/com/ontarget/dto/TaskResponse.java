package com.ontarget.dto;

import com.ontarget.bean.TaskInfo;

/**
 * Created by sumit on 1/4/15.
 */
public class TaskResponse extends OnTargetResponse {
    private TaskInfo task;

    public TaskInfo getTask() {
        return task;
    }

    public void setTask(TaskInfo task) {
        this.task = task;
    }
}
