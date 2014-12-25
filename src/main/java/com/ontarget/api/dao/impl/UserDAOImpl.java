package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.UserDAO;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        return jdbcTemplate.queryForObject(OnTargetQuery.GET_USER_BY_ID,
                new Object[]{(int) userId},
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
}
