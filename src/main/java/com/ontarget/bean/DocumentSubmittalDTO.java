package com.ontarget.bean;

import java.io.Serializable;

public class DocumentSubmittalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long documentSubmittalId;
	private DocumentDTO document;
	private UserDTO assignee;
	private int assignedTo;
	private int createdBy;
	private int modifiedBy;

	public long getDocumentSubmittalId() {
		return documentSubmittalId;
	}

	public void setDocumentSubmittalId(long documentSubmittalId) {
		this.documentSubmittalId = documentSubmittalId;
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public UserDTO getAssignee() {
		return assignee;
	}

	public void setAssignee(UserDTO assignee) {
		this.assignee = assignee;
	}

	public int getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "DocumentSubmittal{" + "documentSubmittalId='"
				+ documentSubmittalId + "'" + "document='" + document + "'"
				+ ", assignee='" + assignee + "'" + "}";
	}

}
