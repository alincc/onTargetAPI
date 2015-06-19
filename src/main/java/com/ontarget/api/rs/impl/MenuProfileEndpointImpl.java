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

import com.ontarget.api.rs.MenuProfileEndpoint;
import com.ontarget.api.service.MenuProfileService;
import com.ontarget.bean.ProfileInfoRequest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.MenuListResponse;
import com.ontarget.dto.MenuProfileResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.MenuProfileListResponse;
import com.ontarget.request.bean.AddMenuProfileRequest;
import com.ontarget.request.bean.EditMenuProfileRequest;

@Component
@Path("/menuProfile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MenuProfileEndpointImpl implements MenuProfileEndpoint {

	private Logger logger = Logger.getLogger(MenuProfileEndpointImpl.class);
	@Autowired
	private MenuProfileService menuProfileService;

	@Override
	@POST
	@Path("/add")
	public OnTargetResponse addMenuProfile(AddMenuProfileRequest request) {
		try {
			return menuProfileService.addMenuProfile(request);
		} catch (Exception e) {
			logger.error("Error while adding menu profile", e);
			OnTargetResponse response = new OnTargetResponse();
			response.setReturnMessage("Error while adding menu profile");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}
	}

	@Override
	@POST
	@Path("/edit")
	public OnTargetResponse editMenuProfile(EditMenuProfileRequest request) {
		try {
			return menuProfileService.editMenuProfile(request);
		} catch (Exception e) {
			logger.error("Error while updating menu profile", e);
			OnTargetResponse response = new OnTargetResponse();
			response.setReturnMessage("Error while updating menu profile");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}
	}

	@Override
	@GET
	@Path("/getApplicationMenuList")
	public MenuListResponse getApplicationMenuList() {
		MenuListResponse response = new MenuListResponse();
		try {
			return menuProfileService.getApplicationMenus();
		} catch (Exception e) {
			logger.error("Error while getting application menus", e);
			response.setReturnMessage("Error while getting application menus");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@GET
	@Path("/getMenuProfileList")
	public MenuProfileListResponse getMenuProfileList() {
		MenuProfileListResponse response = new MenuProfileListResponse();
		try {
			return menuProfileService.getMenuProfiles();
		} catch (Exception e) {
			logger.error("Error while getting menu profiles", e);
			response.setReturnMessage("Error while getting menu profiles");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/getMenuProfileInfo")
	public MenuProfileResponse getMenuProfileInfo(ProfileInfoRequest request) {
		MenuProfileResponse response = new MenuProfileResponse();
		try {
			return menuProfileService.getMenuProfileById(request.getProfileId());
		} catch (Exception e) {
			logger.error("Error while getting menu profile info", e);
			response.setReturnMessage("Error while getting menu profile info");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}
}
