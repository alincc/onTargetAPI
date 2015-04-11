package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DocumentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int documentId;
	private DocumentTemplateDTO documentTemplate;
	private String name;
	private String status;
	private int projectId;
	private Date dueDate;
	private int createdBy;
	private UserDTO creator;
	private int modifiedBy;
	private List<DocumentKeyValueDTO> keyValues;
	private List<DocumentGridKeyValueDTO> gridKeyValues;

	public DocumentDTO() {
		super();
	}

	public DocumentDTO(int documentId) {
		super();
		this.documentId = documentId;
	}

	public int getDocumentId() {
		return documentId;
	}

	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	public DocumentTemplateDTO getDocumentTemplate() {
		return documentTemplate;
	}

	public void setDocumentTemplate(DocumentTemplateDTO documentTemplate) {
		this.documentTemplate = documentTemplate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<DocumentKeyValueDTO> getKeyValues() {
		return keyValues;
	}

	public void setKeyValues(List<DocumentKeyValueDTO> keyValues) {
		this.keyValues = keyValues;
	}

	public List<DocumentGridKeyValueDTO> getGridKeyValues() {
		return gridKeyValues;
	}

	public void setGridKeyValues(List<DocumentGridKeyValueDTO> gridKeyValues) {
		this.gridKeyValues = gridKeyValues;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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

	public UserDTO getCreator() {
		return creator;
	}

	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Document{" + "documentId='" + documentId + "'" + ", documentTemplate='" + documentTemplate + "'" + ", name='"
				+ name + "'" + ", status='" + status + "'" + ", keyValues=" + keyValues + ", gridKeyValues=" + gridKeyValues
				+ "}";
	}

}
