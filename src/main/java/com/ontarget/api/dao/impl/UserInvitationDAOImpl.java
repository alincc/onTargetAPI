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
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;

/**
 * Created by Santosh
 */
@Repository
public class UserInvitationDAOImpl implements UserInvitationDAO {

	private Logger logger = Logger.getLogger(UserInvitationDAO.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean saveRegistrationRequest(UserInvitationRequestDTO userInvitationRequestDTO) throws Exception {

		int row = jdbcTemplate.update(
				OnTargetQuery.NEW_REGISTRATION_REQUEST,
				new Object[] { userInvitationRequestDTO.getFirstName(), userInvitationRequestDTO.getLastName(),
						userInvitationRequestDTO.getEmail(), userInvitationRequestDTO.getPhoneNumber(),
						userInvitationRequestDTO.getMsg(), OnTargetConstant.REGISTRATION_PENDING,
						userInvitationRequestDTO.getToken() });
		if (row == 0) {
			throw new Exception("Error while inserting registration request.");
		}
		return true;
	}

	@Override
	public List<RegistrationRequestResponseDTO> fetchPendingRequests() throws Exception {
		final List<RegistrationRequestResponseDTO> userRegistrationRequests = new LinkedList<RegistrationRequestResponseDTO>();
		jdbcTemplate.query(OnTargetQuery.PENDING_REGISTRATION_REQUEST_LIST, new Object[] {},
				new RowMapper<RegistrationRequestResponseDTO>() {
					@Override
					public RegistrationRequestResponseDTO mapRow(ResultSet resultSet, int i) throws SQLException {
						RegistrationRequestResponseDTO registrationRequest = new RegistrationRequestResponseDTO();
						registrationRequest.setStatus(resultSet.getString("status"));
						registrationRequest.setRegistrationToken(resultSet.getString("registration_token"));
						registrationRequest.setPhoneNumber(resultSet.getString("phone_number"));
						registrationRequest.setEmail(resultSet.getString("email"));
						registrationRequest.setId(resultSet.getInt("id"));
						registrationRequest.setMsg(resultSet.getString("msg"));
						registrationRequest.setFirstName(resultSet.getString("first_name"));
						registrationRequest.setLastName(resultSet.getString("last_name"));
						userRegistrationRequests.add(registrationRequest);
						return registrationRequest;
					}
				});

		return userRegistrationRequests;
	}

	@Override
	public boolean approvePendingRequest(int regRequestId) throws Exception {
		int row = jdbcTemplate.update(OnTargetQuery.APPROVE_PENDING_USER_REQUEST, new Object[] {
				OnTargetConstant.REGISTRATION_REQUEST_NEW, regRequestId });
		if (row > 0) {
			return true;
		}

		return false;
	}

	@Override
	public RegistrationRequestResponseDTO findRegRequestById(int id) throws Exception {
		RegistrationRequestResponseDTO registrationRequest = (RegistrationRequestResponseDTO) jdbcTemplate.queryForObject(
				OnTargetQuery.GET_REGISTRATION_REQUEST, new Object[] { id }, new UserRegistrationRowMapper());
		return registrationRequest;
	}

	@Override
	public RegistrationRequestResponseDTO findRequestByToken(String token) throws Exception {
		String sql = "SELECT * FROM REGISTRATION_REQUEST WHERE registration_token = ?";

		RegistrationRequestResponseDTO registrationRequest = (RegistrationRequestResponseDTO) jdbcTemplate.queryForObject(sql,
				new Object[] { token }, new UserRegistrationRowMapper());
		return registrationRequest;
	}

	public RegistrationRequestResponseDTO findRegRequestByEmail(String email) throws Exception {
		try {
			RegistrationRequestResponseDTO registrationRequest = (RegistrationRequestResponseDTO) jdbcTemplate.queryForObject(
					OnTargetQuery.GET_REGISTRATION_REQUEST_BY_EMAIL, new Object[] { email }, new UserRegistrationRowMapper());
			return registrationRequest;
		} catch (Exception e) {
			logger.error("Exception::" + e);
			return null;
		}

	}

	class UserRegistrationRowMapper implements RowMapper<Object> {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			RegistrationRequestResponseDTO registrationRequest = new RegistrationRequestResponseDTO();
			registrationRequest.setStatus(rs.getString("status"));
			registrationRequest.setRegistrationToken(rs.getString("registration_token"));
			registrationRequest.setPhoneNumber(rs.getString("phone_number"));
			registrationRequest.setEmail(rs.getString("email"));
			registrationRequest.setId(rs.getInt("id"));
			registrationRequest.setMsg(rs.getString("msg"));
			registrationRequest.setFirstName(rs.getString("first_name"));
			registrationRequest.setLastName(rs.getString("last_name"));
			registrationRequest.setTsCreate(rs.getTimestamp("ts_create").getTime());
			return registrationRequest;
		}
	}

}