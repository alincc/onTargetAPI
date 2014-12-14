package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.StateDAO;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by Yam on 10-12-2014.
 */
@Repository
public class StateDAOImpl implements StateDAO {

    private Logger logger = Logger.getLogger(StateDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Set<Long> getStatesByCountry(long countryId) throws Exception {
       List<Long> states=jdbcTemplate.queryForList(OnTargetQuery.GET_STATES_BY_COUNTRY,Long.class,new Object[]{countryId});
       return new HashSet<Long>(states);
    }
}
