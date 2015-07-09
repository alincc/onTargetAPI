package com.ontarget.api.service.impl;

import java.util.Map;
import java.util.Random;

import com.ontarget.api.dao.*;
import com.ontarget.entities.Email;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ContactPhone;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.UserDTO;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.entities.CompanyInfo;
import com.ontarget.entities.User;
import com.ontarget.request.bean.CompanyEditInfo;
import com.ontarget.request.bean.CompanyInfoEditRequest;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserContactInfo;
import com.ontarget.request.bean.UserInfo;
import com.ontarget.request.bean.UserSignupRequest;
import com.ontarget.util.ConvertPOJOUtils;
import com.ontarget.util.Security;

/**
 * Created by Owner on 11/4/14.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	private Logger logger = Logger.getLogger(UserProfileServiceImpl.class);

	@Autowired
	@Qualifier("companyJpaDAOImpl")
	private CompanyDAO companyDAO;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Autowired
	@Qualifier("authenticationJpaDAOImpl")
	private AuthenticationDAO authenticationDAO;

	@Autowired
	@Qualifier("userRegistrationJpaDAOImpl")
	private UserRegistrationDAO userRegistrationDAO;

	@Autowired
	@Qualifier("userInvitationJpaDAOImpl")
	private UserInvitationDAO userInvitationDAO;

	@Autowired
	@Qualifier("userJpaDAOImpl")
	private UserDAO userDAO;

	@Autowired
	@Qualifier("userSafetyInfoJpaDAOImpl")
	private UserSafetyInfoDAO userSafetyInfoDAO;

	@Autowired
	@Qualifier("projectJpaDAOImpl")
	private ProjectDAO projectDAO;

	@Autowired
	@Qualifier("phoneJpaDAOImpl")
	private PhoneDAO phoneDAO;

	@Autowired
	private EmailService emailService;

    @Autowired
    @Qualifier("emailJpaDAOImpl")
    private EmailDAO emailDao;

	private Random random = new Random();

	// TODO: separate logic of user profile and company profile.
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception {
		logger.info("Request to add user profile" + request);
		UserProfileResponse response = new UserProfileResponse();
		UserInfo userInfo = request.getUser();

		// get company info from the registration request.
		UserRegistration userRegistration = userRegistrationDAO.getInvitationRegistrationByUser(userInfo.getUserId());
		Company company = ConvertPOJOUtils.convertToCompany(userRegistration);
		int companyId;
		if (userRegistration.getCompanyId() != 0) {
			companyId = userRegistration.getCompanyId();
		} else {
			companyId = companyDAO.addCompanyInfo(company);
		}

		// add the company.
		UserContactInfo userContactInfo = request.getContact();
		Contact contact = ConvertPOJOUtils.convertToContact(userContactInfo);

		company.setCompanyId(companyId);

		contact.setCompany(company);

		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userInfo.getUserId());
		userDTO.setAccountStatus(userInfo.getAccountStatus());

		int userId = userDTO.getUserId();
		contact.setUser(userDTO);

		boolean saved = contactDAO.addContactInfo(contact, userId);
		if (!saved) {
			throw new Exception("Contact not saved.");
		}

		Contact contactForPhone = contactDAO.getContact(userId);
		int contactId = contactForPhone.getContactId();

		// phone type should be CELL. THIS NEEDS TO BE COLLECTED FROM UI.
		ContactPhone phone = new ContactPhone();
		phone.setPhoneType(OnTargetConstant.PhoneType.CELL);
		phone.setStatus(OnTargetConstant.PhoneStatus.ACTIVE);
		phone.setPhoneNumber(request.getContactPhone().getPhoneNumber());
		phone.setAreaCode(request.getContactPhone().getAreaCode());

		int phoneId = phoneDAO.addContactPhone(contactId, phone);

		if (phoneId <= 0) {
			throw new Exception("Error while adding phone");
		}

		// if user is invited from a request-demo then add project
		logger.info("project id: " + userRegistration.getProjectId());
		if (userRegistration.getProjectId() == 0) {
			CompanyInfo companyInfo = companyDAO.getCompanyInfo(companyId);
			ProjectDTO projectDTO = ConvertPOJOUtils.setMainProject(companyInfo);
			int addedProjectId = projectDAO.addMainProject(projectDTO, companyInfo, userInfo.getUserId());
			// add main project for request a demo user
			if (addedProjectId <= 0) {
				throw new Exception("Error while adding main project");
			}
			userInvitationDAO.updateRegistrationRequestProjectIdByUser(addedProjectId, userId);
		}

		// activate the account.
		String accountStatus = userDTO.getAccountStatus();
		if (OnTargetConstant.AccountStatus.ACCOUNT_INVITATION.equals(accountStatus)
				|| OnTargetConstant.AccountStatus.ACCT_NEW.equals(accountStatus)) {
			boolean updated = this.activateAccount(request.getUser().getUserId());
			if (!updated) {
				throw new Exception("Error while activating account");
			}
		}

		response.setReturnMessage("Successfully created company and user profile");
		response.setReturnVal(OnTargetConstant.SUCCESS);

		response.setCompany(company);

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UserResponse updateUserProfileAndContactInfo(UpdateUserProfileRequest request) throws Exception {
		UserResponse response = new UserResponse();

		boolean updated = userDAO.updateUserProfile(request);
		if (updated) {
			// UserDTO returnUser =
			// authenticationDAO.getUserResponse(request.getUserProfileInfo().getUserId());
			// returnUser.setContact(contactDAO.getContact(returnUser.getUserId()));
			// response.setUser(returnUser);
			// String token = TokenUtil.getLoginToken(returnUser.getUsername());
			// response.setToken(token);

			response.setReturnMessage("Successfully updated user profile");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("No Rows were updated. Seems User does not exists or may not have any contact info");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UserResponse getUserDetails(UserInfo request) throws Exception {
		UserResponse response = new UserResponse();

		UserDTO returnUser = authenticationDAO.getUserResponse(request.getUserId());
		returnUser.setContact(contactDAO.getContact(returnUser.getUserId()));
		response.setUser(returnUser);

		response.setReturnMessage("Successfully retrieved user details");
		response.setReturnVal(OnTargetConstant.SUCCESS);

		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse updateCompanyInfo(CompanyInfoEditRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();

		CompanyEditInfo companyEditInfo = request.getCompany();

		boolean updated = companyDAO.update(companyEditInfo);
		if (updated) {
			response.setReturnMessage("Successfully updated company details");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("Error while updating company details");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	public Contact getContact(long userId) throws Exception {
		return contactDAO.getContact((int) userId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean changeUserPassword(Integer userId, String newPassword, String currentPassword) throws Exception {
		UserDTO user = userDAO.getUser(userId);
		if (user == null) {
			throw new Exception("user not found");
		}

		String currentHashedPassword = Security.encodePassword(currentPassword, user.getSalt());
		if (!user.getPassword().equals(currentHashedPassword)) {
			throw new Exception("Wrong password provided. User not authenticated to change password");
		}

		String newSalt = Security.generateSecureSalt();
		String newHashedPassword = Security.encodePassword(newPassword, newSalt);
		return authenticationDAO.changePassword(userId, newHashedPassword, newSalt);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean changeForgotPassword(String token, String newPassword) throws Exception {

		Map<String, Object> forgotPasswordRequest = userDAO.getForgotPasswordRequest(token);
		if (forgotPasswordRequest == null) {
			throw new Exception("Forgot Password has already expired.");
		}

		int userId = (int) forgotPasswordRequest.get("user_id");

		UserDTO user = userDAO.getUser(userId);
		if (user == null) {
			throw new Exception("user not found");
		}

		String newSalt = Security.generateSecureSalt();
		String newHashedPassword = Security.encodePassword(newPassword, newSalt);
		boolean changed = authenticationDAO.changePassword(userId, newHashedPassword, newSalt);

		if (!changed) {
			throw new Exception("Error while changing forgot password");
		}

		/**
		 * after successfully changing the forgot password expire the token
		 */
		return userDAO.expireForgotPasswordRequest(token);
	}

	@Override
	public Company getCompanyInfoByUser(int userId) throws Exception {
		return null;
	}

	// @Override
	// @Transactional(rollbackFor = { Exception.class })
	// public boolean saveRegistration(int projectId, String firstName, String
	// lastName, String email, String tokenId,
	// String accountStatus) throws Exception {
	// return userRegistrationDAO.saveRegistrationInvitation(projectId,
	// firstName, lastName, email, tokenId, accountStatus) != 0;
	// }

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean saveRegistration(UserInvitationRequestDTO request) throws Exception {
		return userRegistrationDAO.saveRegistrationInvitation(request);
	}

	public UserRegistration getRegistration(String token) throws Exception {
		return userRegistrationDAO.getInvitationRegistration(token);
	}

	@Override
	public String getRandomSafetyUserInfo(Integer userId) throws Exception {
		UserDTO user = userDAO.getUser(userId);
		if (user.getDiscipline() == 0) {
			return null;
		}

		return userSafetyInfoDAO.getRandomSafetyInfo(user.getDiscipline());
	}

	// @Override
	// @Transactional(rollbackFor = { Exception.class })
	// public OnTargetResponse createNewUserFromInvitation(UserRegistrationInfo
	// registration) throws Exception {
	// OnTargetResponse response = new OnTargetResponse();
	// UserRegistration registrationRequest =
	// userRegistrationDAO.getInvitationRegistration(registration
	// .getRegistrationToken());
	//
	// if (registrationRequest != null) {
	// if (!userDAO.usernameAlreadyRegistered(registration.getUsername())) {
	//
	// User user = userRegistrationDAO.createNewuser(registration,
	// registrationRequest.getStatus());
	//
	// int updated =
	// userRegistrationDAO.updateRegistrationRequestUserId(user.getUserId(),
	// registration.getRegistrationToken());
	// if (updated <= 0) {
	// response.setReturnVal(OnTargetConstant.ERROR);
	// response.setReturnMessage("Error while creating user");
	// } else {
	// response.setReturnMessage("Successfully created user based on invitation.");
	// response.setReturnVal(OnTargetConstant.SUCCESS);
	// }
	// } else {
	// response.setReturnVal(OnTargetConstant.ERROR);
	// response.setReturnMessage("Username already registered");
	// }
	// } else {
	// response.setReturnVal(OnTargetConstant.ERROR);
	// response.setReturnMessage("Invalid registration");
	// }
	//
	// return response;
	// }

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public OnTargetResponse createNewUserFromInvitation(UserSignupRequest request) throws Exception {
		OnTargetResponse response = new OnTargetResponse();
		UserRegistration registrationRequest = userRegistrationDAO.getInvitationRegistration(request.getRegistrationToken());

		if (registrationRequest != null) {
			if (!userDAO.usernameAlreadyRegistered(request.getUsername())) {

				User user = userRegistrationDAO.createNewuser(request, registrationRequest.getStatus());
				logger.info("user id: " + user.getUserId());
				int userUpdated = userRegistrationDAO.updateRegistrationRequestUserId(user.getUserId(), request.getRegistrationToken());
				if (userUpdated <= 0) {
					throw new Exception("Could not update user info in registration request");
				}

				Company company = ConvertPOJOUtils.convertToCompany(registrationRequest);
				int companyId;
				logger.info("company id from registration request: " + registrationRequest.getCompanyId());
				if (registrationRequest.getCompanyId() != 0) {
					companyId = registrationRequest.getCompanyId();
				} else {
					companyId = companyDAO.addCompanyInfo(company);
					userRegistrationDAO.updateRegistrationRequestCompanyId(companyId, request.getRegistrationToken());
				}
				logger.info("company id: " + companyId);

				Contact contact = ConvertPOJOUtils.convertToContact(request);

				company.setCompanyId(companyId);

				contact.setCompany(company);

				UserDTO userDTO = new UserDTO();
				userDTO.setUserId(user.getUserId());
				userDTO.setAccountStatus(user.getAccountStatus());

				int userId = userDTO.getUserId();
				contact.setUser(userDTO);

				boolean saved = contactDAO.addContactInfo(contact, userId);
				if (!saved) {
					throw new Exception("Contact not saved.");
				}

				logger.info("contact list:" + user.getContactList());
				Contact contactForPhone = contactDAO.getContact(userId);
				int contactId = contactForPhone.getContactId();

				ContactPhone phone = new ContactPhone();
				phone.setPhoneType(OnTargetConstant.PhoneType.CELL);
				phone.setStatus(OnTargetConstant.PhoneStatus.ACTIVE);
				phone.setPhoneNumber(request.getPhoneNumber());
				phone.setAreaCode(request.getAreaCode());

				int phoneId = phoneDAO.addContactPhone(contactId, phone);

				if (phoneId <= 0) {
					throw new Exception("Error while adding phone");
				}

				// if user is invited from a request-demo then add project
				logger.info("project id: " + registrationRequest.getInvitedProjectId());
				if (registrationRequest.getInvitedProjectId() == 0) {
					CompanyInfo companyInfo = companyDAO.getCompanyInfo(companyId);
					ProjectDTO projectDTO = ConvertPOJOUtils.setMainProject(companyInfo);
					int addedProjectId = projectDAO.addMainProject(projectDTO, companyInfo, user.getUserId());
					// add main project for request a demo user
					if (addedProjectId <= 0) {
						throw new Exception("Error while adding main project");
					}
					userInvitationDAO.updateRegistrationRequestProjectIdByUser(addedProjectId, userId);
				}

				boolean activated = this.activateAccount(user.getUserId());
				if (!activated) {
					throw new Exception("Error while activating account");
				}

				response.setReturnMessage("Successfully created user.");
				response.setReturnVal(OnTargetConstant.SUCCESS);

			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				response.setReturnMessage("Username already registered");
			}
		} else {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Invalid registration");
		}

		return response;
	}

	@Override
	public boolean activateAccount(int userId) throws Exception {
		int updated = userRegistrationDAO.activateAccount(userId);
		if (updated <= 0) {
			throw new Exception("Error while activating account");
		}

		// update project member
		UserRegistration userRegistration = userRegistrationDAO.getInvitationRegistrationByUser(userId);

		int added = projectDAO.addProjectMember((int) userRegistration.getProjectId(), userId);
		if (added <= 0) {
			throw new Exception("Error while adding project member");
		}
		return true;
	}

	@Override
	public boolean forgotPasswordRequest(String emailAddress) throws Exception {

		logger.debug("Adding forgot password request: " + emailAddress);

        Email email = emailDao.getByEmailAddress(emailAddress);
        if(email == null || email.getUser() == null){
            throw new Exception("Error while fetching email");
        }


		UserDTO existingUser = authenticationDAO.getUserInfoById(email.getUser().getUserId());
		if (existingUser != null && existingUser.getUserId() > 0) {

			final String forgotPasswordToken = Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
			int id = userDAO.saveForgotPasswordRequest(existingUser.getUserId(), forgotPasswordToken);

			Contact contact = contactDAO.getContact(existingUser.getUserId());
			if (id > 0) {
				emailService.sendForgotPasswordEmail(emailAddress, contact.getFirstName() + " " + contact.getLastName(),
						forgotPasswordToken);
			}

			return true;

		}
		return false;
	}

	@Override
	public boolean validateForgotPasswordToken(String forgotPasswordToken) throws Exception {
		int count = userDAO.getForgotPasswordRequestCount(forgotPasswordToken);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveUserImage(UserImageRequest userImageRequest) throws Exception {
		return contactDAO.saveUserImagePath(userImageRequest.getUserId(), userImageRequest.getImagePath(),
				userImageRequest.getModifyingUser());
	}

	@Override
	public int generateUserId() throws Exception {
		return random.nextInt(Integer.MAX_VALUE);
	}

}
