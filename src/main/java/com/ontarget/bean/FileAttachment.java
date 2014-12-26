package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by sumit on 12/22/14.
 */
public class FileAttachment implements Serializable {
    private long taskId, userId;
    private String fileName;
    private String location;

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
