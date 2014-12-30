package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.UserDAO;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl extends BaseGenericDAOImpl<User> implements UserDAO {
    private Logger logger = Logger.getLogger(UserDAOImpl.class);
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

    @Override
    public User getUser(long userId) throws Exception {
        Map<String, Object> rs = jdbcTemplate.queryForMap(OnTargetQuery.GET_USER, new Object[]{userId});
        User user = new User();
        user.setUsername((String) rs.get("user_name"));
        user.setUserId((int) userId);
        user.setAccountStatus((String) rs.get("account_status"));
        user.setUserStatus((String) rs.get("user_status"));
        user.setUserTypeId((int) rs.get("user_type_id"));
        user.setDiscipline((long) rs.get("discipline"));
        user.setPassword((String) rs.get("password"));
        user.setSalt((String) rs.get("salt"));

        return user;
    }

    @Override
    public int saveForgotPasswordRequest(int userId, String forgotPasswordToken) throws Exception{
        logger.debug("saving fort password request for userId:" + userId);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_FORGOT_PASSWORD_REQUEST, new String[]{"id"});
                        ps.setInt(1, userId);
                        ps.setString(2, forgotPasswordToken);
                        ps.setString(3, OnTargetConstant.FORGOT_PASSWORD.FORGOT_PASSWORD_ACTIVE);
                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added forgot password request with id: " + keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }

    @Override
    public Map<String, Object> getForgotPasswordRequest(String forgotPasswordToken) throws Exception {
        return jdbcTemplate.queryForObject(OnTargetQuery.GET_FORGOT_PASSWORD_REQUEST, new Object[]{forgotPasswordToken}, new RowMapper<Map<String, Object>>() {
            @Override
            public Map<String, Object> mapRow(ResultSet rs, int index)
                    throws SQLException {
                Map<String, Object> forgotPwdMap = new HashMap<>();
                forgotPwdMap.put("user_id", rs.getInt("user_id"));
                return forgotPwdMap;
            }
        });
    }


    @Override
    public int getForgotPasswordRequestCount(String forgotPasswordToken) throws Exception {
        return  jdbcTemplate.queryForObject(OnTargetQuery.GET_FORGOT_PASSWORD_REQUEST_COUNT, new Object[]{forgotPasswordToken},Integer.class);
    }
}
