package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CommentDTO implements Serializable {
	private Long commentId;
	private String comment;
	private int commentedBy;
	private Date commentedDate;
	private Contact commenterContact;
}
