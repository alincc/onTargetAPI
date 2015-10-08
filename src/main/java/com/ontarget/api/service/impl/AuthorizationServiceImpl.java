package com.ontarget.api.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.AuthorizationDAO;
import com.ontarget.api.service.AuthorizationService;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	private Logger logger = Logger.getLogger(AuthorizationServiceImpl.class);

	@Autowired
	@Qualifier("authorizationJpaDAOImpl")
	private AuthorizationDAO authorizationDAO;

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public boolean validateUserOnProject(Integer userId, Integer projectId) throws Exception {
        logger.debug("Validating user:: "+ userId+" with project: "+projectId);
		return authorizationDAO.validateUserOnProject(userId, projectId);
	}

}
