package com.ontarget.constant;

/**
 * Created by Owner on 10/30/14.
 */
public interface OnTargetQuery {

    public static final String REGISTRATION_REQUEST=new StringBuilder("INSERT INTO REGISTRATION_REQUEST (NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER, MSG,STATUS) VALUES (?,?,?,?,?,?)").toString();

    public static final  String USER_LOGIN=new StringBuilder("SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=? AND ACCOUNT_STATUS='ACTIVE' AND USER_STATUS=1").toString();


}
