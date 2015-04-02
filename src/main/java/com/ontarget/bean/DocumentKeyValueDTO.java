package com.ontarget.bean;

import java.io.Serializable;

public class DocumentKeyValueDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private DocumentDTO document;
	private String key;
	private String value;
	private int createdBy;
	private int modifiedBy;

	public DocumentKeyValueDTO() {
		super();
	}

	public DocumentKeyValueDTO(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public DocumentKeyValueDTO(DocumentDTO document, String key, String value) {
		super();
		this.document = document;
		this.key = key;
		this.value = value;
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
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

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(int modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@Override
	public String toString() {
		return "DocumentKeyValue{" + "document='" + document + "'" + ", key='"
				+ key + "'" + ", value='" + value + "'" + "}";
	}

}
