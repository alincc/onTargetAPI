package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.bean.ProfileInfoRequest;
import com.ontarget.dto.MenuListResponse;
import com.ontarget.dto.MenuProfileListResponse;
import com.ontarget.dto.MenuProfileResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddMenuProfileRequest;
import com.ontarget.request.bean.EditMenuProfileRequest;

public interface MenuProfileEndpoint {

	OnTargetResponse addMenuProfile(@Valid AddMenuProfileRequest addMenuProfileRequest);

	OnTargetResponse editMenuProfile(@Valid EditMenuProfileRequest request);

	MenuListResponse getApplicationMenuList();

	MenuProfileListResponse getMenuProfileList();

	MenuProfileResponse getMenuProfileInfo(@Valid ProfileInfoRequest request);

}
