package com.ontarget.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
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

    private List<UserDTO> submittedTo;

    private UserDTO modifiedByUser;
    private Date modifiedDate;

    private Date createdDate;


	public DocumentDTO() {
		super();
	}

	public DocumentDTO(int documentId) {
		super();
		this.documentId = documentId;
	}



}
