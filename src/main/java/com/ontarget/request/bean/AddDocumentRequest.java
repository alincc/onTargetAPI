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
@JsonPropertyOrder({ "baseRequest", "keyValues", "gridKeyValues", "assignees",
		"submittedBy", "documentTemplateId", "projectId", "documentName",
		"dueDate" })
public class AddDocumentRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("keyValues")
	private List<DocumentKeyValue> keyValues;
	@Valid
	@NotNull
	@Size(min = 1)
	@JsonProperty("gridKeyValues")
	private List<DocumentGridKeyValue> gridKeyValues;
	@NotNull
	@JsonProperty("assignees")
	private List<Assignee> assignees;
	@NotNull
	@JsonProperty("submittedBy")
	private Integer submittedBy;
	@NotNull
	@JsonProperty("documentTemplateId")
	private Integer documentTemplateId;
	@NotNull
	@JsonProperty("projectId")
	private Integer projectId;
	@NotNull
	@JsonProperty("documentName")
	private String documentName;
	@NotNull
	@JsonProperty("dueDate")
	private Date dueDate;

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

	@JsonProperty("assignees")
	public List<Assignee> getAssignees() {
		return assignees;
	}

	@JsonProperty("assignees")
	public void setAssignees(List<Assignee> assignees) {
		this.assignees = assignees;
	}

	@JsonProperty("submittedBy")
	public Integer getSubmittedBy() {
		return submittedBy;
	}

	@JsonProperty("submittedBy")
	public void setSubmittedBy(Integer submittedBy) {
		this.submittedBy = submittedBy;
	}

	@JsonProperty("documentTemplateId")
	public Integer getDocumentTemplateId() {
		return documentTemplateId;
	}

	@JsonProperty("documentTemplateId")
	public void setDocumentTemplateId(Integer documentTemplateId) {
		this.documentTemplateId = documentTemplateId;
	}

	@JsonProperty("documentName")
	public String getDocumentName() {
		return documentName;
	}

	@JsonProperty("documentName")
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@JsonProperty("dueDate")
	public Date getDueDate() {
		return dueDate;
	}

	@JsonProperty("dueDate")
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@JsonProperty("projectId")
	public Integer getProjectId() {
		return projectId;
	}

	@JsonProperty("projectId")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

}
