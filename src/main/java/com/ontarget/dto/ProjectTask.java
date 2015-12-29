package com.ontarget.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ontarget.bean.TaskComment;
import com.ontarget.bean.UserDTO;
import com.ontarget.entities.TaskPriority;
import lombok.Data;

@Data
public class ProjectTask implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private String status;
	private TaskPriority severity;
	private Integer projectTaskId;
	private Date startDate;
	private Date endDate;
	private boolean completed;
	private List<ProjectTask> childTasks;
	private List<UserDTO> assignee;
	private List<TaskComment> comments;
	private double percentageComplete;



}
