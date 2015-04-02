package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UserRegistration;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserRegistrationInfo;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfileService {

	public UserProfileResponse addUserProfile(UserProfileRequest request)
			throws Exception;

	public OnTargetResponse updateUserProfileAndContactInfo(
			UpdateUserProfileRequest request) throws Exception;

	public boolean changeUserPassword(Integer userId, String newPassword,
			String currentPassword) throws Exception;

	public boolean saveRegistration(int projectId, String firstName,
			String lastName, String email, String tokenId, String accountStatus)
			throws Exception;

	public Contact getContact(long userId) throws Exception;

	public UserRegistration getRegistration(String token) throws Exception;

	public boolean changeForgotPassword(String token, String newPassword)
			throws Exception;

	public Company getCompanyInfoByUser(int userId) throws Exception;

	public String getRandomSafetyUserInfo(Integer userId) throws Exception;

	public boolean createNewUserFromInvitation(UserRegistrationInfo registration)
			throws Exception;

	public boolean activateAccount(int userId) throws Exception;

	public boolean forgotPasswordRequest(String emailAddress) throws Exception;

	public boolean validateForgotPasswordToken(String forgotPasswordToken)
			throws Exception;

	public boolean saveUserImage(UserImageRequest userImageRequest)
			throws Exception;

	public int generateUserId() throws Exception;
}
