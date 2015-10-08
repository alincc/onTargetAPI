package com.ontarget.request.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileRequest {

<<<<<<< HEAD
	private BaseRequest baseRequest;
=======
>>>>>>> ontarget.phase4
	@NotNull
	private Integer userId;

}