package com.ontarget.request.bean;

import java.sql.Date;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "projectTaskId", "startDateText", "endDateText",
		"startDate", "endDate" })
public class ParentTask {
	@NotNull
	@JsonProperty("projectTaskId")
	private Integer projectTaskId;
	@JsonProperty("startDateText")
	private String startDateText;
	@JsonProperty("endDateText")
	private String endDateText;
	@NotNull
	@JsonProperty("startDate")
	private Date startDate;
	@NotNull
	@JsonProperty("endDate")
	private Date endDate;

	/**
	 * 
	 * @return The projectTaskId
	 */
	@JsonProperty("projectTaskId")
	public Integer getProjectTaskId() {
		return projectTaskId;
	}

	/**
	 * 
	 * @param projectTaskId
	 *            The projectTaskId
	 */
	@JsonProperty("projectTaskId")
	public void setProjectTaskId(Integer projectTaskId) {
		this.projectTaskId = projectTaskId;
	}

	/**
	 * 
	 * @return The startDateText
	 */
	@JsonProperty("startDateText")
	public String getStartDateText() {
		return startDateText;
	}

	/**
	 * 
	 * @param startDateText
	 *            The startDateText
	 */
	@JsonProperty("startDateText")
	public void setStartDateText(String startDateText) {
		this.startDateText = startDateText;
	}

	/**
	 * 
	 * @return The endDateText
	 */
	@JsonProperty("endDateText")
	public String getEndDateText() {
		return endDateText;
	}

	/**
	 * 
	 * @param endDateText
	 *            The endDateText
	 */
	@JsonProperty("endDateText")
	public void setEndDateText(String endDateText) {
		this.endDateText = endDateText;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}