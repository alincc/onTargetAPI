package com.ontarget.api.service;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.PermissionListReponse;
import com.ontarget.dto.PermissionProfileListResponse;
import com.ontarget.dto.PermissionProfileResponse;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

public interface PermissionProfileService {
	OnTargetResponse addPermissionProfile(AddPermissionProfileRequest request) throws Exception;

	OnTargetResponse editPermissionProfile(EditPermissionProfileRequest request) throws Exception;

	PermissionListReponse getApplicationPermissions() throws Exception;

	PermissionProfileListResponse getPermissionProfiles() throws Exception;

	PermissionProfileResponse getPermissionProfileById(Integer profileId) throws Exception;
}
