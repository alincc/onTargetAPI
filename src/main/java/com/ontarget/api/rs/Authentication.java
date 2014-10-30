package com.ontarget.api.rs;

import com.ontarget.api.response.UserResponse;
import com.ontarget.bean.User;
import com.ontarget.bean.UserRegistrationRequest;

/**
 * Created by Owner on 10/26/14.
 */
public interface Authentication {

    public com.ontarget.api.response.UserResponse signIn(User user);

    public UserResponse register(User user);

    public com.ontarget.api.response.OnTargetResponse registrationRequest(UserRegistrationRequest request);

}