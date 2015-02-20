package com.ontarget.request.bean;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "documentId", "filePath", "addedBy" })
public class AddDocumentAttachment {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("documentId")
	private int documentId;
	@JsonProperty("filePath")
	private String filePath;
	@JsonProperty("addedBy")
	private int addedBy;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("documentId")
	public int getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}

	@JsonProperty("filePath")
	public String getFilePath() {
		return filePath;
	}

	@JsonProperty("filePath")
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@JsonProperty("addedBy")
	public int getAddedBy() {
		return addedBy;
	}

	@JsonProperty("addedBy")
	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

}
