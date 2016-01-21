package com.ontarget.request.bean;

import java.sql.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "projectTaskId", "title", "description", "status", "severity", "startDate", "endDate", "projectId", "parentTask" })
@Data
public class Task {
	@JsonProperty("projectTaskId")
	private Integer projectTaskId;
	@NotEmpty
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@NotEmpty
	@JsonProperty("status")
	private Integer status;
	@NotNull
	@JsonProperty("severity")
	private Integer severity;
	@JsonProperty("startDate")
	private Date startDate;
	@JsonProperty("endDate")
	private Date endDate;
	@NotNull
	private Integer projectId;
	@JsonProperty("assignees")
	private List<Integer> assignees;

}