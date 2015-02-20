package com.ontarget.bean;

import java.io.Serializable;

public class DocumentAttachmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int documentAttachmentId;
	private DocumentDTO document;
	private String filePath;
	private int addedBy;

	public int getDocumentAttachmentId() {
		return documentAttachmentId;
	}

	public void setDocumentAttachmentId(int documentAttachmentId) {
		this.documentAttachmentId = documentAttachmentId;
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	@Override
	public String toString() {
		return "DocumentAttachment{" + "documentAttachmentId='"
				+ documentAttachmentId + "'" + ", document='" + document + "'"
				+ ", filePath=" + filePath + "'" + "}";
	}

}
