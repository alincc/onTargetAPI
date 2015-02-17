package com.ontarget.dto;

import com.ontarget.bean.UserDTO;

public class AddDocumentAttachmentRequest {
	private Long documentId;
	private String filePath;
	private UserDTO user;
	
	public Long getDocumentId() {
		return documentId;
	}
	
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public UserDTO getUser() {
		return user;
	}
	
	public void setUser(UserDTO user) {
		this.user = user;
	}
}
