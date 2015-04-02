package com.ontarget.request.bean;

import java.sql.Date;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "projectId", "startDate", "endDate" })
public class Project {
	@NotNull
	@JsonProperty("projectId")
	private Integer projectId;
	@NotNull
	@JsonProperty("startDate")
	private Date startDate;
	@NotNull
	@JsonProperty("endDate")
	private Date endDate;

	/**
	 * 
	 * @return The projectId
	 */
	@JsonProperty("projectId")
	public Integer getProjectId() {
		return projectId;
	}

	/**
	 * 
	 * @param projectId
	 *            The projectId
	 */
	@JsonProperty("projectId")
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	/**
	 * 
	 * @return The startDate
	 */
	@JsonProperty("startDate")
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * 
	 * @param startDate
	 *            The startDate
	 */
	@JsonProperty("startDate")
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * 
	 * @return The endDate
	 */
	@JsonProperty("endDate")
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * 
	 * @param endDate
	 *            The endDate
	 */
	@JsonProperty("endDate")
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}