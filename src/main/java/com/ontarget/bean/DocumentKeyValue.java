package com.ontarget.bean;


public class DocumentKeyValue extends BaseBean {
	private static final long serialVersionUID = 1L;
	
	private Document document;
	private String key;
	private String value;
	
	public DocumentKeyValue() {
		super();
	}
	
	public DocumentKeyValue(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public DocumentKeyValue(Document document, String key, String value) {
		super();
		this.document = document;
		this.key = key;
		this.value = value;
	}

	public Document getDocument() {
		return document;
	}
	
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DocumentKeyValue{" +
				"document='" + document + "'" +
				", key='" + key + "'" +
				", value='" + value + "'" +
				"}";
	}
	
	
}
