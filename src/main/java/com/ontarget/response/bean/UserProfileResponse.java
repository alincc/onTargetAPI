package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import lombok.Data;

@Data
public class UserProfileResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;

    private String membershipType;
}
