package com.ontarget.api.service.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.dao.UserSessionDAO;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.dto.UserResponse;
import com.ontarget.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Owner on 10/30/14.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationDAO authenticationDAO;

    @Autowired
    private UserSessionDAO userSessionDAO;

    @Override
    public UserResponse signIn(User user) throws Exception {
        UserResponse response = new UserResponse();
        User returnUser = authenticationDAO.getUserSignInInfo(user);
        if (returnUser.getUserId() == 0) {
            response.setReturnMessage(OnTargetConstant.AUTHENTICATION_FAILED);
            response.setAuthenticated(false);
            response.setAuthenticated(false);
            return response;
        }
        String token = TokenUtil.getLoginToken(user.getUsername());
        boolean saved = userSessionDAO.saveUserSessionToken(returnUser.getUserId(), token);
        if (!saved) {
            throw new Exception("User session token failed");
        }

        response.setUser(user);
        response.setToken(token);
        response.setReturnMessage(OnTargetConstant.RETURN_MESSAGE_AUTHENTICATION);
        response.setReturnVal(OnTargetConstant.SUCCESS);
        response.setAuthenticated(true);
        return response;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean registrationRequest(UserRegistrationRequest request) throws Exception {
        return authenticationDAO.saveRegistrationRequest(request);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
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
    @Transactional(rollbackFor = {Exception.class})
    public boolean approvePendingRegistrationRequest(List<UserRegistrationRequest> requests) throws Exception {
        return authenticationDAO.approvePendingRegistrationRequest(requests);
    }
}
