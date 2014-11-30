package com.ontarget.bean;

import java.util.Date;

import com.ontarget.dto.UploadDocumentRequest;

public class UploadDocument extends BaseBean{
	
	private static final long serialVersionUID = 1L;
	private int projectFileId;
	
	private int projectId;
	private String name;
	
	
	public UploadDocument(){
		;
	}
	
	public UploadDocument(UploadDocumentRequest requestData){
		this.projectId=requestData.getProjectId();
		this.name=requestData.getName();
		this.createdBy=requestData.getUser().getUsername();
		this.modifiedBy=requestData.getUser().getUsername();
		this.createdTimeStamp=new Date();
		this.modifiedTimeStamp=new Date();
		
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
	
	


}
