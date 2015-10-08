package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.PermissionProfileDAO;
import com.ontarget.api.service.PermissionProfileService;
import com.ontarget.bean.ApplicationPermissionDTO;
import com.ontarget.bean.ProfilePermissionDTO;
import com.ontarget.bean.ProfileFeatureInfo;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.PermissionListReponse;
import com.ontarget.dto.PermissionProfileListResponse;
import com.ontarget.dto.PermissionProfileResponse;
import com.ontarget.entities.ApplicationFeature;
import com.ontarget.entities.Profile;
import com.ontarget.entities.ProfileFeature;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

@Service
public class PermissionProfileServiceImpl implements PermissionProfileService {
	private Logger logger = Logger.getLogger(PermissionProfileServiceImpl.class);

	@Autowired
	@Qualifier("permissionProfileJpaDAOImpl")
	private PermissionProfileDAO permissionProfileDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addPermissionProfile(AddPermissionProfileRequest request) throws Exception {
		logger.info("Request to add permission profile" + request);

		OnTargetResponse response = new OnTargetResponse();

		if (permissionProfileDAO.isProfileNameAlreadyAdded(request.getName().trim().toUpperCase())) {
			response.setReturnMessage("Profile name already added");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}

		boolean added = permissionProfileDAO.addPermissionProifle(request);
		if (added) {
			response.setReturnMessage("Successfully added permission profile");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("Could not add permission profile");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse editPermissionProfile(EditPermissionProfileRequest request) throws Exception {
		logger.info("Request to update permission profile" + request);

		OnTargetResponse response = new OnTargetResponse();

		if (permissionProfileDAO.isProfileNameAlreadyAdded(request.getProfileId(), request.getName().trim().toUpperCase())) {
			response.setReturnMessage("Profile name already added");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}

		boolean updated = permissionProfileDAO.editPermissionProfile(request);
		if (updated) {
			response.setReturnMessage("Successfully updated permission profile");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("Could not update permission profile");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	public PermissionListReponse getApplicationPermissions() throws Exception {
		PermissionListReponse response = new PermissionListReponse();

		List<ApplicationFeature> permissionList = permissionProfileDAO.getApplicationPermissionList();

		List<ApplicationPermissionDTO> applicationPermissionDTOList = new ArrayList<>();

		if (permissionList != null && !permissionList.isEmpty()) {
			for (ApplicationFeature applicationPermission : permissionList) {
				ApplicationPermissionDTO applicationPermissionDTO = new ApplicationPermissionDTO();
				// applicationPermissionDTO.setApplicationPermissionId(applicationPermission.getApplicationPermissionId());
				// applicationPermissionDTO.setPermissionKey(applicationPermission.getPermissionKey());
				// applicationPermissionDTO.setPermissionName(applicationPermission.getPermissionName());
				applicationPermissionDTOList.add(applicationPermissionDTO);
			}
		}
		response.setReturnMessage("Successfully retrieved application permissions");
		response.setReturnVal(OnTargetConstant.SUCCESS);
		response.setPermissionList(applicationPermissionDTOList);
		return response;
	}

	@Override
	public PermissionProfileListResponse getPermissionProfiles() throws Exception {
		PermissionProfileListResponse response = new PermissionProfileListResponse();

		List<Profile> profileList = permissionProfileDAO.getProfileList();

		List<ProfilePermissionDTO> permissionProfileDTOList = new ArrayList<>();

		if (profileList != null && !profileList.isEmpty()) {
			for (Profile profile : profileList) {
				ProfilePermissionDTO permissionProfileDTO = new ProfilePermissionDTO();
				permissionProfileDTO.setPermissionProfileId(profile.getProfileId());
				permissionProfileDTO.setActive(profile.getActive().toString());
				permissionProfileDTO.setProfileName(profile.getName());
				permissionProfileDTO.setProfileDescription(profile.getDescription());
				permissionProfileDTO.setAddedBy(profile.getAddedBy().getUserName());
				permissionProfileDTO.setAddedDate(profile.getAddedDate());

				// List<ProfileFeatureInfo> profileAssignedPermissionDTOList =
				// new ArrayList<>();
				// List<ProfileFeature> profilePermissionList =
				// profile.getProfilePermissionList();
				// for (ProfileFeature profilePermission :
				// profilePermissionList) {
				// ProfileFeatureInfo profileAssignedMenuDTO = new
				// ProfileFeatureInfo();
				// profileAssignedMenuDTO.setActive(profilePermission.getActive().toString());
				// //
				// profileAssignedMenuDTO.setApplicationPermissionId(profilePermission.getApplicationPermission()
				// // .getApplicationPermissionId());
				// //
				// profileAssignedMenuDTO.setPermissionName(profilePermission.getApplicationPermission()
				// // .getPermissionName());
				// //
				// profileAssignedMenuDTO.setPermissionKey(profilePermission.getApplicationPermission()
				// // .getPermissionKey());
				// //
				// profileAssignedMenuDTO.setProfilePermissionId(profilePermission.getProfilePermissionId());
				// profileAssignedPermissionDTOList.add(profileAssignedMenuDTO);
				// }
				// permissionProfileDTO.setProfileAssignedPermissionList(profileAssignedPermissionDTOList);

				permissionProfileDTOList.add(permissionProfileDTO);
			}
		}
		response.setPermissionProfileList(permissionProfileDTOList);
		response.setReturnMessage("Successfully retrieved permission profile list");
		response.setReturnVal(OnTargetConstant.SUCCESS);
		return response;
	}

	@Override
	public PermissionProfileResponse getPermissionProfileById(Integer profileId) throws Exception {
		PermissionProfileResponse response = new PermissionProfileResponse();

		Profile profile = permissionProfileDAO.getProfileById(profileId);

		// if (profile != null
		// &&
		// profile.getProfileType().equalsIgnoreCase(OnTargetConstant.ProfileType.PERMISSION_PROFILE))
		// {
		// if (profile.getActive().equals(new Character('Y'))) {
		// PermissionProfileDTO permissionProfileDTO = new
		// PermissionProfileDTO();
		// permissionProfileDTO.setProfileName(profile.getName());
		// permissionProfileDTO.setProfileDescription(profile.getDescription());
		//
		// List<ProfileAssignedPermissionDTO> profileAssignedMenuDTOList = new
		// ArrayList<>();
		// List<ProfileFeature> profiePermissionList =
		// profile.getProfilePermissionList();
		// for (ProfileFeature profilePermission : profiePermissionList) {
		// if (profilePermission.getActive().equals(new Character('Y'))) {
		// if
		// (profilePermission.getApplicationPermission().getActive().equals(new
		// Character('Y'))) {
		// ProfileAssignedPermissionDTO profileAssignedPermissionDTO = new
		// ProfileAssignedPermissionDTO();
		// profileAssignedPermissionDTO.setPermissionName(profilePermission.getApplicationPermission()
		// .getPermissionName());
		// profileAssignedPermissionDTO.setPermissionKey(profilePermission.getApplicationPermission()
		// .getPermissionKey());
		// profileAssignedMenuDTOList.add(profileAssignedPermissionDTO);
		// }
		// }
		// }
		// permissionProfileDTO.setProfileAssignedPermissionList(profileAssignedMenuDTOList);
		// response.setPermissionProfile(permissionProfileDTO);
		// response.setReturnMessage("Successfully retrieved permission profile info.");
		// response.setReturnVal(OnTargetConstant.SUCCESS);
		// } else {
		// response.setReturnMessage("Profile is blocked.");
		// response.setReturnVal(OnTargetConstant.ERROR);
		// }
		// } else {
		// response.setReturnMessage("Error while retrieving permission profile info.");
		// response.setReturnVal(OnTargetConstant.ERROR);
		// }
		return response;
	}

}
