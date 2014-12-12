package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by sumit on 12/9/14.
 */
public class ProjectTaskFile implements Serializable {
    private long taskFileId;
    private long projectTaskId;
    private String fileName;
    private String location;
    private long createdDate;
    private String createdBy;

    public long getTaskFileId() {
        return taskFileId;
    }

    public void setTaskFileId(long taskFileId) {
        this.taskFileId = taskFileId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getProjectTaskId() {
        return projectTaskId;
    }

    public void setProjectTaskId(long projectTaskId) {
        this.projectTaskId = projectTaskId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(long createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
