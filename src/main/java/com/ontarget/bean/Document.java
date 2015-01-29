package com.ontarget.bean;

import java.util.Date;
import java.util.List;


public class Document extends BaseBean {
	private static final long serialVersionUID = 1L;
	
	private long documentId;
	private DocumentTemplate documentTemplate;
	private String name;
	private String status;
    private long projectId;
	
	
	
	public Document() {
		super();
	}

	public Document(long documentId) {
		super();
		this.documentId = documentId;
	}

	private List<DocumentKeyValue> keyValues;
	private List<DocumentGridKeyValue> gridKeyValues;
	
	public long getDocumentId() {
		return documentId;
	}
	
	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}
	
	public DocumentTemplate getDocumentTemplate() {
		return documentTemplate;
	}
	
	public void setDocumentTemplate(DocumentTemplate documentTemplate) {
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

	public List<DocumentKeyValue> getKeyValues() {
		return keyValues;
	}

	public void setKeyValues(List<DocumentKeyValue> keyValues) {
		this.keyValues = keyValues;
	}

	public List<DocumentGridKeyValue> getGridKeyValues() {
		return gridKeyValues;
	}

	public void setGridKeyValues(List<DocumentGridKeyValue> gridKeyValues) {
		this.gridKeyValues = gridKeyValues;
	}

	@Override
	public String toString() {
		return "Document{" +
				"documentId='" + documentId + "'" +
				", documentTemplate='" + documentTemplate + "'" +
				", name='" + name + "'" +
				", status='" + status + "'" +
				", keyValues=" + keyValues +
				", gridKeyValues=" + gridKeyValues +
				"}";
	}


    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
