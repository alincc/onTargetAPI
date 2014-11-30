package com.ontarget.dto;

import java.io.Serializable;

public class UploadDocumentRequest extends BaseRequest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int projectId;
	private String name;
	
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
	
	
}
