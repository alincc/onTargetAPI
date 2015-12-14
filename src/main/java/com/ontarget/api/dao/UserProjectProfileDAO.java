package com.ontarget.api.dao;

import com.ontarget.entities.UserProjectProfile;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/14/15.
 */
public interface UserProjectProfileDAO {
    UserProjectProfile saveOrUpdate(UserProjectProfile userProjectProfile) throws Exception;

    void delete(UserProjectProfile userProjectProfile) throws Exception;

    UserProjectProfile findProfileByUserAndProject(Integer projectId, Integer userId) throws Exception;

    UserProjectProfile findByUserProjectFileId(Integer userProjectProfileId) throws Exception;

    List<UserProjectProfile> findProfileByUserForEachProject(Integer userId) throws Exception;
}
