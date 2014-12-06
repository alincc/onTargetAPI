package com.ontarget.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UserDAO;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class UserDAOImpl extends BaseGenericDAOImpl<User> implements UserDAO {

	@Override
	public User insert(User bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User read(long userId) {
		User user = jdbcTemplate.queryForObject(OnTargetQuery.GET_USER_BY_ID, 
				new Object[] { (int) userId }, 
				new RowMapper<User>() {
					@Override
					public User mapRow(ResultSet rs, int index)
							throws SQLException {
						User user = new User();
						user.setUserId(rs.getInt("user_id"));
						user.setUsername(rs.getString("user_name"));
						return user;
					}
		});
		return user;
	}

	@Override
	public boolean update(User bean) {
		// TODO Auto-generated method stub
		return false;
	}

}