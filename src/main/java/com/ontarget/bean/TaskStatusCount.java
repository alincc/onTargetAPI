package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 11/15/14.
 */
public class TaskStatusCount implements Serializable{

    private String statusType;
    private long taskCount;

    public TaskStatusCount() {
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public long getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(long taskCount) {
        this.taskCount = taskCount;
    }
}
