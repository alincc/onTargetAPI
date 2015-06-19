package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.entities.ApplicationPermission;
import com.ontarget.entities.Profile;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

public interface PermissionProfileDAO {

	boolean addPermissionProifle(AddPermissionProfileRequest request) throws Exception;

	boolean editPermissionProfile(EditPermissionProfileRequest request) throws Exception;

	boolean isProfileNameAlreadyAdded(String name) throws Exception;

	boolean isProfileNameAlreadyAdded(Integer profileId, String name) throws Exception;

	List<ApplicationPermission> getApplicationPermissionList() throws Exception;

	List<Profile> getProfileList() throws Exception;

	Profile getProfileById(Integer profileId) throws Exception;

}
