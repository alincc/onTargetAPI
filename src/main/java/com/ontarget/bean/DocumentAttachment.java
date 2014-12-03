package com.ontarget.bean;

public class DocumentAttachment extends BaseBean {
	private static final long serialVersionUID = 1L;

	private long documentAttachmentId;
	private Document document;
	private String filePath;

	public long getDocumentAttachmentId() {
		return documentAttachmentId;
	}

	public void setDocumentAttachmentId(long documentAttachmentId) {
		this.documentAttachmentId = documentAttachmentId;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "DocumentAttachment{"
				+ "documentAttachmentId='" + documentAttachmentId + "'" +
				", document='" + document + "'" +
				", filePath=" + filePath + "'" +
				"}";
	}

	
}
