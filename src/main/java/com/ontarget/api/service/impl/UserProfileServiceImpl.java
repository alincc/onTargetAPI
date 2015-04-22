package com.ontarget.api.service.impl;

import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.PhoneDAO;
import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.UserDAO;
import com.ontarget.api.dao.UserRegistrationDAO;
import com.ontarget.api.dao.UserSafetyInfoDAO;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ContactPhone;
import com.ontarget.bean.UserDTO;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.entities.User;
import com.ontarget.request.bean.CompanyEditInfo;
import com.ontarget.request.bean.CompanyInfoEditRequest;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserCompanyInfo;
import com.ontarget.request.bean.UserContactInfo;
import com.ontarget.request.bean.UserInfo;
import com.ontarget.request.bean.UserRegistrationInfo;
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

	private Random random = new Random();

	// TODO: separate logic of user profile and company profile.
	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception {
		logger.info("Request to add user profile" + request);
		UserProfileResponse response = new UserProfileResponse();

		UserCompanyInfo userCompanyInfo = request.getCompany();

		Company company = ConvertPOJOUtils.convertToCompany(userCompanyInfo);
		int companyId = companyDAO.addCompanyInfo(company);

		UserContactInfo userContactInfo = request.getContact();
		Contact contact = ConvertPOJOUtils.convertToContact(userContactInfo);

		company.setCompanyId(companyId);

		contact.setCompany(company);

		UserInfo userInfo = request.getUser();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userInfo.getUserId());
		userDTO.setAccountStatus(userInfo.getAccountStatus());

		contact.setUser(userDTO);

		boolean saved = contactDAO.addContactInfo(contact);
		if (!saved) {
			throw new Exception("Contact not saved.");
		}

		Contact contactForPhone = contactDAO.getContact(userDTO.getUserId());
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

		// activate the account.
		String accountStatus = userDTO.getAccountStatus();
		if (OnTargetConstant.AccountStatus.ACCOUNT_INVITATION.equals(accountStatus)) {
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
	public OnTargetResponse updateUserProfileAndContactInfo(UpdateUserProfileRequest request) throws Exception {
		logger.info("Request to add user profile" + request);
		OnTargetResponse response = new OnTargetResponse();

		UserContactInfo userContactInfo = request.getContact();
		Contact contact = ConvertPOJOUtils.convertToContact(userContactInfo);

		UserInfo userInfo = request.getUser();
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userInfo.getUserId());

		contact.setUser(userDTO);

		boolean saved = contactDAO.updateContactInfo(contact);
		if (saved) {
			response.setReturnMessage("Successfully created company and user profile");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} else {
			response.setReturnMessage("No Rows were updated. Seems User does not exists or may not have any contact info");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

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

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean saveRegistration(int projectId, String firstName, String lastName, String email, String tokenId,
			String accountStatus) throws Exception {
		return userRegistrationDAO.saveRegistrationInvitation(projectId, firstName, lastName, email, tokenId, accountStatus) != 0;
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

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean createNewUserFromInvitation(UserRegistrationInfo registration) throws Exception {
		UserRegistration registrationFrom = userRegistrationDAO.getInvitationRegistration(registration.getRegistrationToken());
		int userId = generateUserId();
		boolean flag = false;
		User user = null;
		int t = 0;
		do {
			t++;
			try {
				user = userRegistrationDAO.createNewuser(registration, registrationFrom.getStatus());
			} catch (DuplicateKeyException e) {
				e.printStackTrace();
				flag = true; // re run it
				logger.info("duplicate key ", e);
			}
		} while (flag && t < 20);
		if (flag) { // maximum value encountered i.e. wrong value used
			throw new Exception(
					"Maximum allowed id generation per user is exhausted. There is serious issue with this system. Please check");
		}
		// update registration request user id by token.
		int updated = userRegistrationDAO.updateRegistrationRequestUserId(user.getUserId(), registration.getRegistrationToken());
		if (updated <= 0)
			throw new Exception("Error while updating registration request user id");

		return true;
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
		/**
		 * check userlogin table for email address.
		 */
		UserDTO user = new UserDTO();
		user.setUsername(emailAddress);

		UserDTO existingUser = authenticationDAO.getUserInfoByUsername(user);
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
