package com.ontarget.api.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ontarget.api.dao.GenericDAO;

public abstract class BaseGenericDAOImpl<T> implements GenericDAO<T> {
	
	private static final Logger logger = Logger.getLogger(BaseGenericDAOImpl.class);

	@Autowired
    protected JdbcTemplate jdbcTemplate;
}
