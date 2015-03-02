package com.ontarget.request.bean;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "taskPercentageLogId", "percentageComplete" })
public class TaskProgressInfo {
	@NotNull
	@JsonProperty("percentageComplete")
	private Double percentageComplete;
	@NotNull
	@JsonProperty("taskPercentageLogId")
	private Integer taskPercentageLogId;

	@JsonProperty("percentageComplete")
	public Double getPercentageComplete() {
		return percentageComplete;
	}

	@JsonProperty("percentageComplete")
	public void setPercentageComplete(Double percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	@JsonProperty("taskPercentageLogId")
	public Integer getTaskPercentageLogId() {
		return taskPercentageLogId;
	}

	@JsonProperty("taskPercentageLogId")
	public void setTaskPercentageLogId(Integer taskPercentageLogId) {
		this.taskPercentageLogId = taskPercentageLogId;
	}

}
