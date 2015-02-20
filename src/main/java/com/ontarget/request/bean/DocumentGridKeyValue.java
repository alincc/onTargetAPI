package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "gridId", "gridRowIndex", "key", "value" })
public class DocumentGridKeyValue {
	@JsonProperty("gridId")
	private String gridId;
	@JsonProperty("gridRowIndex")
	private int gridRowIndex;
	@JsonProperty("key")
	private String key;
	@JsonProperty("value")
	private String value;

	@JsonProperty("gridId")
	public String getGridId() {
		return gridId;
	}

	@JsonProperty("gridId")
	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	@JsonProperty("gridRowIndex")
	public int getGridRowIndex() {
		return gridRowIndex;
	}

	@JsonProperty("gridRowIndex")
	public void setGridRowIndex(int gridRowIndex) {
		this.gridRowIndex = gridRowIndex;
	}

	@JsonProperty("key")
	public String getKey() {
		return key;
	}

	@JsonProperty("key")
	public void setKey(String key) {
		this.key = key;
	}

	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
	}

}
