package com.ontarget.request.bean;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "percentageType", "taskProgressList" })
public class AddTaskProgress {
	@JsonProperty("baseRequest")
	private BaseRequest baseRequest;
	@JsonProperty("taskProgressList")
	private List<TaskProgress> taskProgressList;

	@JsonProperty("baseRequest")
	public BaseRequest getBaseRequest() {
		return baseRequest;
	}

	@JsonProperty("baseRequest")
	public void setBaseRequest(BaseRequest baseRequest) {
		this.baseRequest = baseRequest;
	}

	@JsonProperty("taskProgressList")
	public List<TaskProgress> getTaskProgressList() {
		return taskProgressList;
	}

	@JsonProperty("taskProgressList")
	public void setTaskProgressList(List<TaskProgress> taskProgressList) {
		this.taskProgressList = taskProgressList;
	}

}
