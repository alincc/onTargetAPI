package com.ontarget.request.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserProfileRequest {

	private BaseRequest baseRequest;
	@NotNull
	private Integer userId;

}
