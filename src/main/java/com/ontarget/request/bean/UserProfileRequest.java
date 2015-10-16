package com.ontarget.request.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileRequest {

    @NotNull
	private Integer userId;

}
