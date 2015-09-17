package com.ontarget.response.bean;

import java.util.List;

import lombok.Data;

import com.ontarget.bean.ProfileFeatureInfo;
import com.ontarget.bean.ProfileMenuInfo;
import com.ontarget.dto.OnTargetResponse;

@Data
public class UserProfileResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<ProfileMenuInfo> menuList;
	private List<ProfileFeatureInfo> featureList;
}
