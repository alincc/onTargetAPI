package com.ontarget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ontarget.bean.DocumentGridKeyValueDTO;
import com.ontarget.bean.DocumentKeyValueDTO;
import com.ontarget.bean.UserDTO;

public class UpdateDocumentDataRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private long documentId;
	private List<DocumentKeyValueDTO> keyValues;
	private List<DocumentGridKeyValueDTO> gridKeyValues;
    private long projectId;
    private Date dueDate;
	
	private UserDTO user;

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
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
