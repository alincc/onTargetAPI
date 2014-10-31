package com.ontarget.api.dao;

import com.ontarget.bean.UserRegistrationRequest;
import org.springframework.stereotype.Repository;

/**
 * Created by Owner on 10/30/14.
 */
public interface AuthenticationDAO {
    public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception;

    public boolean logout(String username) throws  Exception;
}
