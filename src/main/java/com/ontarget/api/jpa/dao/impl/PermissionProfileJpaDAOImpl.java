package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.PermissionProfileDAO;
import com.ontarget.api.repository.ApplicationPermissionRepository;
import com.ontarget.api.repository.ProfilePermissionRepository;
import com.ontarget.api.repository.ProfileRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ApplicationPermission;
import com.ontarget.entities.Profile;
import com.ontarget.entities.ProfilePermission;
import com.ontarget.entities.User;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

@Repository("permissionProfileJpaDAOImpl")
public class PermissionProfileJpaDAOImpl implements PermissionProfileDAO {
	@Resource
	private ProfileRepository profileRepository;
	@Resource
	private ProfilePermissionRepository profilePermissionRepository;
	@Resource
	private ApplicationPermissionRepository applicationPermissionRepository;

	@Override
	public boolean addPermissionProifle(AddPermissionProfileRequest request) throws Exception {
		Profile profile = new Profile();
		profile.setName(request.getName().trim());
		profile.setDescription(request.getDescription());
		profile.setActive(new Character('Y'));
		profile.setAddedBy(new User(request.getUserId()));
		profile.setAddedDate(new Date());
		profile.setProfileType(OnTargetConstant.ProfileType.PERMISSION_PROFILE);
		profileRepository.save(profile);

		List<Integer> assignedPermissionList = request.getAssignedPermissionList();
		for (Integer permissionId : assignedPermissionList) {
			ProfilePermission profilePermission = new ProfilePermission();
			profilePermission.setActive(new Character('Y'));
			profilePermission.setProfile(profile);
			profilePermission.setApplicationPermission(new ApplicationPermission(permissionId));
			profilePermissionRepository.save(profilePermission);
		}
		return true;
	}

	@Override
	public boolean editPermissionProfile(EditPermissionProfileRequest request) throws Exception {
		Profile profile = profileRepository.findByProfileId(request.getProfileId());
		if (profile.getProfileType().equalsIgnoreCase(OnTargetConstant.ProfileType.PERMISSION_PROFILE)) {
			profile.setActive(request.getActive().charAt(0));
			profile.setName(request.getName().trim());
			profile.setDescription(request.getDescription());
			profile.setModifiedBy(new User(request.getUserId()));
			profile.setModifiedDate(new Date());
			profileRepository.save(profile);

			List<Integer> assignedPermissionList = request.getAssignedPermissionList();

			List<ProfilePermission> profilePermissionList = profile.getProfilePermissionList();
			for (ProfilePermission profilePermission : profilePermissionList) {
				if (!assignedPermissionList.contains(profilePermission.getProfilePermissionId())) {
					profilePermission.setActive(new Character('N'));
					profilePermissionRepository.save(profilePermission);
				}
			}

			for (Integer permissionId : assignedPermissionList) {
				ProfilePermission profilePermission = profilePermissionRepository.findByPermissionIdAndProfileId(
						permissionId, profile.getProfileId());
				if (profilePermission != null) {
					profilePermission.setActive(new Character('Y'));
					profilePermissionRepository.save(profilePermission);
				} else {
					profilePermission = new ProfilePermission();
					profilePermission.setActive(new Character('Y'));
					profilePermission.setProfile(profile);
					profilePermission.setApplicationPermission(new ApplicationPermission(permissionId));
					profilePermissionRepository.save(profilePermission);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isProfileNameAlreadyAdded(String name) throws Exception {
		if (profileRepository.findPermissionProfileByName(name) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isProfileNameAlreadyAdded(Integer profileId, String name) throws Exception {
		if (profileRepository.findPermissionProfileByIdAndName(profileId, name) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<ApplicationPermission> getApplicationPermissionList() throws Exception {
		return applicationPermissionRepository.findApplicationPermissionByActive(new Character('Y'));
	}

	@Override
	public List<Profile> getProfileList() throws Exception {
		return profileRepository.findAllPermissionProfile();
	}

	@Override
	public Profile getProfileById(Integer profileId) throws Exception {
		return profileRepository.findByProfileId(profileId);
	}
}
