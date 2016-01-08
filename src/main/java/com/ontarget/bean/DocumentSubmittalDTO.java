package com.ontarget.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class DocumentSubmittalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long documentSubmittalId;
	private DocumentDTO document;
	private UserDTO assignee;
	private int assignedTo;
	private int createdBy;
	private int modifiedBy;
    private String active;



}
