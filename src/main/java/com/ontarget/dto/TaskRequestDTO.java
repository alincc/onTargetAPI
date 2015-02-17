package com.ontarget.dto;

import com.ontarget.bean.TaskDTO;

import java.io.Serializable;

/**
 * Created by Owner on 11/6/14.
 */
public class TaskRequestDTO extends BaseRequestDTO implements Serializable {

    private TaskDTO task;

    public TaskRequestDTO() {
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}
