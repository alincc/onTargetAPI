package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.entities.ApplicationMenu;
import com.ontarget.entities.Profile;
import com.ontarget.request.bean.AddMenuProfileRequest;
import com.ontarget.request.bean.EditMenuProfileRequest;

public interface MenuProfileDAO {

	boolean addMenuProfile(AddMenuProfileRequest request) throws Exception;

	boolean editMenuProfile(EditMenuProfileRequest request) throws Exception;

	boolean isProfileNameAlreadyAdded(String name) throws Exception;

	boolean isProfileNameAlreadyAdded(Integer profileId, String name) throws Exception;

	List<ApplicationMenu> getApplicationMenuList() throws Exception;

	List<Profile> getMenuProfileList() throws Exception;

	Profile getProfileById(Integer profileId) throws Exception;

}
