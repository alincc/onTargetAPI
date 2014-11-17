package com.ontarget.api.dao;

/**
 * Created by Owner on 11/16/14.
 */
public interface UserSessionDAO {

    public boolean saveUserSessionToken(int userId, String token) throws Exception;
}
