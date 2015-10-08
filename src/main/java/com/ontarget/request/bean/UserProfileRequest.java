package com.ontarget.request.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileRequest {


	private BaseRequest baseRequest;

	@NotNull
	private Integer userId;

}