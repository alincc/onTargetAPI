package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.PhoneDAO;
import com.ontarget.bean.ContactPhone;
import com.ontarget.constant.OnTargetQuery;


/**
 * Created by Owner on 12/9/14.
 */
@Repository("phoneDAOImpl")
public class PhoneDAOImpl implements PhoneDAO {

	private Logger logger = Logger.getLogger(PhoneDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int addContactPhone(int contactId, ContactPhone phone) throws Exception {
		logger.debug("Adding contact phone: " + phone);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.ADD_CONTACT_PHONE, new String[] { "id" });
				ps.setInt(1, contactId);
				ps.setInt(2, phone.getAreaCode());
				ps.setString(3, phone.getPhoneNumber());
				ps.setString(4, phone.getPhoneType());
				ps.setString(5, phone.getStatus());
				return ps;
			}
		}, keyHolder);
		logger.debug("Added phone with id: " + keyHolder.getKey().intValue());
		return keyHolder.getKey().intValue();
	}

}
