package com.ontarget.dto;

import java.util.Date;
import java.util.List;

import com.ontarget.bean.DocumentGridKeyValue;
import com.ontarget.bean.DocumentKeyValue;
import com.ontarget.bean.UserDTO;

public class AddDocumentRequest {
	private long documentTemplateId;
	private String documentName;
	private List<DocumentKeyValue> keyValues;
	private List<DocumentGridKeyValue> gridKeyValues;
	private UserDTO submitter;
	private List<UserDTO> assignees;
    private long projectId;
    private Date dueDate;
	
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

	public UserDTO getSubmitter() {
		return submitter;
	}

	public void setSubmitter(UserDTO submitter) {
		this.submitter = submitter;
	}

	public List<UserDTO> getAssignees() {
		return assignees;
	}

	public void setAssignees(List<UserDTO> assignees) {
		this.assignees = assignees;
	}

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
