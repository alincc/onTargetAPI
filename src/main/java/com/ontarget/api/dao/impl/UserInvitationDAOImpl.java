package com.ontarget.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.dto.UserRegistrationRequest;

/**
 * Created by Santosh
 */
@Repository
public class UserInvitationDAOImpl implements UserInvitationDAO {

	private Logger logger = Logger.getLogger(UserInvitationDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveRegistrationRequest(UserRegistrationRequest request)
			throws Exception {

		int row = jdbcTemplate.update(
				OnTargetQuery.NEW_REGISTRATION_REQUEST,
				new Object[] { request.getFirstName(), request.getLastName(),
						request.getEmail(), request.getPhoneNumber(),
						request.getMsg(),
						OnTargetConstant.REGISTRATION_PENDING,
						request.getTokenId() });
		System.out.println("Inserted in registration request:: " + row);
		if (row == 0) {
			throw new Exception("Error while inserting registration request.");
		}

		return true;
	}

	@Override
	public List<UserRegistrationRequest> fetchPendingRequests()
			throws Exception {
		final List<UserRegistrationRequest> userRegistrationRequests = new LinkedList<UserRegistrationRequest>();
		jdbcTemplate.query(OnTargetQuery.PENDING_REGISTRATION_REQUEST_LIST,
				new Object[] {}, new RowMapper<UserRegistrationRequest>() {
					@Override
					public UserRegistrationRequest mapRow(ResultSet resultSet,
							int i) throws SQLException {
						UserRegistrationRequest registrationRequest = new UserRegistrationRequest();
						registrationRequest.setStatus(resultSet
								.getString("status"));
						registrationRequest.setTokenId(resultSet
								.getString("registration_token"));
						registrationRequest.setPhoneNumber(resultSet
								.getString("phone_number"));
						registrationRequest.setEmail(resultSet
								.getString("email"));
						registrationRequest.setId(resultSet.getInt("id"));
						registrationRequest.setMsg(resultSet.getString("msg"));
						registrationRequest.setFirstName(resultSet
								.getString("first_name"));
						registrationRequest.setLastName(resultSet
								.getString("last_name"));
						userRegistrationRequests.add(registrationRequest);
						return registrationRequest;
					}
				});

		return userRegistrationRequests;
	}

	@Override
	public boolean approvePendingRequest(int regRequestId) throws Exception {
		int row = jdbcTemplate.update(
				OnTargetQuery.APPROVE_PENDING_USER_REQUEST,
				new Object[] { OnTargetConstant.REGISTRATION_REQUEST_NEW,
						regRequestId });
		if (row > 0) {
			return true;
		}

		return false;
	}

	@Override
	public UserRegistrationRequest findRegRequestById(int id) throws Exception {
		return jdbcTemplate.queryForObject(
				OnTargetQuery.GET_REGISTRATION_REQUEST, new Object[] { id },
				new RowMapper<UserRegistrationRequest>() {
					@Override
					public UserRegistrationRequest mapRow(ResultSet rs,
							int index) throws SQLException {
						UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
						userRegistrationRequest.setId(rs.getInt("id"));
						userRegistrationRequest.setStatus(rs
								.getString("status"));
						userRegistrationRequest.setTokenId(rs
								.getString("registration_token"));
						userRegistrationRequest.setPhoneNumber(rs
								.getString("phone_number"));
						userRegistrationRequest.setEmail(rs.getString("email"));
						userRegistrationRequest.setMsg(rs.getString("msg"));
						userRegistrationRequest.setFirstName(rs
								.getString("first_name"));
						userRegistrationRequest.setLastName(rs
								.getString("last_name"));
						return userRegistrationRequest;

					}
				});
	}

	@Override
	public UserRegistrationRequest findRequestByToken(String token)
			throws Exception {
		String sql = "SELECT * FROM REGISTRATION_REQUEST WHERE registration_token = ?";

		return jdbcTemplate.queryForObject(sql, new Object[] { token },
				new RowMapper<UserRegistrationRequest>() {
					@Override
					public UserRegistrationRequest mapRow(ResultSet rs,
							int index) throws SQLException {
						UserRegistrationRequest userRegistrationRequest = new UserRegistrationRequest();
						userRegistrationRequest.setId(rs.getInt("id"));
						userRegistrationRequest.setStatus(rs.getString("status"));
						logger.info("Status dao::" +userRegistrationRequest.getStatus());
						return userRegistrationRequest;

					}
				});
	}

}