package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ontarget.entities.TaskPriority;
import lombok.Data;

@Data
public class TaskInfo implements Serializable {
	private int projectTaskId;
	private String title;
	private String description;
	private String status;
	private TaskPriority severity;
	private Double cost;
	private int numberOfWorkers;
	private double percentageComplete;
	private String startDateText;
	private String endDateText;

	private Date startDate;
	private Date endDate;
	private boolean completed;
	private UserDTO assignedTo;

	private List<UserDTO> assignee;

	private ProjectDTO project;
	private TaskInfo parentTask;
	private List<TaskComment> comments;

	private List<TaskEstimatedCost> costs;
	private List<TaskInfo> childTasks;
	private List<TaskEstimatedCostByMonthYear> costsByMonthYear;



}
