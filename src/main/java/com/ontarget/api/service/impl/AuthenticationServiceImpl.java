package com.ontarget.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.UserSessionDAO;
import com.ontarget.api.service.AuthenticationService;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.RegistrationRequestDTO;
import com.ontarget.dto.UserRegistationApprovalResponse;
import com.ontarget.dto.UserResponse;
import com.ontarget.request.bean.RegistrationApprovalRequest;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;
import com.ontarget.util.TokenUtil;

/**
 * Created by Owner on 10/30/14.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	private Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);

	@Autowired
	@Qualifier("authenticationJpaDAOImpl")
	private AuthenticationDAO authenticationDAO;

	@Autowired
	@Qualifier("authenticationDAOImpl")
	private AuthenticationDAO authenticationJdbcDAO;

	@Autowired
	@Qualifier("userSessionJpaDAOImpl")
	private UserSessionDAO userSessionDAO;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public UserResponse signIn(SignInRequest signInRequest) throws Exception {
		UserResponse response = new UserResponse();
		UserDTO returnUser = authenticationDAO.getUserSignInInfo(signInRequest);
		if (returnUser == null) {
			response.setReturnMessage(OnTargetConstant.AUTHENTICATION_FAILED);
			response.setAuthenticated(false);
			response.setReturnVal(OnTargetConstant.ERROR);
			return response;
		}

		String token = TokenUtil.getLoginToken(signInRequest.getUsername());
		boolean saved = userSessionDAO.saveUserSessionToken(returnUser.getUserId(), token);
		if (!saved) {
			throw new Exception("User session token failed");
		}

		String accountStatus = returnUser.getAccountStatus();
		logger.debug("Account status: " + accountStatus);

		if (!accountStatus.equals(OnTargetConstant.AccountStatus.ACCT_NEW)
				&& !accountStatus.equals(OnTargetConstant.AccountStatus.ACCOUNT_INVITATION)) {
			returnUser.setContact(contactDAO.getContact(returnUser.getUserId()));
		}

		response.setUser(returnUser);
		response.setToken(token);
		response.setReturnMessage(OnTargetConstant.RETURN_MESSAGE_AUTHENTICATION);
		response.setReturnVal(OnTargetConstant.SUCCESS);
		response.setAuthenticated(true);
		return response;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean registrationRequest(UserRegistrationRequest request) throws Exception {
		return authenticationDAO.saveRegistrationRequest(request);
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean logout(String username) throws Exception {
		return authenticationDAO.logout(username);
	}

	@Override
	public UserRegistationApprovalResponse getUserRegistrationPendingRequests() throws Exception {
		List<RegistrationRequestDTO> pendingRequestsList = authenticationDAO.getUserRegistrationPendingRequests();
		UserRegistationApprovalResponse response = new UserRegistationApprovalResponse();
		response.setUserRegistrationRequestList(pendingRequestsList);
		return response;

	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean approvePendingRegistrationRequest(RegistrationApprovalRequest request) throws Exception {
		return authenticationDAO.approvePendingRegistrationRequest(request);
	}

}
