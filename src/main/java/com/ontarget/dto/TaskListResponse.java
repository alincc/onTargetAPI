package com.ontarget.dto;

import com.ontarget.bean.TaskDTO;

import java.util.List;

/**
 * Created by Owner on 11/7/14.
 */
public class TaskListResponse extends OnTargetResponse {

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    List<TaskDTO> tasks;

    public TaskListResponse() {
    }
}
