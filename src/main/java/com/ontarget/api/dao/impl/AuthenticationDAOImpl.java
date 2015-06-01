package com.ontarget.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.dto.RegistrationRequestDTO;
import com.ontarget.request.bean.RegistrationApprovalRequest;
import com.ontarget.request.bean.SignInRequest;
import com.ontarget.request.bean.UserRegistrationRequest;
import com.ontarget.util.Security;
import com.ontarget.util.TokenUtil;

/**
 * Created by Owner on 10/30/14.
 */
@Repository("authenticationDAOImpl")
public class AuthenticationDAOImpl implements AuthenticationDAO {

	private Logger logger = Logger.getLogger(AuthenticationDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception {

		int row = jdbcTemplate
				.update(OnTargetQuery.REGISTRATION_REQUEST,
						new Object[] { request.getProjectId(), request.getName(), request.getEmail(), request.getCompanyName(),
								request.getPhoneNumber(), request.getMsg(), OnTargetConstant.REGISTRATION_PENDING,
								request.getTokenId() });
		if (row == 0) {
			throw new Exception("Error while inserting registration request.");
		}

		return true;
	}

	@Override
	public boolean logout(String username) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.EXPIRE_TOKEN, new Object[] { username });
		if (row == 0) {
			throw new Exception("Error while logged out.");
		}
		return true;
	}

	@Override
	public UserRegistrationRequest getUserRegistrationRequestInfo(int userRequestId) throws Exception {
		return jdbcTemplate.queryForObject(OnTargetQuery.GET_USER_REQUEST_INFO, new Object[] { userRequestId },
				new BeanPropertyRowMapper<UserRegistrationRequest>(UserRegistrationRequest.class));
	}

	@Override
	public List<RegistrationRequestDTO> getUserRegistrationPendingRequests() throws Exception {

		List<RegistrationRequestDTO> userRegistrationRequests = new LinkedList<RegistrationRequestDTO>();
		jdbcTemplate.query(OnTargetQuery.GET_USER_REGISTRATION_PENDING_REQUEST, new Object[] {},
				new RowMapper<RegistrationRequestDTO>() {
					@Override
					public RegistrationRequestDTO mapRow(ResultSet resultSet, int i) throws SQLException {
						RegistrationRequestDTO registrationRequest = new RegistrationRequestDTO();
						registrationRequest.setStatus(resultSet.getString("status"));
						registrationRequest.setTokenId(resultSet.getString("registration_token"));
						registrationRequest.setPhoneNumber(resultSet.getString("phone_number"));
						registrationRequest.setCompanyName(resultSet.getString("company_name"));
						registrationRequest.setEmail(resultSet.getString("email"));
						registrationRequest.setId(resultSet.getInt("id"));
						registrationRequest.setMsg(resultSet.getString("msg"));
						registrationRequest.setName(resultSet.getString("name"));
						userRegistrationRequests.add(registrationRequest);
						return registrationRequest;
					}
				});

		return userRegistrationRequests;
	}

	@Override
	public boolean approvePendingRegistrationRequest(RegistrationApprovalRequest req) throws Exception {
		// approve the user request.

		boolean approved = this.approveUserRequest(req.getRequestId());
		if (!approved) {
			throw new Exception("User cannot be approved for request id: " + req.getRequestId());
		}

		boolean created = this.createUser(req);
		if (!created) {
			throw new Exception("User cannot be created for request id: " + req.getRequestId());
		}

		return true;
	}

	@Override
	public boolean approveUserRequest(int userRequestId) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.APPROVE_PENDING_USER_REQUEST, new Object[] {
				OnTargetConstant.REGSITRATION_REQUEST_APPROVED, userRequestId });
		if (row > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean createUser(RegistrationApprovalRequest request) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.CREATE_NEW_USER,
				new Object[] { request.getEmail(), 1, TokenUtil.getPasswordToken(), OnTargetConstant.USER_STATUS.PENDING, 1,
						OnTargetConstant.AccountStatus.ACCT_NEW });
		if (row > 0) {
			return true;
		}

		return false;
	}

	@Override
	public UserDTO getUserSignInInfo(SignInRequest signInRequest) throws Exception {
		logger.info("Authenticating user: " + signInRequest);

		final String password = signInRequest.getPassword();

		final UserDTO returnUser = new UserDTO();
		returnUser.setUsername(signInRequest.getUsername());
		jdbcTemplate.query(OnTargetQuery.USER_LOGIN, new Object[] { signInRequest.getUsername() }, new RowMapper<UserDTO>() {
			@Override
			public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {
				String salt = resultSet.getString("salt");
				String hashedPassword = Security.encodePassword(password, salt);

				if (hashedPassword.equals(resultSet.getString("password"))) {
					returnUser.setUserId(resultSet.getInt("user_id"));
					returnUser.setAccountStatus(resultSet.getString("account_status"));
					returnUser.setUserStatus(resultSet.getString("user_status"));
					returnUser.setUserTypeId(resultSet.getInt("user_type_id"));
					return returnUser;
				} else {
					return null;
				}
			}
		});
		return returnUser;

	}

	@Override
	public UserDTO getUserInfoByUsername(UserDTO user) throws Exception {
		logger.info("Authenticating user: " + user);

		final String password = user.getPassword();

		final UserDTO returnUser = new UserDTO();
		jdbcTemplate.query(OnTargetQuery.USER_LOGIN, new Object[] { user.getUsername() }, new RowMapper<UserDTO>() {
			@Override
			public UserDTO mapRow(ResultSet resultSet, int i) throws SQLException {
				returnUser.setUsername(user.getUsername());
				returnUser.setUserId(resultSet.getInt("user_id"));
				return null;
			}
		});
		return returnUser;

	}

	@Override
	public boolean changePassword(long userId, String password, String salt) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.CHANGE_USER_PASSWORD, new Object[] { password, salt, userId });
		return row > 0;
	}

	@Override
	public UserDTO getUserInfoById(long userId) throws Exception {
		Map<String, Object> userInfoMap = jdbcTemplate.queryForMap(OnTargetQuery.GET_USER_BY_ID, new Object[] { userId });
		UserDTO user = new UserDTO();
		user.setUsername((String) userInfoMap.get("user_name"));

		return user;
	}
}
