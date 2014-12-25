package com.ontarget.dto;

import javax.ws.rs.QueryParam;

/**
 * Created by sumit on 12/25/14.
 */
public class TaskStatusUpdateRequest {
    private long taskId;
    private String taskStatus;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
