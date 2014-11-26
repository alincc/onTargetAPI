package com.ontarget.dto;

import com.ontarget.bean.TaskPercentage;

import java.util.List;

/**
 * Created by Owner on 11/25/14.
 */
public class TaskPercentageRequest {

    public TaskPercentageRequest() {
    }

    private List<TaskPercentage> taskPercentageList;

    public List<TaskPercentage> getTaskPercentageList() {
        return taskPercentageList;
    }

    public void setTaskPercentageList(List<TaskPercentage> taskPercentageList) {
        this.taskPercentageList = taskPercentageList;
    }
}
