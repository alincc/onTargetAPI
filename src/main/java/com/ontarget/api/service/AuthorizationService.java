package com.ontarget.api.service;

public interface AuthorizationService {

	public boolean validateUserOnProject(Integer userId, Integer projectId) throws Exception;

}
