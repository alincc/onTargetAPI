package com.ontarget.dto;

import lombok.Data;

/**
 * Created by sanjeevghimire on 9/18/15.
 */
@Data
public class ProjectFileResponse extends OnTargetResponse{

    private static final long serialVersionUID = 1L;

    private int projectId;
    private int projectFileId;
    private UploadedDocumentDetail projectFile;
}
