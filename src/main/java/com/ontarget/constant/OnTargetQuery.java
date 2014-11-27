package com.ontarget.constant;

/**
 * Created by Owner on 10/30/14.
 */
public interface OnTargetQuery {

    public static final String REGISTRATION_REQUEST = new StringBuilder("INSERT INTO REGISTRATION_REQUEST (project_id,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER, MSG,STATUS) VALUES (?,?,?,?,?,?)").toString();

    public static final String USER_LOGIN = new StringBuilder("SELECT * FROM USER WHERE USER_NAME=? AND PASSWORD=? AND ACCOUNT_STATUS='ACTIVE' AND USER_STATUS=1").toString();

    public static final String EXPIRE_TOKEN = new StringBuilder("UPDATE USER_SESSION_INFO SET EXPIRE_DATE=NOW() WHERE USER_ID=(SELECT USER_ID FROM USER WHERE USER_NAME=?)").toString();

    public static final String GET_USER_REQUEST_INFO = new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE REGISTRATION_REQ_ID=?").toString();

    public static final String GET_USER_REGISTRATION_PENDING_REQUEST = new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE status='PENDING'").toString();

    public static final String APPROVE_PENDING_USER_REQUEST = new StringBuilder("UPDATE REGISTRATION_REQUEST SET STATUS=? WHERE REGISTRATION_REQ_ID=?").toString();


    public static final String CREATE_NEW_USER = new StringBuilder("INSERT INTO USER (USERNAME, USER_TYPE, PASSWORD, USER_STATUS,NUMBER_OF_LOGIN, MODIFIED_DATE, ACCOUNT_STATUS) VALUES (?,?,?,?,?,NOW(),?,?)").toString();

    public static final String CHANGE_USER_PASSWORD = new StringBuilder("UPDATE user SET password=? , salt=? WHERE user_id=?").toString();

    //TODO: MOVE ACTIVE TO CONSTANT CLASS. ADD MORE FIELDS TO THIS QUERY.
    public static final String CREATE_CONTACT = new StringBuilder("INSERT INTO CONTACT (user_id, contact_company_id, first_name,last_name, title, created_date, created_by, modified_date, modified_by, contact_status,contact_image) values (?,?,?,?,?,  NOW(),'SYSTEM', NOW(),'SYSTEM','ACTIVE',?)").toString();

    public static final String UPDATE_CONTACT = new StringBuilder("UPDATE contact SET first_name=?,last_name=?, title=?, contact_image=? WHERE user_id=?").toString();

    public static final String CREATE_COMPANY = new StringBuilder("INSERT INTO COMPANY_INFO (COMPANY_NAME, COMPANY_TYPE_ID,ADDRESS1, ADDRESS2, CITY, STATE, ZIPCODE,COUNTRY, WEBSITE,STATUS) values (?,?,?,?,?,?,?,?,?,?)").toString();

    public static final String GET_COMPANY = new StringBuilder("SELECT * FROM COMPANY_INFO").toString();


    public static final String ADD_PROJECT = new StringBuilder("INSERT INTO  PROJECT (PROJECT_NAME, PROJECT_DESCRIPTION,PROJECT_TYPE_ID, COMPANY_ID, ADDRESS_ID,PROJECT_STATUS,PROJECT_PARENT_ID,project_start_date,project_end_date, CREATED_DATE, CREATED_BY, MODIFIED_DATE,MODIFIED_BY,project_image_path ) VALUES (?,?,?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM',?)").toString();

    public static final String ADD_ADDRESS = new StringBuilder("INSERT INTO ADDRESS (address1,address2,city,state,zip,country,address_type) values (?,?,?,?,?,?,?)").toString();

    public static final String ADD_TASK = new StringBuilder("INSERT INTO PROJECT_TASK (PROJECT_ID,TITLE,DESCRIPTION, PARENT_TASK_ID,STATUS,SEVERITY, START_DATE, END_DATE, CREATED_DATE, CREATED_BY, MODIFIED_DATE, MODIFIED_BY) values (?,?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM')").toString();

    public static final String GET_PROJECT_TASK = new StringBuilder("SELECT * , if(status='COMPLETED',true,false) as completed FROM PROJECT_TASK WHERE PROJECT_ID=?").toString();

    public final static String GET_PROJECT = new StringBuilder("SELECT * FROM PROJECT WHERE PROJECT_ID=?").toString();

    public static final String GET_ADDRESS = new StringBuilder("SELECT * FROM ADDRESS WHERE ADDRESS_ID=?").toString();

    public static final String GET_PROJECT_BY_COMPANY = new StringBuilder("SELECT p.* FROM contact c, PROJECT p,project_member pm")
            .append(" where c.user_id=pm.user_id and p.company_id=c.contact_company_id and p.company_id=? and c.user_id=? order by p.project_id, p.project_parent_id").toString();

    public static final String GET_COMPANY_BY_USER = new StringBuilder("Select * from contact where user_id=?").toString();

    public static final String GET_PROJECT_TASK_COUNT_BY_STATUS = new StringBuilder("select t.status_name, if(j.count is null,0,j.count) as count from task_status t")
            .append(" left outer join (select p.status, count(p.status) as count from project_task p where project_id=? group by status) j")
            .append(" on t.status_code=j.status").toString();

    public static final String GET_PROJECT_AND_TASKS = new StringBuilder("select p.project_id, p.project_parent_id, t.* from project p left outer join project_task t")
            .append(" on p.project_id=t.project_id order by p.project_id, t.project_parent_id,t.project_task_id").toString();

    public static final String ADD_TASK_COMMENT = new StringBuilder("insert into task_comment (task_id, comment, commented_by, commented_date, comment_status) values (?, ?, ? ,now(),'ACTIVE')").toString();

    public static final String UPDATE_TASK_COMMENT = new StringBuilder("update task_comment set comment=?, commented_by=?, commented_date=now() where task_comment_id=?").toString();

    public static final String GET_TASK_COMMENT = new StringBuilder("select * from task_comment where task_id=? and comment_status='ACTIVE'").toString();

    public static final String SAVE_USER_SESSION_INFO = new StringBuilder("insert into user_session_info (user_id,login_token,created_date,expire_date,is_expired) values (?,?,now(),'9999/12/31','0')").toString();

    public static final java.lang.String ADD_TASK_PLANNED_ESTIMATED_COST = new StringBuilder("insert into planned_actuals_cost (task_id, from_date,to_date, cost_type, value, expiry_date, created_by, created_date, modified_by, modified_date) values (?.?.?,?,?,'9999/12/31','SYSTEM',NOW(),'SYSTEM',NOW())").toString();

    public static final String UPDATE_PROJECT_ADDRESS = new StringBuilder("update address set address1=?,address2=?,city=?,state=?,zip=?,country=? where address_id=?").toString();

    public static final String UPDATE_PROJECT = new StringBuilder("update project set project_name=?,project_description=?,project_type=?, project_parent_id=?, project_status=?, project_start_date=?,project_end_date=?, modified_by=?, modified_date=now() where project_id=?").toString();

    public static final String GET_PROJECT_MEMBERS = new StringBuilder("SELECT * FROM project_member WHERE project_id=?").toString();

    public static final String UPDATE_TASK = new StringBuilder("update project_task set title=?,description=?,parent_task_id=?,status=?,start_date=?,end_date=?,percentage_complete=?,severity=?,modified_by=?, modified_date=now() where project_task_id=?").toString();

    public static final String GET_TASK_MEMBERS = new StringBuilder("SELECT `user_id` FROM `task_member` WHERE `task_id`=? and `status` = 'ACTIVE'").toString();

    public static final String ADD_TASK_MEMBER = new StringBuilder("INSERT INTO task_member (task_id, project_id, user_id) VALUES (?, ?, ?)").toString();

    public static final String UPDATE_TASK_PLANNED_ESTIMATED_COST = new StringBuilder("update planned_actuals_cost set value=?,modified_by=?,modified_date=now() where id=?").toString();

    public static final String ADD_REGISTRATION_INVITATION = new StringBuilder("INSERT INTO registration_request (registration_token, first_name, last_name, email) VALUES (?,?,?,?) ").toString();
}
