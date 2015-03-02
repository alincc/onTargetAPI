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
@JsonPropertyOrder({ "baseRequest", "taskId", "taskCommentId", "comment",
		"commentedBy" })
public class TaskCommentRequest {
	@NotNull
	@Valid
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@NotNull
	@JsonProperty("taskId")
	private Integer taskId;
	@JsonProperty("taskCommentId")
	private Integer taskCommentId;
	@NotEmpty
	@JsonProperty("comment")
	private String comment;
	@NotEmpty
	@JsonProperty("commentedBy")
	private Integer commentedBy;

	/**
	 * 
	 * @return The baseRequest
	 */
	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	/**
	 * 
	 * @param baseRequest
	 *            The baseRequest
	 */
	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	/**
	 * 
	 * @return The taskId
	 */
	@JsonProperty("taskId")
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * 
	 * @param taskId
	 *            The taskId
	 */
	@JsonProperty("taskId")
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * 
	 * @return The taskCommentId
	 */
	@JsonProperty("taskCommentId")
	public Integer getTaskCommentId() {
		return taskCommentId;
	}

	/**
	 * 
	 * @param taskCommentId
	 *            The taskCommentId
	 */
	@JsonProperty("taskCommentId")
	public void setTaskCommentId(Integer taskCommentId) {
		this.taskCommentId = taskCommentId;
	}

	/**
	 * 
	 * @return The comment
	 */
	@JsonProperty("comment")
	public String getComment() {
		return comment;
	}

	/**
	 * 
	 * @param comment
	 *            The comment
	 */
	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 
	 * @return The commentedBy
	 */
	@JsonProperty("commentedBy")
	public Integer getCommentedBy() {
		return commentedBy;
	}

	/**
	 * 
	 * @param commentedBy
	 *            The commentedBy
	 */
	@JsonProperty("commentedBy")
	public void setCommentedBy(Integer commentedBy) {
		this.commentedBy = commentedBy;
	}

}
