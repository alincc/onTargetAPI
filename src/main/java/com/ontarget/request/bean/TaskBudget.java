package com.ontarget.request.bean;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "percentageType", "taskBudgetEstimates" })
public class TaskBudget {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("taskBudgetEstimates")
	private List<TaskBudgetEstimate> taskBudgetEstimates;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("taskBudgetEstimates")
	public List<TaskBudgetEstimate> getTaskBudgetEstimates() {
		return taskBudgetEstimates;
	}

	@JsonProperty("taskBudgetEstimates")
	public void setTaskBudgetEstimates(
			List<TaskBudgetEstimate> taskBudgetEstimates) {
		this.taskBudgetEstimates = taskBudgetEstimates;
	}

}
