package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.MenuProfileDAO;
import com.ontarget.api.repository.ApplicationMenuRepository;
import com.ontarget.api.repository.ProfileRepository;
import com.ontarget.api.repository.ProfileMenuRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ApplicationMenu;
import com.ontarget.entities.Profile;
import com.ontarget.entities.ProfileMenu;
import com.ontarget.entities.User;
import com.ontarget.request.bean.AddMenuProfileRequest;
import com.ontarget.request.bean.EditMenuProfileRequest;

@Repository("menuProfileJpaDAOImpl")
public class MenuProfileJpaDAOImpl implements MenuProfileDAO {
	@Resource
	private ProfileRepository profileRepository;
	@Resource
	private ProfileMenuRepository profileMenuRepository;
	@Resource
	private ApplicationMenuRepository applicationMenuRepository;

	@Override
	public boolean addMenuProfile(AddMenuProfileRequest request) throws Exception {
		Profile profile = new Profile();
		profile.setName(request.getName().trim());
		profile.setDescription(request.getDescription());
		profile.setActive(new Character('Y'));
		profile.setAddedBy(new User(request.getUserId()));
		profile.setAddedDate(new Date());
		profile.setProfileType(OnTargetConstant.ProfileType.MENU_PROFILE);
		profileRepository.save(profile);

		List<Integer> assignedMenuList = request.getAssignedMenuList();
		for (Integer menuId : assignedMenuList) {
			ProfileMenu profileMenu = new ProfileMenu();
			profileMenu.setActive(new Character('Y'));
			profileMenu.setProfile(profile);
			profileMenu.setApplicationMenu(new ApplicationMenu(menuId));
			profileMenuRepository.save(profileMenu);
		}
		return true;
	}

	@Override
	public boolean editMenuProfile(EditMenuProfileRequest request) throws Exception {
		Profile profile = profileRepository.findByProfileId(request.getProfileId());
		if (profile.getProfileType().equalsIgnoreCase(OnTargetConstant.ProfileType.MENU_PROFILE)) {
			profile.setActive(request.getActive().charAt(0));
			profile.setName(request.getName().trim());
			profile.setDescription(request.getDescription());
			profile.setModifiedBy(new User(request.getUserId()));
			profile.setModifiedDate(new Date());
			profileRepository.save(profile);

			List<Integer> assignedMenuList = request.getAssignedMenuList();

			List<ProfileMenu> profileMenuList = profile.getProfileMenuList();
			for (ProfileMenu profileMenu : profileMenuList) {
				if (!assignedMenuList.contains(profileMenu.getProfileMenuId())) {
					profileMenu.setActive(new Character('N'));
					profileMenuRepository.save(profileMenu);
				}
			}

			for (Integer menuId : assignedMenuList) {
				ProfileMenu profileMenu = profileMenuRepository
						.findByMenuIdAndProfileId(menuId, profile.getProfileId());
				if (profileMenu != null) {
					profileMenu.setActive(new Character('Y'));
					profileMenuRepository.save(profileMenu);
				} else {
					profileMenu = new ProfileMenu();
					profileMenu.setActive(new Character('Y'));
					profileMenu.setProfile(profile);
					profileMenu.setApplicationMenu(new ApplicationMenu(menuId));
					profileMenuRepository.save(profileMenu);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isProfileNameAlreadyAdded(String name) throws Exception {
		if (profileRepository.findMenuProfileByName(name) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isProfileNameAlreadyAdded(Integer profileId, String name) throws Exception {
		if (profileRepository.findMenuProfileByIdAndName(profileId, name) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<ApplicationMenu> getApplicationMenuList() throws Exception {
		return applicationMenuRepository.findApplicationMenuByActive(new Character('Y'));
	}

	@Override
	public List<Profile> getMenuProfileList() throws Exception {
		return profileRepository.findAllMenuProfile();
	}

	@Override
	public Profile getProfileById(Integer profileId) throws Exception {
		return profileRepository.findByProfileId(profileId);
	}

}
