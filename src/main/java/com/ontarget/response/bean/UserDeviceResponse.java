package com.ontarget.response.bean;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.UserDevice;
import lombok.Data;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Data
public class UserDeviceResponse extends OnTargetResponse{

    private UserDevice userDevice;
}
