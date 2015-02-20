package com.ontarget.bean;

import java.io.Serializable;

public class DocumentGridKeyValueDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private DocumentDTO document;
	private String gridId;
	private int gridRowIndex;
	private String key;
	private String value;
	private int createdBy;
	private int modifiedBy;

	public DocumentGridKeyValueDTO() {
		super();
	}

	public DocumentGridKeyValueDTO(String gridId, int gridRowIndex, String key,
			String value) {
		super();
		this.gridId = gridId;
		this.gridRowIndex = gridRowIndex;
		this.key = key;
		this.value = value;
	}

	public DocumentGridKeyValueDTO(DocumentDTO document, String gridId,
			int gridRowIndex, String key, String value) {
		super();
		this.document = document;
		this.gridId = gridId;
		this.gridRowIndex = gridRowIndex;
		this.key = key;
		this.value = value;
	}

	public DocumentDTO getDocument() {
		return document;
	}

	public void setDocument(DocumentDTO document) {
		this.document = document;
	}

	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public int getGridRowIndex() {
		return gridRowIndex;
	}

	public void setGridRowIndex(int gridRowIndex) {
		this.gridRowIndex = gridRowIndex;
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
		return "DocumentGridKeyValue{" + "document='" + document + "'"
				+ ", gridId='" + gridId + "'" + ", gridRowIndex='"
				+ gridRowIndex + "'" + ", key='" + key + "'" + ", value='"
				+ value + "'" + "}";
	}

}
