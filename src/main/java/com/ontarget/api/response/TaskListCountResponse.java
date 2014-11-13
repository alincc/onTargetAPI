package com.ontarget.api.response;

import com.ontarget.dto.OnTargetResponse;

import java.util.Map;

/**
 * Created by Owner on 11/12/14.
 */
public class TaskListCountResponse extends OnTargetResponse {

    public TaskListCountResponse() {
    }

    Map<String, Integer> taskCountByStatus;

    public Map<String, Integer> getTaskCountByStatus() {
        return taskCountByStatus;
    }

    public void setTaskCountByStatus(Map<String, Integer> taskCountByStatus) {
        this.taskCountByStatus = taskCountByStatus;
    }
}
