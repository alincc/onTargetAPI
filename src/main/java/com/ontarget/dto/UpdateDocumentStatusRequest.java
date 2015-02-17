package com.ontarget.dto;

import com.ontarget.bean.UserDTO;

public class UpdateDocumentStatusRequest {
	private Long documentId;
	private String newStatus;
	private UserDTO updater;

	
	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public String getNewStatus() {
		return newStatus;
	}
	
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	public UserDTO getUpdater() {
		return updater;
	}

	public void setUpdater(UserDTO updater) {
		this.updater = updater;
	}
	
	
}
