package com.ontarget.dto;

import lombok.Data;

import com.ontarget.bean.Contact;

@Data
public class TaskLink {
	private Integer taskId;
	private Contact adddedBy;

}
