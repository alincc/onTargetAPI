package com.ontarget.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.EmailDAO;
import com.ontarget.bean.Email;
import com.ontarget.constant.OnTargetQuery;

@Repository("emailDAOImpl")
public class EmailDAOImpl extends BaseGenericDAOImpl<Email> implements EmailDAO {

	@Override
	public Email insert(Email bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Email read(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Email bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Email getByContactId(int contactId) {
		Email email = jdbcTemplate.queryForObject(OnTargetQuery.GET_EMAIL_BY_CONTACT_ID, new Object[] { contactId },
				new RowMapper<Email>() {

					@Override
					public Email mapRow(ResultSet rs, int index) throws SQLException {
						Email email = new Email();
						email.setEmailId(rs.getInt("email_id"));
						email.setEmailAddress(rs.getString("email_address"));
						return email;
					}

				});
		return email;
	}

}
