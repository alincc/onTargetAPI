package com.ontarget.request.bean;

import lombok.Data;

@Data
public class UserProfileRequest {
	private BaseRequest baseRequest;
	private Integer userId;

}
