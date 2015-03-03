package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "documentId", "filePath", "addedBy" })
public class AddDocumentAttachment {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("documentId")
	private Integer documentId;
	@NotEmpty
	@JsonProperty("filePath")
	private String filePath;
	@JsonProperty("addedBy")
	private Integer addedBy;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("documentId")
	public Integer getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(Integer documentId) {
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
	public Integer getAddedBy() {
		return addedBy;
	}

	@JsonProperty("addedBy")
	public void setAddedBy(Integer addedBy) {
		this.addedBy = addedBy;
	}

}
