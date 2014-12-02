package com.ontarget.api.rs;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.bean.User;
import com.ontarget.dto.UserProfileRequest;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfile {

    public OnTargetResponse addUserProfile(UserProfileRequest userProfileRequest);

    public OnTargetResponse changeUserPassword(long userId, String password) throws Exception;

    public OnTargetResponse updateUserProfile(UserProfileRequest userProfileRequest);


}
