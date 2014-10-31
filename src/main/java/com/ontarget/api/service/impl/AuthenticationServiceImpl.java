package com.ontarget.api.service.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.response.UserResponse;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.bean.User;
import com.ontarget.bean.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Owner on 10/30/14.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private AuthenticationDAO authenticationDAO;

    @Override
    public UserResponse signIn(User user) throws Exception {
        return null;
    }

    @Override
    @Transactional
    public boolean registrationRequest(UserRegistrationRequest request) throws Exception {
        return authenticationDAO.saveRegistrationRequest(request);
    }
}
