package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UserRegistration;
import com.ontarget.dto.ForgotPasswordRequestResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.entities.Email;
import com.ontarget.entities.RegistrationRequest;
import com.ontarget.request.bean.CompanyInfoEditRequest;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserInfo;
import com.ontarget.request.bean.UserSignupRequest;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfileService {

	public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception;

	public UserResponse updateUserProfileAndContactInfo(UpdateUserProfileRequest request) throws Exception;

	public boolean changeUserPassword(Integer userId, String newPassword, String currentPassword) throws Exception;

	public boolean saveRegistration(UserInvitationRequestDTO request, String status) throws Exception;

	public Contact getContact(long userId) throws Exception;

	public UserRegistration getRegistration(String token) throws Exception;

	public boolean changeForgotPassword(String token, String newPassword) throws Exception;

	public Company getCompanyInfoByUser(int userId) throws Exception;

	public String getRandomSafetyUserInfo(Integer userId) throws Exception;

	public OnTargetResponse createNewUserFromInvitation(UserSignupRequest request) throws Exception;

	public boolean activateAccount(int userId) throws Exception;

	public ForgotPasswordRequestResponse forgotPasswordRequest(String emailAddress) throws Exception;

	public boolean validateForgotPasswordToken(String forgotPasswordToken) throws Exception;

	public boolean saveUserImage(UserImageRequest userImageRequest) throws Exception;

	public int generateUserId() throws Exception;

	public OnTargetResponse updateCompanyInfo(CompanyInfoEditRequest request) throws Exception;

	public UserResponse getUserDetails(UserInfo request) throws Exception;

	public com.ontarget.response.bean.UserProfileResponse getUserProfileInfo(int userId) throws Exception;

	public Email findEmailByEmailAddres(String emailAddress) throws Exception;

	public boolean assignProjectToMember(RegistrationRequest registrationRequest) throws Exception;
	
	public RegistrationRequest findRegistrationRequestByToken(String token) throws Exception;
}
