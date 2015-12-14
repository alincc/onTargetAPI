package com.ontarget.api.service.impl;

import com.ontarget.api.dao.UserProjectProfileDAO;
import com.ontarget.api.service.UserProjectProfileService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.UserProjectProfile;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/9/15.
 */
@Service
public class UserProjectProfileServiceImpl implements UserProjectProfileService {

    private Logger logger = Logger.getLogger(UserProjectProfileServiceImpl.class);

    @Autowired
    private UserProjectProfileDAO userProjectProfileDAO;

    @Override
    @Transactional
    public UserProjectProfile saveOrUpdate(UserProjectProfile userProjectProfile) throws Exception {
        logger.debug("Saving/updating project file: "+ userProjectProfile);
        return userProjectProfileDAO.saveOrUpdate(userProjectProfile);
    }

    @Override
    @Transactional
    public boolean delete(Integer userProjectProfileId) throws Exception {
        logger.debug("deleting project file: "+ userProjectProfileId);
        UserProjectProfile userProjectProfile=userProjectProfileDAO.findByUserProjectFileId(userProjectProfileId);
        userProjectProfile.setStatus(OnTargetConstant.UserProjectProfileStatus.ACTIVE);
        userProjectProfileDAO.delete(userProjectProfile);
        return true;
    }

    @Override
    public UserProjectProfile findProfileByUserAndProject(Integer projectId, Integer userId) throws Exception {
        logger.debug("Fetching profile by user: "+ userId +" and project"+ projectId);
        return userProjectProfileDAO.findProfileByUserAndProject(projectId,userId);
    }

    @Override
    public List<UserProjectProfile> findProfileByUserForEachProject(Integer userId) throws Exception {
        logger.debug("Fetching profile by user: "+ userId +" for each project");
        return userProjectProfileDAO.findProfileByUserForEachProject(userId);
    }
}
