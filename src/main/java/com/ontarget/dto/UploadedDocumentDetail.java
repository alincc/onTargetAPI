package com.ontarget.dto;

import com.ontarget.bean.Contact;
import com.ontarget.entities.ProjectFileCategory;

import java.util.Date;
import java.util.List;

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

    private String thumbnailImageName;
    private int parentProjectFileId;
    private int versionNo;
    private boolean isConversionComplete;

    public String getThumbnailImageName() {
        return thumbnailImageName;
    }

    public void setThumbnailImageName(String thumbnailImageName) {
        this.thumbnailImageName = thumbnailImageName;
    }

    public int getParentProjectFileId() {
        return parentProjectFileId;
    }

    public void setParentProjectFileId(int parentProjectFileId) {
        this.parentProjectFileId = parentProjectFileId;
    }

    public int getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(int versionNo) {
        this.versionNo = versionNo;
    }

    public boolean isConversionComplete() {
        return isConversionComplete;
    }

    public void setConversionComplete(boolean isConversionComplete) {
        this.isConversionComplete = isConversionComplete;
    }

    public List<UploadedDocumentDetail> getVersionProjectFiles() {
        return versionProjectFiles;
    }

    public void setVersionProjectFiles(List<UploadedDocumentDetail> versionProjectFiles) {
        this.versionProjectFiles = versionProjectFiles;
    }

    public ProjectFileCategory getProjectFileCategoryId() {
        return projectFileCategoryId;
    }

    public void setProjectFileCategoryId(ProjectFileCategory projectFileCategoryId) {
        this.projectFileCategoryId = projectFileCategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Contact getCreatedByContact() {
        return createdByContact;
    }

    public void setCreatedByContact(Contact createdByContact) {
        this.createdByContact = createdByContact;
    }

    public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}