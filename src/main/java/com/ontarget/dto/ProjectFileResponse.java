package com.ontarget.dto;

import java.util.List;

/**
 * Created by sanjeevghimire on 9/18/15.
 */
public class ProjectFileResponse extends OnTargetResponse{


    private static final long serialVersionUID = 1L;

    private int projectId;
    private int projectFileId;
    private UploadedDocumentDetail projectFile;

    public ProjectFileResponse() {

    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProjectFileId() {
        return projectFileId;
    }

    public void setProjectFileId(int projectFileId) {
        this.projectFileId = projectFileId;
    }

    public UploadedDocumentDetail getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(UploadedDocumentDetail projectFile) {
        this.projectFile = projectFile;
    }
}
