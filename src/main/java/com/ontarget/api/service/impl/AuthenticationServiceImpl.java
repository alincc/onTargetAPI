package com.ontarget.api.service.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Owner on 10/30/14.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private AuthenticationDAO authenticationDAO;

    @Override
    public UserResponse signIn(User user) throws Exception {
        //return authenticationDAO.getUserSignInInfo(user);
    	return null;
    }

    @Override
    @Transactional(rollbackFor={Exception.class})
    public boolean registrationRequest(UserRegistrationRequest request) throws Exception {
        return authenticationDAO.saveRegistrationRequest(request);
    }

    @Override
    @Transactional(rollbackFor={Exception.class})
    public boolean logout(String username) throws Exception {
        return authenticationDAO.logout(username);
    }

    @Override
    public UserRegistationApprovalResponse getUserRegistrationPendingRequests() throws Exception {
        List<UserRegistrationRequest> pendingRequestsList = authenticationDAO.getUserRegistrationPendingRequests();
        UserRegistationApprovalResponse response = new UserRegistationApprovalResponse();
        response.setUserRegistrationRequestList(pendingRequestsList);
        return response;

    }

    @Override
    @Transactional(rollbackFor={Exception.class})
    public boolean approvePendingRegistrationRequest(List<UserRegistrationRequest> requests) throws Exception {
        return authenticationDAO.approvePendingRegistrationRequest(requests);
    }
}
