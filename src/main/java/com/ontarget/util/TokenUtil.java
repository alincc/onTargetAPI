package com.ontarget.util;


import java.util.UUID;

/**
 * Created by Owner on 11/16/14.
 */
public class TokenUtil {


    /**
     * Return token login based on username and created timestamp
     *
     * @return
     */
    public static String getLoginToken(String username) {
        return String.valueOf(UUID.randomUUID());
    }

    public static String getPasswordToken() {
        return String.valueOf(UUID.randomUUID());
    }
}
