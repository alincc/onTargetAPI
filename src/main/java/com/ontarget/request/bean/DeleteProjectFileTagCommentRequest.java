package com.ontarget.request.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DeleteProjectFileTagCommentRequest {
	@NotNull
	@Valid
	private BaseRequest baseRequest;
	@NotNull
	private Long commentId;
}
