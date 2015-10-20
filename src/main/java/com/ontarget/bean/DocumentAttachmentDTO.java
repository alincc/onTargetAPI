package com.ontarget.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DocumentAttachmentDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int documentAttachmentId;
	private DocumentDTO document;
	private String filePath;
    private int addedBy;
    private Date addedDate;
    private Contact createdByContact;


}
