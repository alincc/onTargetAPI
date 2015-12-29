package com.ontarget.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ontarget.entities.TaskPriority;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonInclude(value = Include.NON_EMPTY)
@Data
public class ProjectTaskInfo implements Serializable {

	private static final long serialVersionUID = 1L;
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

	private Integer creatorId;
	private Integer modifierId;

	private Date startDate;
	private Date endDate;
	private boolean completed;
	private Integer projectId;
	private List<TaskEstimatedCostByMonthYear> costsByMonthYear;


}
