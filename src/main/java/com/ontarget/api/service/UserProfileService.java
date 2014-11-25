package com.ontarget.api.service;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserProfileRequest;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfileService {

    public OnTargetResponse addUserProfile(UserProfileRequest request) throws Exception;

    public OnTargetResponse updateUserProfileAndContactInfo(UserProfileRequest request) throws Exception;

    public boolean changeUserPassword(long userId, String password) throws Exception;
}
