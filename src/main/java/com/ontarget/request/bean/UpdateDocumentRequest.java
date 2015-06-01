package com.ontarget.request.bean;

import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "keyValues", "gridKeyValues", "submittedBy", "documentId", "projectId", "dueDate" })
public class UpdateDocumentRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@Valid
	@NotNull
	@Size(min = 1)
	@JsonProperty("keyValues")
	private List<DocumentKeyValue> keyValues;
	@Valid
	@NotNull
	@Size(min = 1)
	@JsonProperty("gridKeyValues")
	private List<DocumentGridKeyValue> gridKeyValues;
	@NotNull
	@JsonProperty("documentId")
	private Integer documentId;
	@NotNull
	@JsonProperty("dueDate")
	private Date dueDate;
	@NotNull
	@JsonProperty("submittedBy")
	private Integer submittedBy;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("keyValues")
	public List<DocumentKeyValue> getKeyValues() {
		return keyValues;
	}

	@JsonProperty("keyValues")
	public void setKeyValues(List<DocumentKeyValue> keyValues) {
		this.keyValues = keyValues;
	}

	@JsonProperty("gridKeyValues")
	public List<DocumentGridKeyValue> getGridKeyValues() {
		return gridKeyValues;
	}

	@JsonProperty("gridKeyValues")
	public void setGridKeyValues(List<DocumentGridKeyValue> gridKeyValues) {
		this.gridKeyValues = gridKeyValues;
	}

	@JsonProperty("documentId")
	public Integer getDocumentId() {
		return documentId;
	}

	@JsonProperty("documentId")
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	@JsonProperty("dueDate")
	public Date getDueDate() {
		return dueDate;
	}

	@JsonProperty("dueDate")
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@JsonProperty("submittedBy")
	public Integer getSubmittedBy() {
		return submittedBy;
	}

	@JsonProperty("submittedBy")
	public void setSubmittedBy(Integer submittedBy) {
		this.submittedBy = submittedBy;
	}

}
