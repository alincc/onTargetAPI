package com.ontarget.api.service;

import com.ontarget.api.response.UserResponse;
import com.ontarget.bean.User;
import com.ontarget.bean.UserRegistrationRequest;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationService {

    public UserResponse signIn(User user) throws Exception;

    public boolean registrationRequest(UserRegistrationRequest request) throws Exception;

}
