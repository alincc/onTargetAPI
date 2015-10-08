package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.PermissionProfileDAO;
import com.ontarget.api.repository.ApplicationFeatureRepository;
import com.ontarget.api.repository.ProfileRepository;
import com.ontarget.entities.ApplicationFeature;
import com.ontarget.entities.Profile;
import com.ontarget.entities.ProfileFeature;
import com.ontarget.entities.User;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

@Repository("permissionProfileJpaDAOImpl")
public class PermissionProfileJpaDAOImpl implements PermissionProfileDAO {
	@Resource
	private ProfileRepository profileRepository;

	@Resource
	private ApplicationFeatureRepository applicationPermissionRepository;

	@Override
	public boolean addPermissionProifle(AddPermissionProfileRequest request) throws Exception {
		Profile profile = new Profile();
		profile.setName(request.getName().trim());
		profile.setDescription(request.getDescription());
		profile.setActive(new Character('Y'));
		profile.setAddedBy(new User(request.getUserId()));
		profile.setAddedDate(new Date());
		// profile.setProfileType(OnTargetConstant.ProfileType.PERMISSION_PROFILE);
		profileRepository.save(profile);

		// List<Integer> assignedPermissionList =
		// request.getAssignedPermissionList();
		// for (Integer permissionId : assignedPermissionList) {
		// ProfileFeature profilePermission = new ProfileFeature();
		// profilePermission.setActive(new Character('Y'));
		// profilePermission.setProfile(profile);
		// // profilePermission.setApplicationPermission(new
		// // ApplicationFeature(permissionId));
		// profilePermissionRepository.save(profilePermission);
		// }
		return true;
	}

	@Override
	public boolean editPermissionProfile(EditPermissionProfileRequest request) throws Exception {
		Profile profile = profileRepository.findByProfileId(request.getProfileId());
		// if
		// (profile.getProfileType().equalsIgnoreCase(OnTargetConstant.ProfileType.PERMISSION_PROFILE))
		// {
		profile.setActive(request.getActive().charAt(0));
		profile.setName(request.getName().trim());
		profile.setDescription(request.getDescription());
		profile.setModifiedBy(new User(request.getUserId()));
		profile.setModifiedDate(new Date());
		profileRepository.save(profile);

		List<Integer> assignedPermissionList = request.getAssignedPermissionList();

//		List<ProfileFeature> profilePermissionList = profile.getProfilePermissionList();
//		for (ProfileFeature profilePermission : profilePermissionList) {
//			// if
//			// (!assignedPermissionList.contains(profilePermission.getProfilePermissionId()))
//			// {
//			// profilePermission.setActive(new Character('N'));
//			// profilePermissionRepository.save(profilePermission);
//			// }
//		}

		// for (Integer permissionId : assignedPermissionList) {
		// ProfileFeature profilePermission =
		// profilePermissionRepository.findByPermissionIdAndProfileId(permissionId,
		// profile.getProfileId());
		// if (profilePermission != null) {
		// profilePermission.setActive(new Character('Y'));
		// profilePermissionRepository.save(profilePermission);
		// } else {
		// profilePermission = new ProfileFeature();
		// profilePermission.setActive(new Character('Y'));
		// profilePermission.setProfile(profile);
		// // profilePermission.setApplicationPermission(new
		// // ApplicationFeature(permissionId));
		// profilePermissionRepository.save(profilePermission);
		// }
		// }
		return true;
		// } else {
		// return false;
		// }
	}

	@Override
	public boolean isProfileNameAlreadyAdded(String name) throws Exception {
//		if (profileRepository.findPermissionProfileByName(name) != null) {
//			return true;
//		}
		return false;
	}

	@Override
	public boolean isProfileNameAlreadyAdded(Integer profileId, String name) throws Exception {
//		if (profileRepository.findPermissionProfileByIdAndName(profileId, name) != null) {
//			return true;
//		}
		return false;
	}

	@Override
	public List<ApplicationFeature> getApplicationPermissionList() throws Exception {
		return applicationPermissionRepository.findApplicationPermissionByActive(new Character('Y'));
	}

	@Override
	public List<Profile> getProfileList() throws Exception {
		//return profileRepository.findAllPermissionProfile();
		return null;
	}

	@Override
	public Profile getProfileById(Integer profileId) throws Exception {
		return profileRepository.findByProfileId(profileId);
	}
}
