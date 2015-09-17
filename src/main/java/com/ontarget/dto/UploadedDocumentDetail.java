package com.ontarget.dto;

import com.ontarget.bean.Contact;
import com.ontarget.entities.ProjectFileCategory;

import java.util.Date;

public class UploadedDocumentDetail{
	
	private int fileId;
	private String name;
	private String fileType;
	private int createdBy;
	private Date createdDate;
    private Contact createdByContact;
    private ProjectFileCategory projectFileCategoryId;
    private String description;

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