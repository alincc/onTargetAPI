package com.ontarget.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sumit on 11/26/14.
 */
public class TaskMemberRequest extends BaseRequest implements Serializable {
    private long projectId;
    private long taskId;
    private List<Long> members;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public List<Long> getMembers() {
        return members;
    }

    public void setMembers(List<Long> members) {
        this.members = members;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
