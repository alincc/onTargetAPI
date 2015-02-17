package com.ontarget.request.bean;

import java.util.Date;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "projectTaskId", "title", "description", "status",
		"severity", "percentageComplete", "startDateText", "endDateText",
		"startDate", "endDate", "project", "parentTask" })
public class Task {

	@JsonProperty("projectTaskId")
	private Integer projectTaskId;
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@JsonProperty("status")
	private String status;
	@JsonProperty("severity")
	private String severity;
	@JsonProperty("percentageComplete")
	private Integer percentageComplete;
	@JsonProperty("startDateText")
	private String startDateText;
	@JsonProperty("endDateText")
	private String endDateText;
	@JsonProperty("startDate")
	private Date startDate;
	@JsonProperty("endDate")
	private Date endDate;
	@JsonProperty("project")
	private Project project;
	@JsonProperty("parentTask")
	private ParentTask parentTask;

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
	 * @return The title
	 */
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The description
	 */
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @param description
	 *            The description
	 */
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return The status
	 */
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 *            The status
	 */
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The severity
	 */
	@JsonProperty("severity")
	public String getSeverity() {
		return severity;
	}

	/**
	 * 
	 * @param severity
	 *            The severity
	 */
	@JsonProperty("severity")
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * 
	 * @return The percentageComplete
	 */
	@JsonProperty("percentageComplete")
	public Integer getPercentageComplete() {
		return percentageComplete;
	}

	/**
	 * 
	 * @param percentageComplete
	 *            The percentageComplete
	 */
	@JsonProperty("percentageComplete")
	public void setPercentageComplete(Integer percentageComplete) {
		this.percentageComplete = percentageComplete;
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

	/**
	 * 
	 * @return The project
	 */
	@JsonProperty("project")
	public Project getProject() {
		return project;
	}

	/**
	 * 
	 * @param project
	 *            The project
	 */
	@JsonProperty("project")
	public void setProject(Project project) {
		this.project = project;
	}

	/**
	 * 
	 * @return The parentTask
	 */
	@JsonProperty("parentTask")
	public ParentTask getParentTask() {
		return parentTask;
	}

	/**
	 * 
	 * @param parentTask
	 *            The parentTask
	 */
	@JsonProperty("parentTask")
	public void setParentTask(ParentTask parentTask) {
		this.parentTask = parentTask;
	}
}