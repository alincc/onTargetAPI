package com.ontarget.api.dao;

import com.ontarget.bean.UserDTO;
import com.ontarget.request.bean.UpdateUserProfileRequest;

/**
 * Created by sumit on 12/2/14.
 */
public interface UserDAO extends GenericDAO<UserDTO> {
    UserDTO getUser(Integer userId) throws Exception;

    public int saveForgotPasswordRequest(int userId, String forgotPasswordToken) throws Exception;

    public java.util.Map<String, Object> getForgotPasswordRequest(String forgotPasswordToken) throws Exception;

    public int getForgotPasswordRequestCount(String forgotPasswordToken) throws Exception;

    public boolean expireForgotPasswordRequest(String token) throws Exception;
    
    public boolean updateUserProfile(UpdateUserProfileRequest request) throws Exception;
    
    public boolean usernameAlreadyRegistered(String username) throws Exception;
}
