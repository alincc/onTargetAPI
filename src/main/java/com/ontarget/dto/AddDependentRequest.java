package com.ontarget.dto;

import com.ontarget.bean.DependentTaskDTO;

/**
 * Created by sumit on 1/5/15.
 */
public class AddDependentRequest extends BaseRequestDTO {
    private DependentTaskDTO dependentTask;

    public DependentTaskDTO getDependentTask() {
        return dependentTask;
    }

    public void setDependentTask(DependentTaskDTO dependentTask) {
        this.dependentTask = dependentTask;
    }
}
