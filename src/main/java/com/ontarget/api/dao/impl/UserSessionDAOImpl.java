package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.UserSessionDAO;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Owner on 11/16/14.
 */
@Repository
public class UserSessionDAOImpl implements UserSessionDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public boolean saveUserSessionToken(int userId, String token) throws Exception{

        int row = jdbcTemplate.update(OnTargetQuery.SAVE_USER_SESSION_INFO, new Object[]{userId,token});

        if(row < 0){
            throw new Exception("Could not save user session info");
        }

        return true;
    }
}
