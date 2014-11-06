package com.ontarget.dto;

import com.ontarget.bean.User;

/**
 * Created by Owner on 10/29/14.
 */
public class UserResponse extends OnTargetResponse {

    private User user;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
