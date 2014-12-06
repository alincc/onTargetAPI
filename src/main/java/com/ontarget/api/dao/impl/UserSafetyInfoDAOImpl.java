package com.ontarget.api.dao.impl;

import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by sumit on 12/3/14.
 */
@Repository
public class UserSafetyInfoDAOImpl implements com.ontarget.api.dao.UserSafetyInfoDAO {
    private Logger logger = Logger.getLogger(UserSafetyInfoDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getRandomSafetyInfo(long disciplineId) {
        Map<String, Object> rs = jdbcTemplate.queryForMap(OnTargetQuery.GET_RANDOM_SAFETY_INFO, new Object[]{disciplineId});
        if (rs == null) {
            return null;
        }

        return (String) rs.get("name");
    }
}
