package com.ontarget.dto;

import com.ontarget.bean.DependentTask;

/**
 * Created by sumit on 1/5/15.
 */
public class AddDependentRequest extends BaseRequest {
    private DependentTask dependentTask;

    public DependentTask getDependentTask() {
        return dependentTask;
    }

    public void setDependentTask(DependentTask dependentTask) {
        this.dependentTask = dependentTask;
    }
}
