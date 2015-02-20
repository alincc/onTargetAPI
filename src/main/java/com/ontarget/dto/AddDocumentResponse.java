package com.ontarget.dto;

import com.ontarget.bean.DocumentDTO;

public class AddDocumentResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	
	private DocumentDTO document;
	
	public AddDocumentResponse() {
		super();
	}
	
	public AddDocumentResponse(String returnVal, String returnMessage) {
		super(returnVal, returnMessage);
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}
}
