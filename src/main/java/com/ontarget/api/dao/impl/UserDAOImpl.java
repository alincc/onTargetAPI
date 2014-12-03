package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.UserDAO;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by sumit on 12/2/14.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(long userId) throws Exception {
        Map<String, Object> rs = jdbcTemplate.queryForMap(OnTargetQuery.GET_USER, new Object[]{userId});
        User user = new User();
        Object d = null;
        user.setUsername((String) rs.get(""));
        user.setUserId((int) userId);
        user.setAccountStatus((String) rs.get("account_status"));
        user.setUserStatus((String) rs.get("user_status"));
        user.setUserTypeId((int) rs.get("user_type_id"));
        user.setDiscipline((long) rs.get("discipline"));

        return user;
    }
}
