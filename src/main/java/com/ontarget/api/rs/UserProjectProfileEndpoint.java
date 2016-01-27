package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.UserProjectProfileRequest;
import com.ontarget.response.bean.UserProjectProfileResponse;

import javax.validation.Valid;

/**
 * Created by TRON on 1/26/2016.
 */
public interface UserProjectProfileEndpoint {

    public OnTargetResponse saveOrUpdateUserProjectProfile(@Valid UserProjectProfileRequest userProjectProfileRequest);



}
