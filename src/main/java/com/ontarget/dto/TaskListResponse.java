package com.ontarget.dto;

import com.ontarget.bean.Task;

import java.util.List;

/**
 * Created by Owner on 11/7/14.
 */
public class TaskListResponse extends OnTargetResponse {

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    List<Task> tasks;

    public TaskListResponse() {
    }
}
