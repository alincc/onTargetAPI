package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.CountryDAO;
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
public class CountryDAOImpl implements CountryDAO {

    private Logger logger = Logger.getLogger(CountryDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Set<Long> getCountryList() throws Exception {
        List<Long> countries=jdbcTemplate.queryForList(OnTargetQuery.GET_COUNTRY_LIST,Long.class,new Object[]{});
        return new HashSet<Long>(countries);
    }
}
