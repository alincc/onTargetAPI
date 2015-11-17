package com.ontarget.bean;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectBIMFileCommentDTO {
	private int projectBIMFileCommentId;
	private String comment;
	private int commentedBy;
	private Date commentedDate;
	private Contact commenterContact;
}
