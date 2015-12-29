package com.ontarget.response.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ontarget.entities.TaskPriority;
import lombok.Data;

import com.ontarget.bean.TaskComment;
import com.ontarget.bean.UserDTO;

@Data
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String description;
	private String status;
	private TaskPriority severity;
	private Integer projectTaskId;
	private Date startDate;
	private Date endDate;
    private Integer activityId;
	private boolean completed;
	private double percentageComplete;
	private List<UserDTO> assignee;
	private List<TaskComment> comments;

}
