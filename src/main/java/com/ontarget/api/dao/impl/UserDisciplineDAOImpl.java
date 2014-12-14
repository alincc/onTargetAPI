package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.UserDisciplineDAO;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Yam on 13-12-2014.
 */
@Repository
public class UserDisciplineDAOImpl implements UserDisciplineDAO{

    private Logger logger = Logger.getLogger(UserDisciplineDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Set<Long> getDisciplineByUser(long userId) throws Exception {
        List<Long> discipline = jdbcTemplate.queryForList(OnTargetQuery.GET_DISCIPLINE_BY_USER, Long.class, new Object[]{userId});
        return new HashSet<Long>(discipline);
    }
}
