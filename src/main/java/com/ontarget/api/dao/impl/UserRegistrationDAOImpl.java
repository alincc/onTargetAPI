package com.ontarget.api.dao.impl;

import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by sumit on 11/26/14.
 */
@Repository
public class UserRegistrationDAOImpl implements com.ontarget.api.dao.UserRegistrationDAO {

    private Logger logger = Logger.getLogger(UserRegistrationDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveRegistrationInvitation(long projectId, String firstName, String lastName, String email, String tokenId) throws Exception {
        jdbcTemplate.update(OnTargetQuery.ADD_REGISTRATION_INVITATION, new Object[]{tokenId, firstName, lastName, email, projectId});
        return 1;
    }


}
