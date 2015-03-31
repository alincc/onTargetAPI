package com.ontarget.api.jpa.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.AuthorizationDAO;
import com.ontarget.api.repository.ProjectRepository;

@Repository("authorizationJpaDAOImpl")
public class AuthorizationJpaDAOImpl implements AuthorizationDAO {
	@Resource
	private ProjectRepository projectRepository;

	@Override
	public boolean validateUserOnProject(Integer userId, Integer projectId) throws Exception {
		long count = projectRepository.countUserInvolvementInProject(userId, projectId);
		if (count > 0) {
			return true;
		}
		return false;

	}

}
