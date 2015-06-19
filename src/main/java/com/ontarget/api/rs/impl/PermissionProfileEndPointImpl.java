package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.PermissionProfileEndpoint;
import com.ontarget.api.service.PermissionProfileService;
import com.ontarget.bean.ProfileInfoRequest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.PermissionListReponse;
import com.ontarget.dto.PermissionProfileListResponse;
import com.ontarget.dto.PermissionProfileResponse;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

@Component
@Path("/permissionProfile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PermissionProfileEndPointImpl implements PermissionProfileEndpoint {

	private Logger logger = Logger.getLogger(PermissionProfileEndPointImpl.class);
	@Autowired
	private PermissionProfileService permissionProfileService;

	@Override
	@POST
	@Path("/add")
	public OnTargetResponse addPermissionProfile(AddPermissionProfileRequest request) {
		try {
			return permissionProfileService.addPermissionProfile(request);
		} catch (Exception e) {
			logger.error("Error while adding permission profile", e);
			OnTargetResponse response = new OnTargetResponse();
			response.setReturnMessage("Error while adding permission profile");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}
	}

	@Override
	@POST
	@Path("/edit")
	public OnTargetResponse editPermissionProfile(EditPermissionProfileRequest request) {
		try {
			return permissionProfileService.editPermissionProfile(request);
		} catch (Exception e) {
			logger.error("Error while updating permission profile", e);
			OnTargetResponse response = new OnTargetResponse();
			response.setReturnMessage("Error while updating permission profile");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}
	}

	@Override
	@GET
	@Path("/getApplicationPermissionList")
	public PermissionListReponse getApplicationPermissionList() {
		PermissionListReponse response = new PermissionListReponse();
		try {
			return permissionProfileService.getApplicationPermissions();
		} catch (Exception e) {
			logger.error("Error while getting application menus", e);
			response.setReturnMessage("Error while getting application permissions");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@GET
	@Path("/getPermissionProfileList")
	public PermissionProfileListResponse getPermissionProfileList() {
		PermissionProfileListResponse response = new PermissionProfileListResponse();
		try {
			return permissionProfileService.getPermissionProfiles();
		} catch (Exception e) {
			logger.error("Error while getting menu profiles", e);
			response.setReturnMessage("Error while getting permission profiles");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/getPermissionProfileInfo")
	public PermissionProfileResponse getPermissionProfileInfo(ProfileInfoRequest request) {
		PermissionProfileResponse response = new PermissionProfileResponse();
		try {
			return permissionProfileService.getPermissionProfileById(request.getProfileId());
		} catch (Exception e) {
			logger.error("Error while getting permission profile info", e);
			response.setReturnMessage("Error while getting permission profile info");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}
}
