package com.ontarget.api.service.impl;

import com.ontarget.api.dao.UserDeviceDAO;
import com.ontarget.api.service.UserDeviceService;
import com.ontarget.entities.UserDevice;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Service
public class UserDeviceServiceImpl implements UserDeviceService {

    private Logger logger = Logger.getLogger(UserDeviceServiceImpl.class);

    @Autowired
    private UserDeviceDAO userDeviceDAO;


    @Override
    public UserDevice saveOrUpdateDevice(UserDevice userDevice) throws Exception {
        logger.debug("saving/updating userDevice: "+ userDevice);
        return userDeviceDAO.saveUpdate(userDevice);
    }

    @Override
    public boolean removeDevice(String userDeviceUUID) throws Exception {
        logger.debug("Removing userDevice: "+ userDeviceUUID);
        return userDeviceDAO.removeUserDevice(userDeviceUUID);
    }

    @Override
    public List<UserDevice> findDeviceByuserId(Integer userId) throws Exception {
        logger.debug("getting all user devices by userId: "+ userId);
        return userDeviceDAO.findAllDeviceByUserId(userId);

    }
}
