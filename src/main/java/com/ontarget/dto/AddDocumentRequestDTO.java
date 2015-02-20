package com.ontarget.dto;

import java.util.Date;
import java.util.List;

import com.ontarget.bean.DocumentGridKeyValueDTO;
import com.ontarget.bean.DocumentKeyValueDTO;
import com.ontarget.bean.UserDTO;

public class AddDocumentRequestDTO {
	private long documentTemplateId;
	private String documentName;
	private List<DocumentKeyValueDTO> keyValues;
	private List<DocumentGridKeyValueDTO> gridKeyValues;
	private UserDTO submitter;
	private List<UserDTO> assignees;
    private long projectId;
    private Date dueDate;
	
	public AddDocumentRequestDTO() {
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
