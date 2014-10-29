package com.ontarget.api.rs;

import com.ontarget.bean.User;

/**
 * Created by Owner on 10/26/14.
 */
public interface Authentication {

    public com.ontarget.api.response.UserResponse signIn(User user);

}