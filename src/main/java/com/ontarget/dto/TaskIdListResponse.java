package com.ontarget.dto;

import java.util.List;
import java.util.Set;

/**
 * Created by Yam on 05-12-2014.
 */
public class TaskIdListResponse extends OnTargetResponse{
    private Set<Long> projectTaskId;

    public Set<Long> getProjectTaskId() {
        return projectTaskId;
    }

    public void setProjectTaskId(Set<Long> projectTaskId) {
        this.projectTaskId = projectTaskId;
    }
}
