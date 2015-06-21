package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.ontarget.dto.ChangeUserPasswordRequest;
import com.ontarget.dto.ForgotPasswordRequest;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SafetyInfoResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserResponse;
import com.ontarget.request.bean.CompanyInfoEditRequest;
import com.ontarget.request.bean.InviteUserIntoProjectRequest;
import com.ontarget.request.bean.UpdateUserProfileRequest;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfile {

	public OnTargetResponse addUserProfile(@Valid UserProfileRequest userProfileRequest);

	public OnTargetResponse changeUserPassword(@Valid ChangeUserPasswordRequest request) throws Exception;

	public UserResponse updateUserProfile(@Valid UpdateUserProfileRequest userProfileRequest);

	public OnTargetResponse changeForgotPassword(@Valid ForgotPasswordRequest request) throws Exception;

	public SafetyInfoResponse getSafetyInfoForUser(@NotNull Integer userId);

	public OnTargetResponse forgotPasswordRequest(@Valid ForgotPasswordRequest request);

	public OnTargetResponse validateForgotPasswordToken(@NotEmpty String forgotPasswordToken);

	public OnTargetResponse saveUserProfileImage(@Valid UserImageRequest userImageRequest);

	public OnTargetResponse updateCompanyInfo(@Valid CompanyInfoEditRequest request);
}
