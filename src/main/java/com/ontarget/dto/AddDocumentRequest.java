package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.DocumentGridKeyValue;
import com.ontarget.bean.DocumentKeyValue;
import com.ontarget.bean.User;

public class AddDocumentRequest {
	private long documentTemplateId;
	private String documentName;
	private List<DocumentKeyValue> keyValues;
	private List<DocumentGridKeyValue> gridKeyValues;
	private User submitter;
	private List<User> assignees;
    private long projectId;
	
	public AddDocumentRequest() {
		super();
	}

	public long getDocumentTemplateId() {
		return documentTemplateId;
	}

	public void setDocumentTemplateId(long documentTemplateId) {
		this.documentTemplateId = documentTemplateId;
	}
	
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
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

	public User getSubmitter() {
		return submitter;
	}

	public void setSubmitter(User submitter) {
		this.submitter = submitter;
	}

	public List<User> getAssignees() {
		return assignees;
	}

	public void setAssignees(List<User> assignees) {
		this.assignees = assignees;
	}

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }
}
