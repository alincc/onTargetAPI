package com.ontarget.dto;

import java.io.Serializable;

public class UploadDocumentRequestDTO extends BaseRequestDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int projectId;
	private String name;
	private String fileType;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
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
	
	
}
