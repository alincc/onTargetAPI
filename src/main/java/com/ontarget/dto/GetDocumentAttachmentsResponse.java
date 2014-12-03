package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.DocumentAttachment;

public class GetDocumentAttachmentsResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;

	private List<DocumentAttachment> attachments;
	
	public GetDocumentAttachmentsResponse() {
		super();
	}
	
	public GetDocumentAttachmentsResponse(String responseCode,String returnMessage){
    	super(responseCode, returnMessage);
    }

	public List<DocumentAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<DocumentAttachment> attachments) {
		this.attachments = attachments;
	}
}
