package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.UserDevice;
import lombok.Data;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Data
public class UserDeviceListResponse extends OnTargetResponse{

    List<UserDevice> userDevices;
}
