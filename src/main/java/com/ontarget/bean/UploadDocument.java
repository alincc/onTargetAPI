package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

import com.ontarget.request.bean.UploadDocumentRequest;

public class UploadDocument implements Serializable {

	private static final long serialVersionUID = 1L;
	private int projectFileId;
	private int createdBy;
	private int modifiedBy;
	private int projectId;
	private String name;
	private String fileType;
	protected Date createdDate;
	protected Date modifiedDate;
	private int categoryId;
	private String description;

    private String thumbnailImageName;
    private int parentProjectFileId;
    private int versionNo;
    private boolean isConversionComplete;

    private  String filePath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public UploadDocument() {
	}

	public UploadDocument(UploadDocumentRequest requestData) {
		this.projectId = requestData.getProjectId();
		this.name = requestData.getName();
		this.createdBy = requestData.getCreatedBy();
		this.modifiedBy = requestData.getModifiedBy();
		this.fileType = requestData.getFileType();
		this.createdDate = new Date();
		this.modifiedDate = new Date();
		this.categoryId = requestData.getCategoryId();
		this.description = requestData.getDescription();
        this.projectFileId=requestData.getProjectFileId();
        this.thumbnailImageName=requestData.getThumbnailImageName();
        this.parentProjectFileId=requestData.getParentProjectFileId();
        this.isConversionComplete=requestData.getIsConversionComplete();
        this.filePath=requestData.getFilePath();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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
}
