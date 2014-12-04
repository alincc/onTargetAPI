package com.ontarget.dto;

import java.util.List;

public class FileUploadResponse extends OnTargetResponse {
	
	public FileUploadResponse(){
		super();
	}
	
	public FileUploadResponse(String responseCode,String returnMessage){
		super(responseCode,returnMessage);
	}
	public FileUploadResponse(String responseCode,String returnVal,String returnMessage){
		super(responseCode,returnVal,returnMessage);
	}
	
	private static final long serialVersionUID = 1L;
	
	private int projectId;
	private List<UploadedDocumentDetail> uploadedDocumentList;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public List<UploadedDocumentDetail> getUploadedDocumentList() {
		return uploadedDocumentList;
	}
	public void setUploadedDocumentList(
			List<UploadedDocumentDetail> uploadedDocumentList) {
		this.uploadedDocumentList = uploadedDocumentList;
	}

	
	public void addUploadedDocument(UploadedDocumentDetail document){
		this.uploadedDocumentList.add(document);
	}
	
}
