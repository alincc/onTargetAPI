package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

import com.ontarget.dto.UploadDocumentRequest;
import com.ontarget.request.bean.UploadDocumentRequestBean;

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

	public UploadDocument() {
	}

	public UploadDocument(UploadDocumentRequestBean requestData) {
		this.projectId = requestData.getProjectId();
		this.name = requestData.getName();
		this.createdBy = requestData.getCreatedBy();
		this.modifiedBy = requestData.getModifiedBy();
		this.fileType = requestData.getFileType();
		this.createdDate = new Date();
		this.modifiedDate = new Date();
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

}
