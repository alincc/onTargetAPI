package com.ontarget.api.dao;

public interface AuthorizationDAO {
	
	public boolean validateUserOnProject(Integer userId, Integer projectId) throws Exception;

}
