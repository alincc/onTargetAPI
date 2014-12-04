package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.Document;


public class GetDocumentsResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	
	private List<Document> submittals;
	private List<Document> approvals;
	
	
	
	public GetDocumentsResponse() {
		super();
	}
	
	public GetDocumentsResponse(String returnVal, String returnMessage) {
		super(returnVal, returnMessage);
	}

	public List<Document> getSubmittals() {
		return submittals;
	}
	
	public void setSubmittals(List<Document> submittals) {
		this.submittals = submittals;
	}
	
	public List<Document> getApprovals() {
		return approvals;
	}
	
	public void setApprovals(List<Document> approvals) {
		this.approvals = approvals;
	}
}
