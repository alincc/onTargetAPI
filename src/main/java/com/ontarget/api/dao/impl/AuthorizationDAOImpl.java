package com.ontarget.api.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.AuthorizationDAO;

@Repository("authorizationDAOimpl")
public class AuthorizationDAOImpl implements AuthorizationDAO {
	private Logger logger = Logger.getLogger(AuthorizationDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean validateUserOnProject(Integer userId, Integer projectId) throws Exception {
		String sql = "SELECT COUNT(1)" + " FROM project p JOIN project_member pm ON(p.project_id=" + projectId
				+ " AND pm.user_id=" + userId + " AND p.project_id=pm.project_id AND p.project_parent_id=0)";

		int count = this.jdbcTemplate.queryForInt(sql);
		if (count > 0) {
			return true;
		}
		return false;

	}

}
