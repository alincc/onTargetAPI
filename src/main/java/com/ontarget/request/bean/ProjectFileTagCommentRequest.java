package com.ontarget.request.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProjectFileTagCommentRequest {
	@NotNull
	@Valid
	private BaseRequest baseRequest;
	@NotNull
	private Long ProjectFileTagId;
	private Long commentId;
	@NotEmpty
	private String comment;
}
