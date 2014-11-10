package com.ontarget.constant;

/**
 * Created by Owner on 10/30/14.
 */
public interface OnTargetQuery {

    public static final String REGISTRATION_REQUEST=new StringBuilder("INSERT INTO REGISTRATION_REQUEST (NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER, MSG,STATUS) VALUES (?,?,?,?,?,?)").toString();

    public static final  String USER_LOGIN=new StringBuilder("SELECT * FROM USER WHERE USERNAME=? AND PASSWORD=? AND ACCOUNT_STATUS='ACTIVE' AND USER_STATUS=1").toString();

    public static final String EXPIRE_TOKEN = new StringBuilder("UPDATE USER_SESSION_INFO SET EXPIRE_DATE=NOW() WHERE USER_ID=(SELECT USER_ID FROM USER WHERE USER_NAME=?)").toString();

    public static final String  GET_USER_REQUEST_INFO=new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE REGISTRATION_REQ_ID=?").toString();

    public static final String GET_USER_REGISTRATION_PENDING_REQUEST = new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE status='PENDING'").toString();

    public static final String APPROVE_PENDING_USER_REQUEST= new StringBuilder("UPDATE REGISTRATION_REQUEST SET STATUS=? WHERE REGISTRATION_REQ_ID=?").toString();


    public static final String CREATE_NEW_USER = new StringBuilder("INSERT INTO USER (USERNAME, USER_TYPE, PASSWORD, USER_STATUS,NUMBER_OF_LOGIN, MODIFIED_DATE, ACCOUNT_STATUS) VALUES (?,?,?,?,?,NOW(),?,?)").toString();


    //TODO: MOVE ACTIVE TO CONSTANT CLASS. ADD MORE FIELDS TO THIS QUERY.
    public static final String CREATE_CONTACT=new StringBuilder("INSERT INTO CONTACT (user_id, contact_company_id, first_name,last_name, title, created_date, created_by, modified_date, modified_by, contact_status) values (?,?,?,?,?,  NOW(),'SYSTEM', NOW(),'SYSTEM','ACTIVE')").toString();

    public static final String CREATE_COMPANY=new StringBuilder("INSERT INTO COMPANY_INFO (COMPANY_NAME, COMPANY_TYPE_ID,ADDRESS1, ADDRESS2, CITY, STATE, ZIPCODE,COUNTRY, WEBSITE,STATUS) values (?,?,?,?,?,?,?,?,?,?)").toString();

    public static final String GET_COMPANY = new StringBuilder("SELECT * FROM COMPANY_INFO").toString();


    public static final String ADD_PROJECT = new StringBuilder("INSERT INTO  PROJECT (PROJECT_NAME, PROJECT_DESCRIPTION,PROJECT_TYPE_ID, COMPANY_ID, ADDRESS_ID,PROJECT_STATUS,PROJECT_PARENT_ID, CREATED_DATE, CREATED_BY, MODIFIED_DATE,MODIFIED_BY ) VALUES (?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM')").toString();

    public static final String ADD_ADDRESS = new StringBuilder("INSERT INTO ADDRESS (address1,address2,city,state,zip,country,address_type) values (?,?,?,?,?,?,?)").toString();

    public static  final String ADD_TASK=new StringBuilder("INSERT INTO PROJECT_TASK (PROJECT_ID,TITLE,DESCRIPTION, PARENT_TASK_ID,STATUS,SEVERITY, START_DATE, END_DATE, CREATED_DATE, CREATED_BY, MODIFIED_DATE, MODIFIED_BY) values (?,?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM')").toString();

    public static final String GET_PROJECT_TASK=new StringBuilder("SELECT * FROM PROJECT_TASK WHERE PROJECT_ID=?").toString();

    public final static String GET_PROJECT = new StringBuilder("SELECT * FROM PROJECT WHERE PROJECT_ID=?").toString();

    public static final String GET_ADDRESS = new StringBuilder("SELECT * FROM ADDRESS WHERE ADDRESS_ID=?").toString();

    public static final String GET_PROJECT_BY_COMPANY = new StringBuilder("SELECT * FROM contact c, PROJECT p,project_member pm")
            .append(" where c.user_id=pm.user_id and p.company_id=c.contact_company_id and p.company_id=? and c.user_id=?").toString();

    public static final String GET_COMPANY_BY_USER = new StringBuilder("Select * from contact where user_id=?").toString();
}
