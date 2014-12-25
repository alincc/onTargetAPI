package com.ontarget.api.rs;

import com.ontarget.dto.*;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfile {

    public OnTargetResponse addUserProfile(UserProfileRequest userProfileRequest);

    public OnTargetResponse changeUserPassword(ChangeUserPasswordRequest request) throws Exception;

    public OnTargetResponse updateUserProfile(UserProfileRequest userProfileRequest);

    public OnTargetResponse inviteUserIntoProject(UserInvitationRequest request);

    public SafetyInfoResponse getSafetyInfoForUser(long userId);

    public OnTargetResponse saveUserProfileImage(UserImageRequest userImageRequest);
}
