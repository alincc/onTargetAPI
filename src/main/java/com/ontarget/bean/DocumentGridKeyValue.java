package com.ontarget.bean;


public class DocumentGridKeyValue extends BaseBean {
	private static final long serialVersionUID = 1L;
	
	private Document document;
	private String gridId;
	private int gridRowIndex;
	private String key;
	private String value;
	
	public DocumentGridKeyValue() {
		super();
	}
	public DocumentGridKeyValue(String gridId,
			int gridRowIndex, String key, String value) {
		super();
		this.gridId = gridId;
		this.gridRowIndex = gridRowIndex;
		this.key = key;
		this.value = value;
	}
	public DocumentGridKeyValue(Document document, String gridId,
			int gridRowIndex, String key, String value) {
		super();
		this.document = document;
		this.gridId = gridId;
		this.gridRowIndex = gridRowIndex;
		this.key = key;
		this.value = value;
	}
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
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
	@Override
	public String toString() {
		return "DocumentGridKeyValue{" +
				"document='" + document + "'" + 
				", gridId='" + gridId + "'" + 
				", gridRowIndex='" + gridRowIndex + "'" +
				", key='" + key + "'" +
				", value='" + value + "'" +
				"}";
	}

	
}
