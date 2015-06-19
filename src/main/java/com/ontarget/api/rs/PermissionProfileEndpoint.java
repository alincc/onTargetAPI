package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.bean.ProfileInfoRequest;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.PermissionListReponse;
import com.ontarget.dto.PermissionProfileListResponse;
import com.ontarget.dto.PermissionProfileResponse;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

public interface PermissionProfileEndpoint {

	OnTargetResponse addPermissionProfile(@Valid AddPermissionProfileRequest request);

	OnTargetResponse editPermissionProfile(@Valid EditPermissionProfileRequest request);

	PermissionListReponse getApplicationPermissionList();

	PermissionProfileListResponse getPermissionProfileList();

	PermissionProfileResponse getPermissionProfileInfo(@Valid ProfileInfoRequest request);
}
