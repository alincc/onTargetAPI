package com.ontarget.api.dao.impl;

import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Map;

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

    @Override
    public UserRegistration getInvitationRegistration(String tokenId) throws Exception {
        Map<String, Object> rs = jdbcTemplate.queryForMap(OnTargetQuery.GET_REGISTRATION_INVITATION, new Object[]{tokenId});
        UserRegistration userRegistration = new UserRegistration();
        Object d = null;
        userRegistration.setFirstName((String) rs.get("first_name"));
        userRegistration.setLastName((String) rs.get("last_name"));
        userRegistration.setEmail((String) rs.get("email"));
        userRegistration.setRegistrationToken(tokenId);
        d = rs.get("project_id");
        if (d != null) {
            if (d instanceof Long)
                userRegistration.setProjectId((Long) d);
            else if (d instanceof Integer) {
                userRegistration.setProjectId((Integer) d);
            } else
                userRegistration.setProjectId(Long.parseLong((String) d));
        }
        d = rs.get("ts_create");
        if (d != null) {
            userRegistration.setTsCreate(((Timestamp) d).getTime());
        }

        return userRegistration;
    }
}
