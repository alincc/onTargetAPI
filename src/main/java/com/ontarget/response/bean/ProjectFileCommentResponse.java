package com.ontarget.response.bean;

import java.util.Date;

import lombok.Data;

import com.ontarget.bean.Contact;

@Data
public class ProjectFileCommentResponse {
	private int projectFileCommentId;
	private String comment;
	private int commentedBy;
	private Date commentedDate;
	private Contact commenterContact;

}
