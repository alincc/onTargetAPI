package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by sumit on 1/5/15.
 */
public class DependentTask implements Serializable {
    long id;
    int taskId;
    int dependentTaskId;
    int category_id;
    long tsInsert;
    int createdBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getDependentTaskId() {
        return dependentTaskId;
    }

    public void setDependentTaskId(int dependentTaskId) {
        this.dependentTaskId = dependentTaskId;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public long getTsInsert() {
        return tsInsert;
    }

    public void setTsInsert(long tsInsert) {
        this.tsInsert = tsInsert;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
}
