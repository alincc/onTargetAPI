package com.ontarget.api.service.impl;

import com.ontarget.api.dao.*;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.request.bean.UserRegistrationRequest;
import com.ontarget.util.Security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Random;

/**
 * Created by Owner on 11/4/14.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

	private Logger logger = Logger.getLogger(UserProfileServiceImpl.class);

	@Autowired
	private CompanyDAO companyDAO;

	@Autowired
	private ContactDAO contactDAO;

	@Autowired
	private AuthenticationDAO authenticationDAO;

	@Autowired
	private UserRegistrationDAO userRegistrationDAO;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserSafetyInfoDAO userSafetyInfoDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private PhoneDAO phoneDAO;

	@Autowired
	private EmailService emailService;

	private Random random = new Random();

	// TODO: separate logic of user profile and company profile.
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UserProfileResponse addUserProfile(UserProfileRequest request)
			throws Exception {
		logger.info("Request to add user profile" + request);
		UserProfileResponse response = new UserProfileResponse();
		// add company.

		int companyId = companyDAO.addCompanyInfo(request.getCompany());

		Contact contact = request.getContact();

		Company company = request.getCompany();
		company.setCompanyId(companyId);

		contact.setCompany(company);
		contact.setUser(request.getUser());

		boolean saved = contactDAO.addContactInfo(request.getContact());
		if (!saved) {
			throw new Exception("Contact not saved.");
		}

		Contact contactForPhone = contactDAO.getContact(request.getUser()
				.getUserId());
		int contactId = contactForPhone.getContactId();

		// phone type should be CELL. THIS NEEDS TO BE COLLECTED FROM UI.
		ContactPhone phone = request.getContactPhone();
		phone.setPhoneType(OnTargetConstant.PhoneType.CELL);
		phone.setStatus(OnTargetConstant.PhoneStatus.ACTIVE);

		int phoneId = phoneDAO.addContactPhone(contactId,
				request.getContactPhone());

		if (phoneId <= 0) {
			throw new Exception("Error while adding phone");
		}

		// activate the account.
		String accountStatus = request.getUser().getAccountStatus();
		if (OnTargetConstant.AccountStatus.ACCOUNT_INVITATION
				.equals(accountStatus)) {
			boolean updated = this.activateAccount(request.getUser()
					.getUserId());
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
	public OnTargetResponse updateUserProfileAndContactInfo(
			UserProfileRequest request) throws Exception {
		logger.info("Request to add user profile" + request);
		OnTargetResponse response = new OnTargetResponse();
		Contact contact = request.getContact();
		contact.setUser(request.getUser());

		boolean saved = contactDAO.updateContactInfo(request.getContact());
		if (saved) {
			response.setReturnMessage("Successfully created company and user profile");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("No Rows were updated. Seems User does not exists or may not have any contact info");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	public Contact getContact(long userId) throws Exception {
		return contactDAO.getContact(userId);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean changeUserPassword(long userId, String newPassword,
			String currentPassword) throws Exception {
		UserDTO user = userDAO.getUser(userId);
		if (user == null) {
			throw new Exception("user not found");
		}

		String currentHashedPassword = Security.encodePassword(currentPassword,
				user.getSalt());
		if (!user.getPassword().equals(currentHashedPassword)) {
			throw new Exception(
					"Wrong password provided. User not authenticated to change password");
		}

		String newSalt = Security.generateSecureSalt();
		String newHashedPassword = Security
				.encodePassword(newPassword, newSalt);
		return authenticationDAO.changePassword(userId, newHashedPassword,
				newSalt);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean changeForgotPassword(String token, String newPassword)
			throws Exception {

		Map<String, Object> forgotPasswordRequest = userDAO
				.getForgotPasswordRequest(token);
		if (forgotPasswordRequest == null) {
			throw new Exception("Forgot Password has already expired.");
		}

		int userId = (int) forgotPasswordRequest.get("user_id");

		UserDTO user = userDAO.getUser(userId);
		if (user == null) {
			throw new Exception("user not found");
		}

		String newSalt = Security.generateSecureSalt();
		String newHashedPassword = Security
				.encodePassword(newPassword, newSalt);
		boolean changed = authenticationDAO.changePassword(userId,
				newHashedPassword, newSalt);

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

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean saveRegistration(int projectId, String firstName,
			String lastName, String email, String tokenId, String accountStatus)
			throws Exception {
		return userRegistrationDAO.saveRegistrationInvitation(projectId,
				firstName, lastName, email, tokenId, accountStatus) != 0;
	}

	public UserRegistration getRegistration(String token) throws Exception {
		return userRegistrationDAO.getInvitationRegistration(token);
	}

	@Override
	public String getRandomSafetyUserInfo(long userId) throws Exception {
		UserDTO user = userDAO.getUser(userId);
		if (user.getDiscipline() == 0) {
			return null;
		}

		return userSafetyInfoDAO.getRandomSafetyInfo(user.getDiscipline());
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean createNewUserFromInvitation(
			UserRegistrationRequest registration) throws Exception {
		// get token info and create user based on the status: ACCT_NEW or
		// ACCT_INVITE
		UserRegistration registrationFromDB = userRegistrationDAO
				.getInvitationRegistration(registration.getRegistrationToken());
		int userId = generateUserId();
		boolean flag = false;
		int t = 0;
		do {
			t++;
			try {
				userRegistrationDAO.createNewuser(registration,
						registrationFromDB.getStatus(), userId);
			} catch (DuplicateKeyException e) {
				flag = true; // re run it
				logger.info("duplicate key ", e);
			}
		} while (flag && t < 20);
		if (flag) { // maximum value encountered i.e. wrong value used
			throw new Exception(
					"Maximum allowed id generation per user is exhausted. There is serious issue with this system. Please check");
		}
		// update registration request user id by token.
		int updated = userRegistrationDAO.updateRegistrationRequestUserId(
				userId, registration.getRegistrationToken());
		if (updated <= 0)
			throw new Exception(
					"Error while updating registration request user id");

		return true;
	}

	@Override
	public boolean activateAccount(int userId) throws Exception {
		int updated = userRegistrationDAO.activateAccount(userId);
		if (updated <= 0) {
			throw new Exception("Error while activating account");
		}

		// update project member
		UserRegistration userRegistration = userRegistrationDAO
				.getInvitationRegistrationByUser(userId);
		int added = projectDAO.addProjectMember(
				(int) userRegistration.getProjectId(), userId);
		if (added <= 0) {
			throw new Exception("Error while adding project member");
		}

		return true;
	}

	@Override
	public boolean forgotPasswordRequest(String emailAddress) throws Exception {

		logger.debug("Adding forgot password request: " + emailAddress);
		/**
		 * check userlogin table for email address.
		 */
		UserDTO user = new UserDTO();
		user.setUsername(emailAddress);

		UserDTO existingUser = authenticationDAO.getUserInfoByUsername(user);
		if (existingUser != null && existingUser.getUserId() > 0) {
			/**
			 * create a entry in forgot password request
			 */
			// generate token id
			final String forgotPasswordToken = Security
					.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
			int id = userDAO.saveForgotPasswordRequest(
					existingUser.getUserId(), forgotPasswordToken);
			/**
			 * send email
			 */
			Contact contact = contactDAO.getContact(existingUser.getUserId());
			if (id > 0) {
				emailService.sendForgotPasswordEmail(emailAddress,
						contact.getFirstName() + " " + contact.getLastName(),
						forgotPasswordToken);
			}

			return true;

		}
		return false;
	}

	@Override
	public boolean validateForgotPasswordToken(String forgotPasswordToken)
			throws Exception {
		int count = userDAO.getForgotPasswordRequestCount(forgotPasswordToken);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean saveUserImage(UserImageRequest userImageRequest)
			throws Exception {
		return contactDAO.saveUserImagePath(userImageRequest.getUserId(),
				userImageRequest.getImagePath(),
				userImageRequest.getModifyingUser());
	}

	@Override
	public int generateUserId() throws Exception {
		return random.nextInt(Integer.MAX_VALUE);
	}

}
