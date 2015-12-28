package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.UserDeviceEndpoint;
import com.ontarget.api.service.UserDeviceService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.UserDevice;
import com.ontarget.request.bean.UserDeviceGetRequest;
import com.ontarget.request.bean.UserDeviceRemoveRequest;
import com.ontarget.response.bean.UserDeviceListResponse;
import com.ontarget.response.bean.UserDeviceRequest;
import com.ontarget.response.bean.UserDeviceResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Component
@Path("/device/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserDeviceEndpointImpl implements UserDeviceEndpoint {

    private Logger logger = Logger.getLogger(UserDeviceEndpointImpl.class);

    @Autowired
    private UserDeviceService userDeviceService;

    @Override
    @POST
    @Path("/add")
    public UserDeviceResponse addDevice(UserDeviceRequest request){
        logger.debug("Saving user devices");
        UserDeviceResponse response = new UserDeviceResponse();
        try {
            UserDevice userDevice = userDeviceService.saveOrUpdateDevice(request.getUserDevice());
            response.setUserDevice(userDevice);
            response.setReturnVal(OnTargetConstant.SUCCESS);
            response.setReturnMessage("Successfully saved user device");
        } catch (Exception e) {
            logger.error("Error while saving user device",e);
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while saving user device");
        }
        return response;
    }

    @Override
    @POST
    @Path("/remove")
    public OnTargetResponse addDevice(UserDeviceRemoveRequest request){
        logger.debug("Saving user devices");
        OnTargetResponse response = new OnTargetResponse();
        try {
            boolean removed = userDeviceService.removeDevice(request.getDeviceUUID());
            if(removed) {
                response.setReturnVal(OnTargetConstant.SUCCESS);
                response.setReturnMessage("Successfully removed device");
            }
        } catch (Exception e) {
            logger.error("Error while removing user device",e);
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while removing user device");
        }
        return response;
    }


    @Override
    @POST
    @Path("/getAll")
    public UserDeviceListResponse getAllDevice(UserDeviceGetRequest request){
        logger.debug("Saving user devices");
        UserDeviceListResponse response = new UserDeviceListResponse();
        try {
            List<UserDevice> userDevices = userDeviceService.findDeviceByuserId(request.getUserId());
            if(userDevices!=null && userDevices.size() > 0) {
                response.setReturnVal(OnTargetConstant.SUCCESS);
                response.setReturnMessage("Successfully removed device");
                response.setUserDevices(userDevices);
            }
        } catch (Exception e) {
            logger.error("Error while removing user device",e);
            response.setReturnVal(OnTargetConstant.ERROR);
            response.setReturnMessage("Error while removing user device");
        }
        return response;
    }




}
