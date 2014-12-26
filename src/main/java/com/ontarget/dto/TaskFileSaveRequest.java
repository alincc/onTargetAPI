package com.ontarget.dto;

import javax.ws.rs.QueryParam;

/**
 * Created by sumit on 12/25/14.
 */
public class TaskFileSaveRequest {
    long taskId;
    long userId;
    String fileName;
    String location;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
