package com.ontarget.api.service;

import com.ontarget.entities.UserProjectProfile;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/9/15.
 */
public interface UserProjectProfileService {

    public UserProjectProfile saveOrUpdate(UserProjectProfile userProjectProfile) throws Exception;

    public boolean delete(Integer userProjectProfileId) throws Exception;

    public UserProjectProfile getProfileByUserAndProject(Integer projectId, Integer userId) throws Exception;

    public List<UserProjectProfile> findProfileByUserForEachProject(Integer userId) throws Exception;

}
