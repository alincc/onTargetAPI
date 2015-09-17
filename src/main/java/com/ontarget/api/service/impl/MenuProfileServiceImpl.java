package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.MenuProfileDAO;
import com.ontarget.api.service.MenuProfileService;
import com.ontarget.bean.ApplicationMenuDTO;
import com.ontarget.bean.MenuProfileDTO;
import com.ontarget.bean.ProfileMenuInfo;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.MenuListResponse;
import com.ontarget.dto.MenuProfileListResponse;
import com.ontarget.dto.MenuProfileResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.ApplicationMenu;
import com.ontarget.entities.Profile;
import com.ontarget.entities.ProfileMenu;
import com.ontarget.request.bean.AddMenuProfileRequest;
import com.ontarget.request.bean.EditMenuProfileRequest;

@Service
public class MenuProfileServiceImpl implements MenuProfileService {

	private Logger logger = Logger.getLogger(MenuProfileServiceImpl.class);

	@Autowired
	@Qualifier("menuProfileJpaDAOImpl")
	private MenuProfileDAO menuProfileDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse addMenuProfile(AddMenuProfileRequest request) throws Exception {
		logger.info("Request to add menu profile" + request);

		OnTargetResponse response = new OnTargetResponse();

		if (menuProfileDAO.isProfileNameAlreadyAdded(request.getName().trim().toUpperCase())) {
			response.setReturnMessage("Profile name already added");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}

		boolean added = menuProfileDAO.addMenuProfile(request);
		if (added) {
			response.setReturnMessage("Successfully added menu profile");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("Could not add menu profile");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse editMenuProfile(EditMenuProfileRequest request) throws Exception {
		logger.info("Request to update menu profile" + request);

		OnTargetResponse response = new OnTargetResponse();

		if (menuProfileDAO.isProfileNameAlreadyAdded(request.getProfileId(), request.getName().trim().toUpperCase())) {
			response.setReturnMessage("Profile name already added");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}

		boolean updated = menuProfileDAO.editMenuProfile(request);
		if (updated) {
			response.setReturnMessage("Successfully updated menu profile");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("Could not update menu profile");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	public MenuListResponse getApplicationMenus() throws Exception {
		MenuListResponse response = new MenuListResponse();

		List<ApplicationMenu> menuList = menuProfileDAO.getApplicationMenuList();

		List<ApplicationMenuDTO> applicationMenuDTOList = new ArrayList<>();

		if (menuList != null && !menuList.isEmpty()) {
			for (ApplicationMenu applicationMenu : menuList) {
				ApplicationMenuDTO applicationMenuDTO = new ApplicationMenuDTO();
				applicationMenuDTO.setApplicationMenuId(applicationMenu.getApplicationMenuId());
				applicationMenuDTO.setMenuKey(applicationMenu.getMenuKey());
				applicationMenuDTO.setMenuName(applicationMenu.getMenuName());
				applicationMenuDTOList.add(applicationMenuDTO);
			}
		}
		response.setReturnMessage("Successfully retrieved application menus");
		response.setReturnVal(OnTargetConstant.SUCCESS);
		response.setMenuList(applicationMenuDTOList);
		return response;
	}

	@Override
	public MenuProfileListResponse getMenuProfiles() throws Exception {
		MenuProfileListResponse response = new MenuProfileListResponse();

		List<Profile> profileList = menuProfileDAO.getMenuProfileList();

		List<MenuProfileDTO> menuProfileDTOList = new ArrayList<>();

		if (profileList != null && !profileList.isEmpty()) {
			for (Profile profile : profileList) {
				MenuProfileDTO menuProfileDTO = new MenuProfileDTO();
				menuProfileDTO.setMenuProfileId(profile.getProfileId());
				menuProfileDTO.setActive(profile.getActive().toString());
				menuProfileDTO.setProfileName(profile.getName());
				menuProfileDTO.setProfileDescription(profile.getDescription());
				menuProfileDTO.setAddedBy(profile.getAddedBy().getUserName());
				menuProfileDTO.setAddedDate(profile.getAddedDate());

//				List<ProfileMenuInfo> profileAssignedMenuDTOList = new ArrayList<>();
//				List<ProfileMenu> profileMenus = profile.getProfileMenuList();
//				for (ProfileMenu profileMenu : profileMenus) {
//					ProfileMenuInfo profileAssignedMenuDTO = new ProfileMenuInfo();
//					profileAssignedMenuDTO.setActive(profileMenu.getActive().toString());
//					profileAssignedMenuDTO
//							.setApplicationMenuId(profileMenu.getApplicationMenu().getApplicationMenuId());
//					profileAssignedMenuDTO.setMenuName(profileMenu.getApplicationMenu().getMenuName());
//					profileAssignedMenuDTO.setMenuKey(profileMenu.getApplicationMenu().getMenuKey());
//					profileAssignedMenuDTO.setProfileMenuId(profileMenu.getProfileMenuId());
//					profileAssignedMenuDTOList.add(profileAssignedMenuDTO);
//				}
//				menuProfileDTO.setProfileAssignedMenuList(profileAssignedMenuDTOList);

				menuProfileDTOList.add(menuProfileDTO);
			}
		}
		response.setMenuProfileList(menuProfileDTOList);
		response.setReturnMessage("Successfully retrieved menu profiles");
		response.setReturnVal(OnTargetConstant.SUCCESS);
		return response;
	}

	@Override
	public MenuProfileResponse getMenuProfileById(Integer profileId) throws Exception {
		MenuProfileResponse response = new MenuProfileResponse();

		Profile profile = menuProfileDAO.getProfileById(profileId);

		//if (profile != null && profile.getProfileType().equalsIgnoreCase(OnTargetConstant.ProfileType.MENU_PROFILE)) {
			if (profile.getActive().equals(new Character('Y'))) {
				MenuProfileDTO menuProfileDTO = new MenuProfileDTO();
				menuProfileDTO.setProfileName(profile.getName());
				menuProfileDTO.setProfileDescription(profile.getDescription());

				List<ProfileMenuInfo> profileAssignedMenuDTOList = new ArrayList<>();
				List<ProfileMenu> profileMenus = profile.getProfileMenuList();
				for (ProfileMenu profileMenu : profileMenus) {
					if (profileMenu.getActive().equals(new Character('Y'))) {
						if (profileMenu.getApplicationMenu().getActive().equals(new Character('Y'))) {
							ProfileMenuInfo profileAssignedMenuDTO = new ProfileMenuInfo();
							profileAssignedMenuDTO.setMenuName(profileMenu.getApplicationMenu().getMenuName());
							profileAssignedMenuDTO.setMenuKey(profileMenu.getApplicationMenu().getMenuKey());
							profileAssignedMenuDTOList.add(profileAssignedMenuDTO);
						}
					}
				}
				menuProfileDTO.setProfileAssignedMenuList(profileAssignedMenuDTOList);
				response.setMenuProfile(menuProfileDTO);
				response.setReturnMessage("Successfully retrieved menu profile info.");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				response.setReturnMessage("Profile is blocked.");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
//		} else {
//			response.setReturnMessage("Error while retrieving menu profile info.");
//			response.setReturnVal(OnTargetConstant.ERROR);
//		}
		return response;
	}

}
