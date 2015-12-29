package com.ontarget.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ontarget.entities.TaskPriority;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonInclude(value = Include.NON_EMPTY)
public class TaskObj implements Serializable {
	private Integer projectTaskId;
	private String title;
	private String description;
	private String status;
	private TaskPriority severity;
	private Double cost;
	private Integer numberOfWorkers;
	private Integer percentageComplete;
	private String startDateText;
	private String endDateText;

	private Date startDate;
	private Date endDate;
	private boolean completed;



}
