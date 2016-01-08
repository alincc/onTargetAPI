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
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "baseRequest", "keyValues", "gridKeyValues", "submittedBy", "documentId", "projectId", "dueDate","assignee" })
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

    @Valid
    @NotNull
    @JsonProperty("assignee")
    private List<Assignee> assignee;



}
