package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entities.User;
import com.ontarget.entities.UserProfile;
import com.ontarget.request.bean.UserRegistrationInfo;
import com.ontarget.request.bean.UserSignupRequest;
import com.ontarget.util.Security;

/**
 * Created by sumit on 11/26/14.
 */
@Repository("userRegistrationDAOImpl")
public class UserRegistrationDAOImpl implements com.ontarget.api.dao.UserRegistrationDAO {

	private Logger logger = Logger.getLogger(UserRegistrationDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserRegistration getInvitationRegistration(String tokenId) throws Exception {
		Map<String, Object> rs = jdbcTemplate.queryForMap(OnTargetQuery.GET_REGISTRATION_INVITATION, new Object[] { tokenId });
		UserRegistration userRegistration = new UserRegistration();
		Object d = null;
		userRegistration.setFirstName((String) rs.get("first_name"));
		userRegistration.setLastName((String) rs.get("last_name"));
		userRegistration.setEmail((String) rs.get("email"));
		userRegistration.setStatus((String) rs.get("status"));
		userRegistration.setRegistrationToken(tokenId);
		d = rs.get("project_id");
		if (d != null) {
			if (d instanceof Long)
				userRegistration.setProjectId((Long) d);
			else if (d instanceof Integer) {
				userRegistration.setProjectId((Integer) d);
			} else
				userRegistration.setProjectId(Long.parseLong((String) d));
		}
		d = rs.get("ts_create");
		if (d != null) {
			userRegistration.setTsCreate(((Timestamp) d).getTime());
		}

		return userRegistration;
	}

	@Override
	public User createNewuser(UserSignupRequest registration, String status) throws Exception {
		logger.info("creating new user based on : " + registration);
		String password = registration.getPassword();
		String salt = Security.generateSecureSalt();
		String hashedPassword = Security.encodePassword(password, salt);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.CREATE_NEW_USER, new String[] { "user_id" });
				ps.setString(1, registration.getEmail());
				ps.setInt(2, 1);
				ps.setString(3, hashedPassword);
				ps.setString(4, salt);
				ps.setInt(5, registration.getDiscipline());
				ps.setInt(6, OnTargetConstant.USER_STATUS.ACTIVE);
				ps.setInt(7, 1);
				ps.setString(8, status);
				// ps.setInt(9, userId);
				return ps;
			}
		}, keyHolder);
		return null;
	}

	@Override
	public int updateRegistrationRequestUserId(int userId, String tokenId) throws Exception {
		logger.debug("updating user with userId: " + userId + "and token: " + tokenId);
		return jdbcTemplate.update(OnTargetQuery.UPDATE_REGISRATION_USER_ID, new Object[] { userId, tokenId });
	}

	@Override
	public int activateAccount(int userId) throws Exception {
		logger.debug("activating account for token: " + userId);
		return jdbcTemplate.update(OnTargetQuery.ACTIVATE_USER_ACCOUNT, new Object[] { userId });
	}

	@Override
	public UserRegistration getInvitationRegistrationByUser(int userId) throws Exception {
		Map<String, Object> rs = jdbcTemplate.queryForMap(OnTargetQuery.GET_REGISTRATION_INVITATION_BY_USER, new Object[] { userId });
		UserRegistration userRegistration = new UserRegistration();
		Object d = null;
		userRegistration.setFirstName((String) rs.get("first_name"));
		userRegistration.setLastName((String) rs.get("last_name"));
		userRegistration.setEmail((String) rs.get("email"));
		userRegistration.setStatus((String) rs.get("status"));
		d = rs.get("project_id");
		if (d != null) {
			if (d instanceof Long)
				userRegistration.setProjectId((Long) d);
			else if (d instanceof Integer) {
				userRegistration.setProjectId((Integer) d);
			} else
				userRegistration.setProjectId(Long.parseLong((String) d));
		}
		d = rs.get("ts_create");
		if (d != null) {
			userRegistration.setTsCreate(((Timestamp) d).getTime());
		}

		return userRegistration;
	}

	@Override
	public boolean saveRegistrationInvitation(UserInvitationRequestDTO userInvitationRequestDTO) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int updateRegistrationRequestCompanyId(int companyId, String tokenId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserProfile assignProfilesToUser(String userType, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
