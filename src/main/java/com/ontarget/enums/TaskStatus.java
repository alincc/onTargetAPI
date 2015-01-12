package com.ontarget.enums;

/**
 * Created by Owner on 1/10/15.
 */
public enum TaskStatus {

    COMPLETED(1, "COMPLETED"),
    ACTIVE(1, "COMPLETED"),
    PENDING(1, "COMPLETED");

    int taskStatusId;
    String name;

    TaskStatus(int i, String completed) {
        this.taskStatusId=i;
        this.name=completed;
    }


    public int getTaskStatusId() {
        return taskStatusId;
    }

    public String getName() {
        return name;
    }
}
