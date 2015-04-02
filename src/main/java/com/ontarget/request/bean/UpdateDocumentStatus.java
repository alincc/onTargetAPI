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
@JsonPropertyOrder({ "baseRequest", "documentId", "newStatus", "modifiedBy" })
public class UpdateDocumentStatus {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("documentId")
	private Integer documentId;
	@NotEmpty
	@JsonProperty("newStatus")
	private String newStatus;
	@NotNull
	@JsonProperty("modifiedBy")
	private Integer modifiedBy;

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

	@JsonProperty("newStatus")
	public String getNewStatus() {
		return newStatus;
	}

	@JsonProperty("newStatus")
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	@JsonProperty("modifiedBy")
	public Integer getModifiedBy() {
		return modifiedBy;
	}

	@JsonProperty("modifiedBy")
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}
