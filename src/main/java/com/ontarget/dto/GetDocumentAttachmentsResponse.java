package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.DocumentAttachmentDTO;

public class GetDocumentAttachmentsResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;

	private List<DocumentAttachmentDTO> attachments;
	
	public GetDocumentAttachmentsResponse() {
		super();
	}
	
	public GetDocumentAttachmentsResponse(String responseCode,String returnMessage){
    	super(responseCode, returnMessage);
    }

	public List<DocumentAttachmentDTO> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<DocumentAttachmentDTO> attachments) {
		this.attachments = attachments;
	}
}
