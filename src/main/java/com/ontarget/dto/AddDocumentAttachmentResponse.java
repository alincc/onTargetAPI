package com.ontarget.dto;

public class AddDocumentAttachmentResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;

	private Long documentAttachmentId;

	public Long getDocumentAttachmentId() {
		return documentAttachmentId;
	}

	public void setDocumentAttachmentId(Long documentAttachmentId) {
		this.documentAttachmentId = documentAttachmentId;
	}
}
