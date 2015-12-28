package com.ontarget.api.service;

import com.ontarget.entities.UserDevice;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
public interface UserDeviceService {

    public UserDevice saveOrUpdateDevice(UserDevice userDevice) throws Exception;

    public boolean removeDevice(String userDeviceUUID) throws Exception;

    public List<UserDevice> findDeviceByuserId(Integer userId) throws Exception;

}
