package com.ontarget.bean;


public class DocumentSubmittal extends BaseBean {
	private static final long serialVersionUID = 1L;

	private long documentSubmittalId;
	private Document document;
	private User assignee;
	
	
	public long getDocumentSubmittalId() {
		return documentSubmittalId;
	}
	public void setDocumentSubmittalId(long documentSubmittalId) {
		this.documentSubmittalId = documentSubmittalId;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}

	public User getAssignee() {
		return assignee;
	}
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	@Override
	public String toString() {
		return "DocumentSubmittal{" +
				"documentSubmittalId='" + documentSubmittalId + "'" +
				"document='" + document + "'" +
				", assignee='" + assignee + "'" +
				"}";
	}
	
	
}
