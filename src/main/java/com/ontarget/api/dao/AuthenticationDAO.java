package com.ontarget.api.dao;

import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistrationRequest;

import java.util.List;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationDAO {

    public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception;

    public boolean logout(String username) throws  Exception;

    public UserRegistrationRequest getUserRegistrationRequestInfo(int userRequestId) throws Exception;

    public List<UserRegistrationRequest> getUserRegistrationPendingRequests() throws Exception;

    public boolean approvePendingRegistrationRequest(UserRegistrationRequest req) throws Exception;

    public boolean approveUserRequest(int userRequestId) throws Exception;

    public boolean createUser(UserRegistrationRequest request) throws Exception;
    
    public User getUserSignInInfo(User user) throws Exception;
}
