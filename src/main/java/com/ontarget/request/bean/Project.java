package com.ontarget.request.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "projectId", "startDate", "endDate" })
public class Project {

	@JsonProperty("projectId")
	private Integer projectId;
	@JsonProperty("startDate")
	private Date startDate;
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