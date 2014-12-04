package com.ontarget.dto;

/**
 * Created by sumit on 12/4/14.
 */
public class AddTaskResponse extends OnTargetResponse {
    private long projectTaskId;

    public long getProjectTaskId() {
        return projectTaskId;
    }

    public void setProjectTaskId(long projectTaskId) {
        this.projectTaskId = projectTaskId;
    }
}
