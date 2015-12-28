package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.UserDeviceGetRequest;
import com.ontarget.request.bean.UserDeviceRemoveRequest;
import com.ontarget.response.bean.UserDeviceListResponse;
import com.ontarget.response.bean.UserDeviceRequest;
import com.ontarget.response.bean.UserDeviceResponse;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
public interface UserDeviceEndpoint {

   public UserDeviceResponse addDevice(UserDeviceRequest request);

   public OnTargetResponse addDevice(UserDeviceRemoveRequest request);

   public UserDeviceListResponse getAllDevice(UserDeviceGetRequest request);
}
