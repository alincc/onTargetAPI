package com.ontarget.response.bean;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({ "fromDate", "toDate", "complete", "incomplete" })
public class TaskBurnDown {
	private String fromDate;
	private String toDate;
	private Long complete;
	private Long incomplete;
}
