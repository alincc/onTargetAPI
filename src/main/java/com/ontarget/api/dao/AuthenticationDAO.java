package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.UserDTO;
import com.ontarget.dto.RegistrationRequestDTO;
import com.ontarget.request.bean.RegistrationApprovalRequest;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationDAO {

    public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception;

    public boolean logout(String username) throws  Exception;

    public UserRegistrationRequest getUserRegistrationRequestInfo(int userRequestId) throws Exception;

    public List<RegistrationRequestDTO> getUserRegistrationPendingRequests() throws Exception;

    public boolean approvePendingRegistrationRequest(RegistrationApprovalRequest req) throws Exception;

    public boolean approveUserRequest(int userRequestId) throws Exception;

    public boolean createUser(RegistrationApprovalRequest request) throws Exception;
    
    public UserDTO getUserSignInInfo(SignInRequest signInRequest) throws Exception;

    public UserDTO getUserInfoByUsername(UserDTO user) throws Exception;

    public boolean changePassword(long userId, String password, String salt) throws Exception;

    public UserDTO getUserInfoById(long userId) throws Exception;
    
    public UserDTO getUserResponse(Integer userId) throws Exception;
}
