package com.ontarget.dto;

import com.ontarget.bean.Task;

import java.io.Serializable;

/**
 * Created by Owner on 11/6/14.
 */
public class TaskRequest implements Serializable {

    private Task task;

    public TaskRequest() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
