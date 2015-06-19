package com.ontarget.api.service;

import com.ontarget.dto.MenuListResponse;
import com.ontarget.dto.MenuProfileListResponse;
import com.ontarget.dto.MenuProfileResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddMenuProfileRequest;
import com.ontarget.request.bean.EditMenuProfileRequest;

public interface MenuProfileService {
	OnTargetResponse addMenuProfile(AddMenuProfileRequest request) throws Exception;

	OnTargetResponse editMenuProfile(EditMenuProfileRequest request) throws Exception;

	MenuListResponse getApplicationMenus() throws Exception;

	MenuProfileListResponse getMenuProfiles() throws Exception;
	
	MenuProfileResponse getMenuProfileById(Integer profileId) throws Exception;

}
