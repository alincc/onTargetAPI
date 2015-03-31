package com.ontarget.api.jpa.dao.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UserSessionDAO;
import com.ontarget.api.repository.UserSessionRepository;
import com.ontarget.entities.User;
import com.ontarget.entities.UserSessionInfo;
import com.ontarget.util.DateFormater;

@Repository("userSessionJpaDAOImpl")
public class UserSessionJpaDAOImpl implements UserSessionDAO {
	@Resource
	private UserSessionRepository userSessionRepository;

	@Override
	public boolean saveUserSessionToken(int userId, String token) throws Exception {

		UserSessionInfo userSessionInfo = new UserSessionInfo();
		userSessionInfo.setCreatedDate(new Date());
		userSessionInfo.setUser(new User(userId));
		userSessionInfo.setLoginToken(token);
		userSessionInfo.setIsExpired("0");
		userSessionInfo.setExpireDate(DateFormater.convertToDate("9999-12-31"));
		userSessionRepository.save(userSessionInfo);
		return true;
	}

}
