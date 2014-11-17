package com.ontarget.api.response;

import com.ontarget.bean.TaskStatusCount;
import com.ontarget.dto.OnTargetResponse;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/12/14.
 */
public class TaskListCountResponse extends OnTargetResponse {

    public TaskListCountResponse() {
    }

    List<TaskStatusCount> taskCountByStatus;

    public List<TaskStatusCount> getTaskCountByStatus() {
        return taskCountByStatus;
    }

    public void setTaskCountByStatus(List<TaskStatusCount> taskCountByStatus) {
        this.taskCountByStatus = taskCountByStatus;
    }
}
