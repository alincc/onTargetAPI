package com.ontarget.constant;

/**
 * Created by Owner on 10/30/14.
 */
public interface OnTargetQuery {

    public static final String REGISTRATION_REQUEST=new StringBuilder("INSERT INTO REGISTRATION_REQUEST (NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER, MSG,STATUS) VALUES (?,?,?,?,?,?)").toString();

    public static final  String USER_LOGIN=new StringBuilder("SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=? AND ACCOUNT_STATUS='ACTIVE' AND USER_STATUS=1").toString();

    public static final String EXPIRE_TOKEN = new StringBuilder("UPDATE USER_SESSION_INFO SET EXPIRE_DATE=NOW() WHERE USER_ID=(SELECT USER_ID FROM USER WHERE USER_NAME=?)").toString();
}
