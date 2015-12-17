package com.ontarget.dto;

import com.ontarget.bean.Contact;
import com.ontarget.entities.ProjectFileCategory;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UploadedDocumentDetail{
	
	private int fileId;
	private String name;
	private String fileType;
	private int createdBy;
	private Date createdDate;
    private Contact createdByContact;
    private ProjectFileCategory projectFileCategoryId;
    private String description;
    List<UploadedDocumentDetail> versionProjectFiles;

    List<ProjectFilePageDTO> projectFilePageDTOs;

    private String thumbnailImageName;
    private int parentProjectFileId;
    private int versionNo;
    private boolean isConversionComplete;
    private String filePath;


}