package com.ontarget.dto;

import com.ontarget.bean.Document;

public class AddDocumentResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	
	private Document document;
	
	public AddDocumentResponse() {
		super();
	}
	
	public AddDocumentResponse(String returnVal, String returnMessage) {
		super(returnVal, returnMessage);
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
