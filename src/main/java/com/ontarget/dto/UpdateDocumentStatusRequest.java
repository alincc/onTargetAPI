package com.ontarget.dto;

import com.ontarget.bean.User;

public class UpdateDocumentStatusRequest {
	private Long documentId;
	private String newStatus;
	private User updater;

	
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

	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}
	
	
}
