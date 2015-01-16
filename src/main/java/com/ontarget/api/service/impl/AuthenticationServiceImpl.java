package com.ontarget.api.service.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.dao.ContactDAO;
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

    @Autowired
    private ContactDAO contactDAO;

    @Override
    public UserResponse signIn(User user) throws Exception {
        UserResponse response = new UserResponse();
        User returnUser = authenticationDAO.getUserSignInInfo(user);
//        returnUser.setUserId(7);
//        returnUser.setAccountStatus("ACTIVE");
//        returnUser.setUsername(user.getUsername());
//        returnUser.setUserTypeId(1);
//        returnUser.setUserStatus("1");
        if (returnUser.getUserId() == 0) {
            response.setReturnMessage(OnTargetConstant.AUTHENTICATION_FAILED);
            response.setAuthenticated(false);
            response.setReturnVal(OnTargetConstant.ERROR);
            return response;
        }

        String token = TokenUtil.getLoginToken(user.getUsername());
        boolean saved = userSessionDAO.saveUserSessionToken(returnUser.getUserId(),token);
        if(!saved){
            throw new Exception("User session token failed");
        }

        if(returnUser.getAccountStatus()!=OnTargetConstant.AccountStatus.ACCT_NEW && returnUser.getAccountStatus()!=OnTargetConstant.AccountStatus.ACCOUNT_INVITATION) {
            returnUser.setContact(contactDAO.getContact(returnUser.getUserId()));
        }
        
        response.setUser(returnUser);
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
    public boolean approvePendingRegistrationRequest(UserRegistrationRequest requests) throws Exception {
        return authenticationDAO.approvePendingRegistrationRequest(requests);
    }
}
