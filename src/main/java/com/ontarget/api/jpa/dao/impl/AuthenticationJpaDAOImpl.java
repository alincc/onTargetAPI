package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.repository.RegistrationRequestRepository;
import com.ontarget.api.repository.UserRepository;
import com.ontarget.api.repository.UserSessionInfoRepository;
import com.ontarget.bean.UserDTO;
import com.ontarget.bean.UserLoginInfo;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.RegistrationRequestDTO;
import com.ontarget.entities.Discipline;
import com.ontarget.entities.RegistrationRequest;
import com.ontarget.entities.User;
import com.ontarget.entities.UserType;
import com.ontarget.request.bean.RegistrationApprovalRequest;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;
import com.ontarget.util.Security;
import com.ontarget.util.TokenUtil;

@Repository("authenticationJpaDAOImpl")
public class AuthenticationJpaDAOImpl implements AuthenticationDAO {
	@Resource
	private UserRepository userRepository;
	@Resource
	private RegistrationRequestRepository registrationRequestRepository;
	@Resource
	private UserSessionInfoRepository userSessionInfoRepository;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserLoginInfo getUserSignInInfo(SignInRequest signInRequest) throws Exception {

		User user = userRepository.findByUserName(signInRequest.getUsername());
		if (user != null) {
			String salt = user.getSalt();
			String hashedPassword = Security.encodePassword(signInRequest.getPassword(), salt);

			if (hashedPassword.equals(user.getPassword())) {
				UserLoginInfo userDTO = new UserLoginInfo();
				// userDTO.setDiscipline(user.getDiscipline().getId());
				userDTO.setUserId(user.getUserId());
				// userDTO.setAccountStatus(user.getAccountStatus());
				// userDTO.setUserStatus(user.getUserStatus());
				// userDTO.setUserTypeId(user.getUserType().getUserTypeId());
				return userDTO;
			}

		}
		return null;
	}

	@Override
	public UserDTO getUserResponse(Integer userId) throws Exception {

		User user = userRepository.findByUserId(userId);
		if (user != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setDiscipline(user.getDiscipline().getId());
			userDTO.setUserId(user.getUserId());
			userDTO.setAccountStatus(user.getAccountStatus());
			userDTO.setUserStatus(user.getUserStatus());
			userDTO.setUserTypeId(user.getUserType().getUserTypeId());
			return userDTO;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception {
		RegistrationRequest registrationRequest = new RegistrationRequest();
		registrationRequest.setProjectId(request.getProjectId());
		registrationRequest.setEmail(request.getEmail());
		registrationRequest.setCompanyName(request.getCompanyName());
		registrationRequest.setPhoneNumber(request.getPhoneNumber());
		registrationRequest.setMsg(request.getMsg());
		registrationRequest.setStatus(OnTargetConstant.REGISTRATION_PENDING);
		registrationRequest.setRegistrationToken(request.getTokenId());
		registrationRequestRepository.save(registrationRequest);
		return true;
	}

	@Override
	public boolean logout(String username) throws Exception {
		userSessionInfoRepository.updateUserSession("1", username);
		return true;
	}

	@Override
	public UserRegistrationRequest getUserRegistrationRequestInfo(int userRequestId) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<RegistrationRequestDTO> getUserRegistrationPendingRequests() throws Exception {
		List<RegistrationRequest> registrationRequests = registrationRequestRepository.findByStatus("PENDING");
		List<RegistrationRequestDTO> userRegistrationRequests = new LinkedList<RegistrationRequestDTO>();

		if (!registrationRequests.isEmpty()) {
			for (RegistrationRequest registrationRequest : registrationRequests) {
				RegistrationRequestDTO registrationRequestDTO = new RegistrationRequestDTO();
				registrationRequestDTO.setStatus(registrationRequest.getStatus());
				registrationRequestDTO.setTokenId(registrationRequest.getRegistrationToken());
				registrationRequestDTO.setPhoneNumber(registrationRequest.getPhoneNumber());
				registrationRequestDTO.setCompanyName(registrationRequest.getCompanyName());
				registrationRequestDTO.setEmail(registrationRequest.getEmail());
				registrationRequestDTO.setId(registrationRequest.getId().intValue());
				registrationRequestDTO.setMsg(registrationRequest.getMsg());
				userRegistrationRequests.add(registrationRequestDTO);
			}
		}
		return userRegistrationRequests;
	}

	@Override
	public boolean approvePendingRegistrationRequest(RegistrationApprovalRequest req) throws Exception {
		RegistrationRequest registrationRequest = registrationRequestRepository.findOne((long) req.getRequestId());
		registrationRequest.setStatus(OnTargetConstant.REGSITRATION_REQUEST_APPROVED);
		registrationRequestRepository.save(registrationRequest);

		User user = new User();
		user.setUserName(req.getEmail());
		user.setUserType(new UserType(1));
		user.setPassword(TokenUtil.getPasswordToken());
		user.setSalt("");
		user.setDiscipline(new Discipline(1l));
		user.setUserStatus(OnTargetConstant.USER_STATUS.PENDING);
		user.setNumberOfLogin(1);
		user.setModifiedDate(new Date());
		user.setAccountStatus(OnTargetConstant.AccountStatus.ACCT_NEW);
		userRepository.save(user);

		return true;
	}

	@Override
	public boolean approveUserRequest(int userRequestId) throws Exception {
		RegistrationRequest registrationRequest = registrationRequestRepository.findOne((long) userRequestId);
		registrationRequest.setStatus(OnTargetConstant.REGSITRATION_REQUEST_APPROVED);
		registrationRequestRepository.save(registrationRequest);

		return true;
	}

	@Override
	public boolean createUser(RegistrationApprovalRequest request) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Override
	public UserDTO getUserInfoByUsername(UserDTO user) throws Exception {
		UserDTO returnUser = new UserDTO();

		User userObj = userRepository.findUserLogin(user.getUsername());
		if (userObj != null) {
			returnUser.setUsername(userObj.getUserName());
			returnUser.setUserId(userObj.getUserId());
		}
		return returnUser;
	}

	@Override
	public boolean changePassword(long userId, String password, String salt) throws Exception {
		User user = userRepository.findOne((int) userId);
		user.setPassword(password);
		user.setSalt(salt);
		userRepository.save(user);
		return true;
	}

	@Override
	public UserDTO getUserInfoById(long userId) throws Exception {
		User user = userRepository.findOne((int) userId);

		UserDTO userDTO = new UserDTO();
		userDTO.setUsername(user.getUserName());
		return userDTO;
	}

}
