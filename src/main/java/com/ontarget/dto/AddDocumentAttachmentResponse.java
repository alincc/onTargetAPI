package com.ontarget.dto;

public class AddDocumentAttachmentResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;

	private int documentAttachmentId;

	public int getDocumentAttachmentId() {
		return documentAttachmentId;
	}

	public void setDocumentAttachmentId(int documentAttachmentId) {
		this.documentAttachmentId = documentAttachmentId;
	}
}
