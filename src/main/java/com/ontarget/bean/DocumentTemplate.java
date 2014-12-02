package com.ontarget.bean;


public class DocumentTemplate extends BaseBean {
	private static final long serialVersionUID = 1L;
	
	private long documentTemplateId;
	private String name;
	
	public DocumentTemplate() {
		
	}
	
	public DocumentTemplate(long id) {
		this.documentTemplateId = id;
	}
	
	public long getDocumentTemplateId() {
		return documentTemplateId;
	}
	
	public void setDocumentTemplateId(long documentTemplateId) {
		this.documentTemplateId = documentTemplateId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DocumentTemplate{" +
				"documentTemplateId='" + documentTemplateId + "'" +
				", name='" + name + "'" +
				"}";
	}
}
