package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.ontarget.api.service.UserProjectProfileService;
import com.ontarget.entities.*;
import com.ontarget.enums.MemberShipType;
import com.ontarget.response.bean.UserProjectProfileResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.EmailDAO;
import com.ontarget.api.dao.PhoneDAO;
import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.UserDAO;
import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.api.dao.UserRegistrationDAO;
import com.ontarget.api.dao.UserSafetyInfoDAO;
import com.ontarget.api.repository.EmailRepository;
import com.ontarget.api.repository.ProfileFeatureRepository;
import com.ontarget.api.repository.ProfileMenuRepository;
import com.ontarget.api.repository.ProfileRepository;
import com.ontarget.api.repository.RegistrationRequestRepository;
import com.ontarget.api.repository.UserProfileRepository;
import com.ontarget.api.service.EmailService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ContactPhone;
import com.ontarget.bean.ProfileFeatureInfo;
import com.ontarget.bean.ProfileMenuInfo;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.UserDTO;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.ForgotPasswordRequestResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.request.bean.CompanyEditInfo;
import com.ontarget.request.bean.CompanyInfoEditRequest;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserContactInfo;
import com.ontarget.request.bean.UserInfo;
import com.ontarget.request.bean.UserSignupRequest;
import com.ontarget.util.CompanyUtil;
import com.ontarget.util.ConvertPOJOUtils;
import com.ontarget.util.Security;
import com.ontarget.enums.UserType;

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

    @Autowired
    private UserProjectProfileService userProjectProfileService;


	@Autowired
	private UserProfileRepository userProfileRepository;
	@Autowired
	private ProfileRepository profileRepository;
	@Autowired
	private ProfileMenuRepository profileMenuRepository;
	@Autowired
	private ProfileFeatureRepository profileFeatureRepository;
	@Autowired
	private EmailRepository emailRepository;
	@Autowired
	private RegistrationRequestRepository registrationRequestRepository;

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
			companyId = companyDAO.addCompanyInfo(company, userInfo.getUserId());
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
		logger.info("Updating company info for company id " + request.getCompany().getCompanyId());
		OnTargetResponse response = new OnTargetResponse();

		CompanyEditInfo companyEditInfo = request.getCompany();

		CompanyInfo companyInfo = companyDAO.getCompanyInfo(request.getCompany().getCompanyId());

		if (!CompanyUtil.isUserAllowedToEditCompany(companyInfo.getAddedBy(), request.getBaseRequest().getLoggedInUserId())) {
			logger.debug("user not allowed to edit company details");
			response.setReturnMessage("You are not authorized to edit company details.");
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}

		boolean updated = companyDAO.update(companyEditInfo, request.getBaseRequest().getLoggedInUserId());
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
	public boolean saveRegistration(UserInvitationRequestDTO request, String status) throws Exception {
		return userRegistrationDAO.saveRegistrationInvitation(request, status);
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
    public String getRandomSafetyUserInfoById() throws Exception {
        return userSafetyInfoDAO.getRandomSafetyInfoByID();
    }

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
				String userType = UserType.SUPERUSER.getCode();

				if (registrationRequest.getStatus().equalsIgnoreCase(OnTargetConstant.AccountStatus.ACCOUNT_INVITATION)) {
					userType = UserType.REGULARUSER.getCode();
				}

				if (registrationRequest.getCompanyId() != 0) {
					companyId = registrationRequest.getCompanyId();
				} else {
					companyId = companyDAO.addCompanyInfo(company, user.getUserId());
					userRegistrationDAO.updateRegistrationRequestCompanyId(companyId, request.getRegistrationToken());
				}

				userRegistrationDAO.assignProfilesToUser(userType, user.getUserId());

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

				// if user is invited to a project
				logger.info("project id: " + registrationRequest.getInvitedProjectId());
				if (!(registrationRequest.getInvitedProjectId() == 0)) {
                    /**
                     * give this user RU profile for this project
                     */
                    // give this user RU profile.
                    UserProjectProfile projectProfile = new UserProjectProfile();
                    projectProfile.setStatus(OnTargetConstant.UserProjectProfileStatus.ACTIVE);
                    projectProfile.setProject(new Project((int)registrationRequest.getProjectId()));

                    projectProfile.setUser(new User(userId));
                    projectProfile.setProfile(new Profile(UserType.REGULARUSER.getProfileId())); //TODO: create service layer to get profile id
                    userProjectProfileService.saveOrUpdate(projectProfile);


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
	public ForgotPasswordRequestResponse forgotPasswordRequest(String username) throws Exception {

		ForgotPasswordRequestResponse response = new ForgotPasswordRequestResponse();

		logger.debug("Adding forgot password request: " + username);

		User user = userDAO.findUserByUsername(username);

		if (user == null) {
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Username not found");
			return response;
		}

		Email email = user.getEmail();

		final String forgotPasswordToken = Security.generateRandomValue(OnTargetConstant.TOKEN_LENGTH);
		int id = userDAO.saveForgotPasswordRequest(user.getUserId(), forgotPasswordToken);

		Contact contact = contactDAO.getContact(user.getUserId());
		if (id > 0) {
			emailService.sendForgotPasswordEmail(email.getEmailAddress(), contact.getFirstName() + " " + contact.getLastName(),
					forgotPasswordToken);
		}
		response.setReturnVal(OnTargetConstant.SUCCESS);
		response.setReturnMessage("Email has been sent to " + email.getEmailAddress() + " with password reset instructions.");
		return response;
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

	@Override
	public com.ontarget.response.bean.UserProfileResponse getUserProfileInfo(int userId) throws Exception {
		com.ontarget.response.bean.UserProfileResponse response = new com.ontarget.response.bean.UserProfileResponse();
		logger.debug("Getting user profile info for user: " + userId);
		UserProfile userProfile = userProfileRepository.getUserProfielbyUserId(userId);
		Profile profile = userProfile.getProfile();
		logger.debug("profile id: " + profile.getProfileId());

        response.setMembershipType(MemberShipType.getMemberShipCodeByProfileCode(profile.getProfileCode()));
		response.setReturnMessage("Successfully retrieved user profile details");
		response.setReturnVal(OnTargetConstant.SUCCESS);
		return response;
	}


    @Override
    public UserProjectProfileResponse getUserProfileInfoByProject(int userId, int projectId) throws Exception {
        com.ontarget.response.bean.UserProjectProfileResponse response = new com.ontarget.response.bean.UserProjectProfileResponse();

        logger.debug("Getting user project profile info for user: " + userId + " and project: "+ projectId);
        UserProjectProfile userProjectProfile = userProjectProfileService.getProfileByUserAndProject(projectId,userId);
        Profile profile = userProjectProfile.getProfile();
        logger.debug("profile id: " + profile.getProfileId());

        List<ProfileMenu> profileMenuList = profileMenuRepository.findByProfileId(profile.getProfileId());
        List<ProfileFeature> profileFeatureList = profileFeatureRepository.findByProfileId(profile.getProfileId());

        List<ProfileMenuInfo> menuList = new ArrayList<>();
        List<ProfileFeatureInfo> featureList = new ArrayList<>();

        if (profileMenuList != null && !profileMenuList.isEmpty()) {
            for (ProfileMenu profileMenu : profileMenuList) {
                if (profileMenu.getActive().equals(new Character('Y'))) {
                    ProfileMenuInfo profileMenuInfo = new ProfileMenuInfo();
                    profileMenuInfo.setMenuKey(profileMenu.getApplicationMenu().getMenuKey());
                    profileMenuInfo.setMenuName(profileMenu.getApplicationMenu().getMenuName());
                    menuList.add(profileMenuInfo);
                }
            }
        }

        if (profileFeatureList != null && !profileFeatureList.isEmpty()) {
            for (ProfileFeature profileFeature : profileFeatureList) {
                if (profileFeature.getActive().equals(new Character('Y'))) {
                    ProfileFeatureInfo profileFeatureInfo = new ProfileFeatureInfo();
                    profileFeatureInfo.setFeatureKey(profileFeature.getApplicationFeature().getFeatureKey());
                    profileFeatureInfo.setFeatureName(profileFeature.getApplicationFeature().getFeatureName());
                    featureList.add(profileFeatureInfo);
                }
            }
        }
        response.setMenuList(menuList);
        response.setFeatureList(featureList);
        response.setProjectId(projectId);
        response.setUserId(userId);
        response.setReturnMessage("Successfully retrieved user profile details by project");
        response.setReturnVal(OnTargetConstant.SUCCESS);
        return response;
    }



	@Override
	public Email findEmailByEmailAddres(String emailAddress) throws Exception {
		return emailRepository.getByEmailAddress(emailAddress);
	}

	@Override
	public RegistrationRequest findRegistrationRequestByToken(String token) throws Exception {
		return registrationRequestRepository.findByRegistrationToken(token);
	}

    /**
     * Check to see if this user is SU so that he can create projects.
     * @param userId
     * @return
     * @throws Exception
     */
    @Override
    public boolean isAllowedToCreateProject(Integer userId) throws Exception {
        UserProfile userProfile =  userProfileRepository.getUserProfielbyUserId(userId);
        return userProfile.getProfile().getProfileCode().equals(UserType.SUPERUSER.getCode());
    }

    @Override
	public boolean assignProjectToMember(RegistrationRequest registrationRequest) throws Exception {
		logger.info("Adding user into invited project");

		User user = userDAO.findUserByEmailAddress(registrationRequest.getEmail());
		logger.debug("user: " + user);

		if (user == null) {
			return false;
		}

		int added = projectDAO.addMemberToProject(registrationRequest.getProjectId(), user.getUserId());
		logger.debug("added: " + added);
		if (added <= 0) {
			throw new Exception("Error while adding project member");
		}
		return true;
	}
}
