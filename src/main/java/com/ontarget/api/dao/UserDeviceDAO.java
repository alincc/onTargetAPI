package com.ontarget.api.dao;

import com.ontarget.entities.UserDevice;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
public interface UserDeviceDAO{

    List<UserDevice> findAllDeviceByUserId(Integer userId) throws Exception;

    UserDevice saveUpdate(UserDevice userDevice) throws Exception;

    public boolean removeUserDevice(String userDeviceUUID) throws Exception;
}
