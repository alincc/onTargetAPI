package com.ontarget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ontarget.bean.DocumentGridKeyValue;
import com.ontarget.bean.DocumentKeyValue;
import com.ontarget.bean.User;

public class UpdateDocumentDataRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private long documentId;
	private List<DocumentKeyValue> keyValues;
	private List<DocumentGridKeyValue> gridKeyValues;
    private long projectId;
    private Date dueDate;
	
	private User user;

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
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
