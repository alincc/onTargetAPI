package com.ontarget.dto;

import com.ontarget.bean.ProjectMember;

import java.util.List;

/**
 * Created by sumit on 11/24/14.
 */
public class ProjectMemberListResponse  extends OnTargetResponse {
    private List<ProjectMember> projectMemberList;
    private long projectId;

    public List<ProjectMember> getProjectMemberList() {
        return projectMemberList;
    }

    public void setProjectMemberList(List<ProjectMember> projectMemberList) {
        this.projectMemberList = projectMemberList;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
