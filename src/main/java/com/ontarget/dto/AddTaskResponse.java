package com.ontarget.dto;

/**
 * Created by sumit on 12/4/14.
 */
public class AddTaskResponse extends OnTargetResponse {
    private long taskId;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }
}
