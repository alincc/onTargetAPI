package com.ontarget.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ontarget.dto.UserRegistrationRequest;

public class UserRegistrationRowMapper implements RowMapper<Object> {

	@Override
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRegistrationRequest registrationRequest = new UserRegistrationRequest();
		registrationRequest.setStatus(rs.getString("status"));
		registrationRequest.setTokenId(rs.getString("registration_token"));
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
