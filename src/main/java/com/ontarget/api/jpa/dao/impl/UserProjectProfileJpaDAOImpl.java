package com.ontarget.api.jpa.dao.impl;

import com.ontarget.api.dao.UserProjectProfileDAO;
import com.ontarget.api.repository.ProfileRepository;
import com.ontarget.api.repository.UserProjectProfileRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.entities.Profile;
import com.ontarget.entities.UserProjectProfile;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sanjeevghimire on 12/9/15.
 */
@Repository("userProjectProfileJpaDAOImpl")
public class UserProjectProfileJpaDAOImpl  implements UserProjectProfileDAO {

    @Resource
    UserProjectProfileRepository userProjectProfileRepository;

    @Resource
    private ProfileRepository profileRepository;


    @Override
    public UserProjectProfile saveOrUpdate(UserProjectProfile userProjectProfile) throws Exception {
        userProjectProfile.setStatus(OnTargetConstant.UserProjectProfile.ACTIVE);

        Profile profile = profileRepository.findProfileByCode(userProjectProfile.getProfile().getProfileCode());
        userProjectProfile.setProfile(profile);

        return userProjectProfileRepository.save(userProjectProfile);
    }

    @Override
    public void delete(UserProjectProfile userProjectProfile) throws Exception {
        // changes the status to 'N'
        userProjectProfileRepository.save(userProjectProfile);
    }

    @Override
    public UserProjectProfile findProfileByUserAndProject(Integer projectId, Integer userId) throws Exception {
        UserProjectProfile userProjectProfile =  userProjectProfileRepository.getProfileByUserAndProject(projectId, userId);
        return userProjectProfile;
    }


    @Override
    public UserProjectProfile findByUserProjectFileId(Integer userProjectProfileId) throws Exception{
        return userProjectProfileRepository.findByUserProjectProfileId(userProjectProfileId);
    }

    @Override
    public List<UserProjectProfile> findProfileByUserForEachProject(Integer userId) throws Exception {
        return userProjectProfileRepository.findByUserId(userId);
    }


}
