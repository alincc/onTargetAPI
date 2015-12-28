package com.ontarget.api.jpa.dao.impl;

import com.ontarget.api.dao.UserDeviceDAO;
import com.ontarget.api.repository.UserDeviceRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.UserDevice;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Repository
public class UserDeviceJPADAOImpl implements UserDeviceDAO {

    private Logger logger = Logger.getLogger(ProjectJpaDAOImpl.class);

    @Autowired
    private UserDeviceRepository userDeviceRepository;

    @Override
    public List<UserDevice> findAllDeviceByUserId(Integer userId) throws Exception {
        return userDeviceRepository.findByUserId(userId);
    }

    @Override
    public UserDevice saveUpdate(UserDevice userDevice) throws Exception {
        return userDeviceRepository.save(userDevice);
    }

    @Override
    public boolean removeUserDevice(String userDeviceUUID) throws Exception {
        List<UserDevice> userDevices = userDeviceRepository.findByDeviceUUID(userDeviceUUID,new PageRequest(0,1, Sort.Direction.DESC));
        if(userDevices == null || userDevices.size() <=0 ) return false;
        UserDevice userDevice = userDevices.get(0);
        userDevice.setStatus(OnTargetConstant.GenericStatus.DELETED);
        userDeviceRepository.save(userDevice);
        return userDevice.getStatus().equals(OnTargetConstant.GenericStatus.DELETED);
    }
}
