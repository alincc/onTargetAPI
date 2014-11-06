package com.ontarget.api.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Owner on 10/14/14.
 */
@Repository
public class HelloDao {

    public String getHello() {
        return "Hi there, This is OnTarget - Construction Management Tool.";

    }
}
