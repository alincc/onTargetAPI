package com.ontarget.api.jpa.dao.impl;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ontarget.api.repository.EmailRepository;
import com.ontarget.api.repository.ProfileRepository;
import com.ontarget.api.repository.RegistrationRequestRepository;
import com.ontarget.api.repository.UserProfileRepository;
import com.ontarget.api.repository.UserRepository;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entities.Discipline;
import com.ontarget.entities.Email;
import com.ontarget.entities.Profile;
import com.ontarget.entities.RegistrationRequest;
import com.ontarget.entities.User;
import com.ontarget.entities.UserProfile;
import com.ontarget.entities.UserType;
import com.ontarget.request.bean.UserSignupRequest;
import com.ontarget.util.Security;

@Repository("userRegistrationJpaDAOImpl")
public class UserRegistrationJpaDAOImpl implements com.ontarget.api.dao.UserRegistrationDAO {
	private Logger logger = Logger.getLogger(UserRegistrationJpaDAOImpl.class);

	@Resource
	private RegistrationRequestRepository registrationRequestRepository;
	@Resource
	private EmailRepository emailRepository;
	@Resource
	private UserRepository userRepository;
	@Resource
	private ProfileRepository profileRepository;
	@Resource
	private UserProfileRepository userProfileRepository;

	@Override
	public boolean saveRegistrationInvitation(UserInvitationRequestDTO userInvitationRequestDTO, String status) throws Exception {
		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setFirstName(userInvitationRequestDTO.getFirstName());
		registrationRequest.setLastName(userInvitationRequestDTO.getLastName());
		registrationRequest.setEmail(userInvitationRequestDTO.getEmail());
		registrationRequest.setPhoneNumber(userInvitationRequestDTO.getPhoneNumber());
		registrationRequest.setMsg(userInvitationRequestDTO.getMsg());
		registrationRequest.setStatus(status);
		registrationRequest.setRegistrationToken(userInvitationRequestDTO.getToken());
		registrationRequest.setCompanyName(userInvitationRequestDTO.getCompanyName());
		registrationRequest.setCompanyAddress1(userInvitationRequestDTO.getCompanyAddress1());
		registrationRequest.setCompanyAddress2(userInvitationRequestDTO.getCompanyAddress2());
		registrationRequest.setCompanyCity(userInvitationRequestDTO.getCompanyCity());
		registrationRequest.setCompanyState(userInvitationRequestDTO.getCompanyState());
		registrationRequest.setCompanyCountry(userInvitationRequestDTO.getCompanyCountry());
		registrationRequest.setCompanyZip(userInvitationRequestDTO.getCompanyZip());
		registrationRequest.setCompanyId(userInvitationRequestDTO.getCompanyId());
		registrationRequest.setCompanyTypeId(userInvitationRequestDTO.getCompanyTypeId());
		if (registrationRequest.getCompanyTypeId() == null) {
			registrationRequest.setCompanyTypeId(0);
		}
		registrationRequest.setProjectId(userInvitationRequestDTO.getProjectId());
		registrationRequestRepository.save(registrationRequest);
		return true;
	}

	@Override
	public UserRegistration getInvitationRegistration(String tokenId) throws Exception {

		RegistrationRequest registrationRequest = registrationRequestRepository.findByRegistrationToken(tokenId);

		UserRegistration userRegistration = new UserRegistration();
		userRegistration.setFirstName(registrationRequest.getFirstName());
		userRegistration.setLastName(registrationRequest.getLastName());
		userRegistration.setEmail(registrationRequest.getEmail());
		userRegistration.setStatus(registrationRequest.getStatus());
		userRegistration.setRegistrationToken(tokenId);
		if (registrationRequest.getTsCreate() != null) {
			userRegistration.setTsCreate((registrationRequest.getTsCreate()).getTime());
		}
		userRegistration.setCompanyName(registrationRequest.getCompanyName());
		userRegistration.setCompanyAddress1(registrationRequest.getCompanyAddress1());
		userRegistration.setCompanyAddress2(registrationRequest.getCompanyAddress2());
		userRegistration.setCompanyCity(registrationRequest.getCompanyCity());
		userRegistration.setCompanyState(registrationRequest.getCompanyState());
		userRegistration.setCompanyZip(registrationRequest.getCompanyZip());
		userRegistration.setCompanyCountry(registrationRequest.getCompanyCountry());
		userRegistration.setCompanyId(registrationRequest.getCompanyId());
		userRegistration.setCompanyTypeId(registrationRequest.getCompanyTypeId());
		userRegistration.setInvitedProjectId(registrationRequest.getProjectId());
		return userRegistration;
	}

	@Override
	public User createNewuser(UserSignupRequest request, String status) throws Exception {
		String password = request.getPassword();
		String salt = Security.generateSecureSalt();
		String hashedPassword = Security.encodePassword(password, salt);

		User user = new User();
		user.setUserName(request.getUsername());
		user.setUserType(new UserType(1));
		user.setPassword(hashedPassword);
		user.setSalt(salt);
		user.setDiscipline(new Discipline(new Long(request.getDiscipline())));
		user.setUserStatus(OnTargetConstant.USER_STATUS.ACTIVE);
		user.setNumberOfLogin(1);
		user.setModifiedDate(new Date());
		user.setAccountStatus(status);
		userRepository.save(user);
		logger.info("persist user: " + user.getUserId());

		Email email = new Email();
		email.setEmailAddress(request.getEmail());
		email.setStatus("ACTIVE");
		email.setUser(user);
		email.setAddedDate(new Date());
		emailRepository.save(email);
		logger.info("persist email: " + email.getEmailId());

		return user;
	}

	@Override
	public UserProfile assignProfilesToUser(String userType, int userId) {
		Profile profile = profileRepository.findProfileByCode(userType);
		UserProfile userProfile = new UserProfile();
		userProfile.setProfile(profile);
		userProfile.setUser(new User(userId));
		userProfileRepository.save(userProfile);
		return userProfile;
	}

	@Override
	public int updateRegistrationRequestUserId(int userId, String tokenId) throws Exception {

		RegistrationRequest registrationRequest = registrationRequestRepository.findByRegistrationToken(tokenId);
		registrationRequest.setUserId(userId);
		registrationRequestRepository.save(registrationRequest);
		return 1;
	}

	@Override
	public int updateRegistrationRequestCompanyId(int companyId, String tokenId) throws Exception {
		RegistrationRequest registrationRequest = registrationRequestRepository.findByRegistrationToken(tokenId);
		registrationRequest.setCompanyId(companyId);
		registrationRequestRepository.save(registrationRequest);
		return 1;
	}

	@Override
	public int activateAccount(int userId) throws Exception {
		userRepository.activeUserAccount("ACTIVE", userId);
		return 1;
	}

	@Override
	public UserRegistration getInvitationRegistrationByUser(int userId) throws Exception {
		RegistrationRequest registrationRequest = registrationRequestRepository.findByUserId(userId);

		UserRegistration userRegistration = new UserRegistration();
		Object d = null;
		userRegistration.setFirstName(registrationRequest.getFirstName());
		userRegistration.setLastName(registrationRequest.getLastName());
		userRegistration.setEmail(registrationRequest.getEmail());
		userRegistration.setStatus(registrationRequest.getStatus());
		userRegistration.setCompanyName(registrationRequest.getCompanyName());
		userRegistration.setCompanyAddress1(registrationRequest.getCompanyAddress1());
		userRegistration.setCompanyAddress2(registrationRequest.getCompanyAddress2());
		userRegistration.setCompanyCity(registrationRequest.getCompanyCity());
		userRegistration.setCompanyState(registrationRequest.getCompanyState());
		userRegistration.setCompanyZip(registrationRequest.getCompanyZip());
		userRegistration.setCompanyCountry(registrationRequest.getCompanyCountry());
		userRegistration.setCompanyId(registrationRequest.getCompanyId());
		userRegistration.setCompanyTypeId(registrationRequest.getCompanyTypeId());
		userRegistration.setInvitedProjectId(registrationRequest.getProjectId());

		d = registrationRequest.getProjectId();

		if (d != null) {
			if (d instanceof Long)
				userRegistration.setProjectId((Long) d);
			else if (d instanceof Integer) {
				userRegistration.setProjectId((Integer) d);
			} else
				userRegistration.setProjectId(Long.parseLong((String) d));
		}
		d = registrationRequest.getTsCreate();
		if (d != null) {
			userRegistration.setTsCreate(((Timestamp) d).getTime());
		}

		return userRegistration;

	}

}
