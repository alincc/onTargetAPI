package com.ontarget.request.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

@Data
public class ProjectBIMFileCommentRequest {
	@NotNull
	@Valid
	private BaseRequest baseRequest;
	@NotNull
	private Integer projectBIMFileId;
	private Integer commentId;
	@NotEmpty
	private String comment;

}
