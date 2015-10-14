package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UserDAO;
import com.ontarget.api.repository.ContactRepository;
import com.ontarget.api.repository.EmailRepository;
import com.ontarget.api.repository.ForgotPasswordRequestRepository;
import com.ontarget.api.repository.PhoneRepository;
import com.ontarget.api.repository.UserRepository;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Contact;
import com.ontarget.entities.Email;
import com.ontarget.entities.ForgotPasswordRequest;
import com.ontarget.entities.Phone;
import com.ontarget.entities.User;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserProfileInfo;
import com.ontarget.util.DateFormater;

@Repository("userJpaDAOImpl")
public class UserJpaDAOImpl implements UserDAO {
	@Resource
	private UserRepository userRepository;
	@Resource
	private ContactRepository contactRepository;
	@Resource
	private PhoneRepository phoneRepository;
	@Resource
	private EmailRepository emailRepository;
	@Resource
	private ForgotPasswordRequestRepository forgotPasswordRequestRepository;

	@Override
	public UserDTO insert(UserDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserDTO read(long id) {
		User user = userRepository.findByUserId((int) id);

		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setUsername(user.getUserName());
		return userDTO;
	}

	@Override
	public boolean update(UserDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserDTO getUser(Integer userId) throws Exception {
		User user = userRepository.findByUserId(userId);
		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUserName());
		userDTO.setUserId((int) userId);
		userDTO.setAccountStatus(user.getAccountStatus());
		userDTO.setUserStatus(String.valueOf(user.getUserStatus()));
		userDTO.setUserTypeId(user.getUserType().getUserTypeId());
		userDTO.setDiscipline(user.getDiscipline().getId());
		userDTO.setPassword(user.getPassword());
		userDTO.setSalt(user.getSalt());
		return userDTO;
	}

	@Override
	public int saveForgotPasswordRequest(int userId, String forgotPasswordToken) throws Exception {
		ForgotPasswordRequest forgotPasswordRequest = new ForgotPasswordRequest();
		forgotPasswordRequest.setUserId(userId);
		forgotPasswordRequest.setForgotPasswordToken(forgotPasswordToken);
		forgotPasswordRequest.setStatus(OnTargetConstant.FORGOT_PASSWORD.FORGOT_PASSWORD_ACTIVE);
		forgotPasswordRequest.setTsExpiry(DateFormater.addDays(new Date(), 1));
		forgotPasswordRequestRepository.save(forgotPasswordRequest);

		return forgotPasswordRequest.getId().intValue();
	}

	@Override
	public Map<String, Object> getForgotPasswordRequest(String forgotPasswordToken) throws Exception {
		ForgotPasswordRequest forgotPasswordRequest = forgotPasswordRequestRepository.findExpiredRequestByToken(forgotPasswordToken);
		if (forgotPasswordRequest != null) {
			Map<String, Object> forgotPwdMap = new HashMap<>();
			forgotPwdMap.put("user_id", (int) forgotPasswordRequest.getUserId());
			return forgotPwdMap;
		}
		return null;
	}

	@Override
	public int getForgotPasswordRequestCount(String forgotPasswordToken) throws Exception {
		long count = forgotPasswordRequestRepository.countExpiredRequestByToken(forgotPasswordToken);
		return (int) count;
	}

	@Override
	public boolean expireForgotPasswordRequest(String token) throws Exception {
		ForgotPasswordRequest forgotPasswordRequest = forgotPasswordRequestRepository.findExpiredRequestByToken(token);
		forgotPasswordRequest.setStatus(OnTargetConstant.FORGOT_PASSWORD.FORGOT_PASSWORD_EXPIRED);
		forgotPasswordRequestRepository.save(forgotPasswordRequest);
		return true;
	}

	@Override
	public boolean updateUserProfile(UpdateUserProfileRequest request) throws Exception {
		UserProfileInfo profile = request.getUserProfileInfo();

		User user = userRepository.findByUserId(profile.getUserId());

		List<com.ontarget.entities.Contact> contactList = user.getContactList();
		if (contactList == null || contactList.isEmpty()) {
			throw new Exception("User " + profile.getUserId() + " does not have contact");
		}
		Contact contact = contactList.get(0);
		contact.setFirstName(profile.getFirstName());
		contact.setLastName(profile.getLastName());
		contact.setTitle(profile.getTitle());
		contact.setContactImage(profile.getUserImagePath());
		contactRepository.save(contact);

		Phone phone = contact.getPhoneList().get(0);
		phone.setPhoneNumber(profile.getPhoneNumber());
		phone.setAreaCode(profile.getAreaCode());
		phoneRepository.save(phone);

		List<Email> emailList = user.getEmailList();
		if (emailList != null && !emailList.isEmpty()) {
			Email email = emailList.get(0);
			email.setEmailAddress(profile.getEmail());
			emailRepository.save(email);
		} else {
			Email email = new Email();
			email.setUser(user);
			email.setEmailAddress(profile.getEmail());
			email.setAddedDate(new Date());
			email.setStatus("ACTIVE");
			emailRepository.save(email);
		}

		return true;
	}

	@Override
	public boolean usernameAlreadyRegistered(String username) throws Exception {
		List<User> userList = userRepository.findUserByUsername(username);
		if (userList != null && !userList.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public User findUserByUsername(String username) throws Exception {
		List<User> userList = userRepository.findUserByUsername(username);
		if (userList != null && !userList.isEmpty()) {
			return userList.get(0);
		}
		return null;
	}

}
