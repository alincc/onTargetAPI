package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.bean.User;
import com.ontarget.dto.SafetyInfoResponse;
import com.ontarget.dto.UserProfileRequest;

import javax.ws.rs.QueryParam;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfile {

    public OnTargetResponse addUserProfile(UserProfileRequest userProfileRequest);

    public OnTargetResponse changeUserPassword(long userId, String password) throws Exception;

    public OnTargetResponse updateUserProfile(UserProfileRequest userProfileRequest);

    public SafetyInfoResponse getSafetyInfoForUser(long userId);
}
