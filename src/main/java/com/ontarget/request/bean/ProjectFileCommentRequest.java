package com.ontarget.request.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProjectFileCommentRequest {
	@NotNull
	@Valid
	private BaseRequest baseRequest;
	@NotNull
	private Integer projectFileId;
	private Integer commentId;
	@NotEmpty
	private String comment;
}
