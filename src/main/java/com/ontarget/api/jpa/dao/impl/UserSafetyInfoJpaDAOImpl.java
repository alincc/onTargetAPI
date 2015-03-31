package com.ontarget.api.jpa.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.repository.UserSafetyInfoRepository;
import com.ontarget.constant.OnTargetQuery;

@Repository("userSafetyInfoJpaDAOImpl")
public class UserSafetyInfoJpaDAOImpl implements com.ontarget.api.dao.UserSafetyInfoDAO {

	@Resource
	private UserSafetyInfoRepository userSafetyInfoRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getRandomSafetyInfo(long disciplineId) {
		Map<String, Object> rs = jdbcTemplate.queryForMap(OnTargetQuery.GET_RANDOM_SAFETY_INFO, new Object[] { disciplineId });
		if (rs == null) {
			return null;
		}

		return (String) rs.get("name");
	}

}
