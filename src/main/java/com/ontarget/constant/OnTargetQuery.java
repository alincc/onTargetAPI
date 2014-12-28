package com.ontarget.constant;

/**
 * Created by Owner on 10/30/14.
 */
public interface OnTargetQuery {

    public static final String REGISTRATION_REQUEST = new StringBuilder("INSERT INTO REGISTRATION_REQUEST (project_id,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER, MSG,STATUS) VALUES (?,?,?,?,?,?,?)").toString();

    public static final String USER_LOGIN = new StringBuilder("SELECT * FROM USER WHERE USER_NAME=? and ACCOUNT_STATUS!='LOCKED'").toString();

    public static final String EXPIRE_TOKEN = new StringBuilder("UPDATE USER_SESSION_INFO SET EXPIRE_DATE=NOW(),is_expired='1' WHERE USER_ID=(SELECT USER_ID FROM USER WHERE USER_NAME=?) and is_expired='0'").toString();

    public static final String GET_USER_REQUEST_INFO = new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE REGISTRATION_REQ_ID=?").toString();

    public static final String GET_USER_REGISTRATION_PENDING_REQUEST = new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE status='PENDING'").toString();

    public static final String APPROVE_PENDING_USER_REQUEST = new StringBuilder("UPDATE REGISTRATION_REQUEST SET STATUS=? WHERE REGISTRATION_REQ_ID=?").toString();

    public static final String CREATE_NEW_USER = new StringBuilder("INSERT INTO user(user_name, user_type_id, password, salt, discipline, user_status,number_of_login, modified_date, account_status, user_id) VALUES (?,?,?,?,?,?,?,NOW(),?,?)").toString();

    public static final String CHANGE_USER_PASSWORD = new StringBuilder("UPDATE user SET password=? , salt=? WHERE user_id=?").toString();

    //TODO: MOVE ACTIVE TO CONSTANT CLASS. ADD MORE FIELDS TO THIS QUERY.
    public static final String CREATE_CONTACT = new StringBuilder("INSERT INTO CONTACT (user_id, contact_company_id, first_name,last_name, title, created_date, created_by, modified_date, modified_by, contact_status,contact_image) values (?,?,?,?,?,  NOW(),0, NOW(),0,'ACTIVE',?)").toString();

    public static final String UPDATE_CONTACT = new StringBuilder("UPDATE contact SET first_name=?,last_name=?, title=?, contact_image=? WHERE user_id=?").toString();

    public static final String CREATE_COMPANY = new StringBuilder("INSERT INTO COMPANY_INFO (COMPANY_NAME, COMPANY_TYPE_ID,ADDRESS1, ADDRESS2, CITY, STATE, ZIPCODE,COUNTRY, WEBSITE,STATUS) values (?,?,?,?,?,?,?,?,?,?)").toString();

    public static final String GET_COMPANY = new StringBuilder("SELECT company_name FROM company_info where company_id=?").toString();

    public static final String ADD_PROJECT = new StringBuilder("INSERT INTO  PROJECT (PROJECT_NAME, PROJECT_DESCRIPTION,PROJECT_TYPE_ID, COMPANY_ID, ADDRESS_ID,PROJECT_STATUS,PROJECT_PARENT_ID,project_start_date,project_end_date, CREATED_DATE, CREATED_BY, MODIFIED_DATE,MODIFIED_BY,project_image_path ) VALUES (?,?,?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM',?)").toString();

    public static final String ADD_ADDRESS = new StringBuilder("INSERT INTO ADDRESS (address1,address2,city,state,zip,country,address_type) values (?,?,?,?,?,?,?)").toString();

    public static final String ADD_TASK = new StringBuilder("INSERT INTO PROJECT_TASK (PROJECT_ID,TITLE,DESCRIPTION, PARENT_TASK_ID,STATUS,SEVERITY, START_DATE, END_DATE, CREATED_DATE, CREATED_BY, MODIFIED_DATE, MODIFIED_BY) values (?,?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM')").toString();

    public static final String GET_PROJECT_TASK = new StringBuilder("SELECT * , if(status='COMPLETED',true,false) as completed FROM project_task WHERE project_id=?").toString();

    public final static String GET_PROJECT = new StringBuilder("SELECT * FROM PROJECT WHERE PROJECT_ID=?").toString();

    public static final String GET_ADDRESS = new StringBuilder("SELECT * FROM address WHERE address_id=?").toString();

    public static final String GET_PROJECT_BY_COMPANY = new StringBuilder("SELECT p.* FROM contact c, project p")
            .append(" where p.company_id=c.contact_company_id and p.company_id=? and c.user_id=? order by p.project_id, p.project_parent_id").toString();

    public static final String GET_CONTACT_BY_USER = new StringBuilder("Select * from contact where user_id=?").toString();

    public static final String GET_PROJECT_TASK_COUNT_BY_STATUS = new StringBuilder("select t.status_name, if(j.count is null,0,j.count) as count from task_status t")
            .append(" left outer join (select p.status, count(p.status) as count from project_task p where project_id in ")
            .append(" (select project_id from project where  project_parent_id=?) group by status) j")
            .append(" on t.task_status_id=j.status").toString();

    public static final String GET_PROJECT_AND_TASKS = new StringBuilder("select p.project_id, p.project_parent_id, t.* from project p left outer join project_task t")
            .append(" on p.project_id=t.project_id order by p.project_id, t.project_parent_id,t.project_task_id").toString();

    public static final String ADD_TASK_COMMENT = new StringBuilder("insert into task_comment (task_id, comment, commented_by, commented_date, comment_status) values (?, ?, ? ,now(),'ACTIVE')").toString();

    public static final String UPDATE_TASK_COMMENT = new StringBuilder("update task_comment set comment=?, commented_by=?, commented_date=now() where task_comment_id=?").toString();

    public static final String GET_TASK_COMMENT = new StringBuilder("select * from task_comment where task_id=? and comment_status='ACTIVE'").toString();

    public static final String SAVE_USER_SESSION_INFO = new StringBuilder("insert into user_session_info (user_id,login_token,created_date,expire_date,is_expired) values (?,?,now(),'9999/12/31','0')").toString();

    public static final String ADD_TASK_PLANNED_ESTIMATED_COST = new StringBuilder("insert into planned_actuals_cost (task_id, from_date,to_date, cost_type, value, expiry_date, created_by, created_date, modified_by, modified_date) values (?,?,?,?,?,'9999-12-31','0',NOW(),'0',NOW())").toString();

    public static final String UPDATE_PROJECT_ADDRESS = new StringBuilder("update address set address1=?,address2=?,city=?,state=?,zip=?,country=? where address_id=?").toString();

    public static final String UPDATE_PROJECT = new StringBuilder("update project set project_name=?,project_description=?,project_type_id=?, project_parent_id=?, project_status=?, project_start_date=?,project_end_date=?, modified_by=?, modified_date=now() where project_id=?").toString();

    public static final String GET_PROJECT_MEMBERS = new StringBuilder("select c.user_id,c.first_name,c.last_name,c.contact_image,cp.area_code,cp.phone_number, cp.phone_type,pm.*  from contact c, project_member pm, project p, phone cp")
            .append(" where  c.user_id=pm.user_id and  p.project_id=pm.project_id and  c.contact_id=cp.contact_id")
            .append(" and pm.project_id=?").toString();

    public static final String UPDATE_TASK = new StringBuilder("update project_task set title=?,description=?,parent_task_id=?,status=?,start_date=?,end_date=?,percentage_complete=?,severity=?,modified_by=?, modified_date=now() where project_task_id=?").toString();

    public static final String GET_TASK_MEMBERS = new StringBuilder("SELECT `user_id` FROM `task_member` WHERE `task_id`=? and `status` = 'ACTIVE'").toString();

    public static final String ADD_TASK_MEMBER = new StringBuilder("INSERT INTO task_member (task_id, project_id, user_id) VALUES (?, ?, ?)").toString();

    public static final String UPDATE_TASK_PLANNED_ESTIMATED_COST = new StringBuilder("update planned_actuals_cost set value=?,modified_by=?,modified_date=now() where id=?").toString();

    public static final String GET_TASK_COST_MIN_MAX_DATE = new StringBuilder("select min(pac.from_date) as min_date,max(pac.to_date) as max_date  from")
            .append(" planned_actuals_cost pac, project_task pt, project p")
            .append(" where pac.task_id=pt.project_task_id and pt.project_id=p.project_id and pac.cost_type=? and p.project_id=?").toString();

    public static final String GET_TASK_PLANNED_ESTIMATED_COST_BY_PROJECT = new StringBuilder("select pt.title,pt.project_task_id,pt.project_id,pac.* from planned_actuals_cost pac, project_task pt, project p ")
            .append(" where pac.task_id=pt.project_task_id and pt.project_id=p.project_id and pac.cost_type=? and p.project_id in (select project_id from project where p.project_parent_id=?) order by pt.project_task_id asc").toString();

    public static final String ADD_TASK_PERCENTAGE_COMPLETE = new StringBuilder("insert into task_percentage_log (task_id, start_date, end_date, percentage_type, percentage_complete, created_by, created_date, modified_by, modified_date) values (?,now(),'9999/12/31',?,?, ?, now(), ?, now())").toString();

    public static final String UPDATE_TASK_PERCENTAGE_COMPLETE = new StringBuilder("update task_percentage_log set percentage_complete=?,modified_by=?,modified_date=now() where task_percentage_log_id=?").toString();

    public static final String SAVE_UPLOADED_DOCUMENT = new StringBuilder("insert into project_file (file_name,file_type,project_id,created_by,created_date) values (?,?,?,?,now())").toString();

    public static final String GET_PROJECT_FILE = new StringBuilder("SELECT * FROM PROJECT_FILE WHERE PROJECT_ID=?").toString();

    public static final String ADD_PROJECT_MEMBER = new StringBuilder("insert into project_member (project_id, user_id,member_status) values (?,?,?)").toString();

    public static final String GET_PROJECT_BY_USER = new StringBuilder("select pt.* from project pt, (select p.project_id from project p,project_member pm where p.project_id=pm.project_id and p.project_parent_id=0 and pm.user_id=?) t where pt.project_id=t.project_id or pt.project_parent_id=t.project_id").toString();

    public static final String UPDATE_REGISRATION_USER_ID = new StringBuilder("update registration_request set user_id=? where registration_token=?").toString();

    public static final String ACTIVATE_USER_ACCOUNT = new StringBuilder("update user set account_status='ACTIVE' where user_id=?").toString();

    public static final String ADD_CONTACT_PHONE = new StringBuilder("insert into phone (contact_id,area_code,phone_number, phone_type, status) values (?,?,?,?,?)").toString();

    public static final String ASSIGN_TASK_USER = new StringBuilder("insert into task_assignee (project_task_id, task_assignee) values (?,?)").toString();

    public static final String UPDATE_TASK_USER = new StringBuilder("update task_assignee set task_assignee=? where project_task_id=?").toString();

    public static final String EXPIRE_TASK_PERCENTAGE_COMPLETE = new StringBuilder("update task_percentage_log set end_date='9999-12-31' where task_percentage_log_id=?").toString();

    public static final String GET_TASK_PERCENTAGE_FOR_THIS_MONTH = new StringBuilder("select * from task_percentage_log tpl where month(tpl.created_by)=month(now()) and end_date='9999-12-31'").toString();

    public static final String ADD_FORGOT_PASSWORD_REQUEST = new StringBuilder("insert into forgot_password_request (user_id, forgot_password_token,status, ts_expiry) values (?,?,?, now() + INTERVAL 24 HOUR);").toString();

    public static final String GET_FORGOT_PASSWORD_REQUEST = new StringBuilder("select count(id) from forgot_password_request where forgot_password_token=? and status='ACTIVE' and ts_expiry > now()").toString();

    public static final String GET_TASK_ASSIGNEE = new StringBuilder("select task_assignee from task_assignee where project_task_id=?").toString();

    public static final String GET_TASK = new StringBuilder("select * from project_task where project_task_id=?").toString();


    interface documentTemplate {
        public static final String ADD = "insert into document_template (name, created_by, created_date, modified_by, modfied_date) values(?, ?, now(), ?, now())";
        public static final String UPDATE = "";
        public static final String DELETE = "";
        public static final String GET_BY_ID = "select * from document_template where document_template_id = ?";
    }

    interface document {
        public static final String ADD = "insert into document (document_template_id, name, status, created_by, created_date, modified_by, modified_date) values(?, ?, ?, ?, now(), ?, now())";
        public static final  String UPDATE_STATUS = "update document set status=?, modified_by=?, modified_date=now() where document_id=?";
        public static final String DELETE = "";
        public static final String GET_BY_ID = "select * from document where document_id = ?";
        public static final String GET_BY_TEMPLATE_ID = "select * from document where document_template_id = ?";
        public static final String GET_BY_CREATED_BY = "select * from document where created_by = ?";
        public static final String GET_BY_ASSIGNEE_USERNAME = "select doc.* from document doc " +
                "inner join document_submittal sub on doc.document_id = sub.document_id " +
                "inner join user u on u.user_id = sub.assignee_user_id " +
                "where u.user_name=?";
    }

    interface documentKeyValue {
        public static final String ADD = "insert into document_key_value (document_id,`key`,value,created_by,created_date,modified_by,modified_date) values(?, ?, ?, ?, now(), ?, now())";
        public static final String UPDATE_VALUE = "update document_key_value set value = ?, modified_by=? where document_id = ? and `key` = ?";
        public static final String DELETE = "";
        public static final String GET_BY_DOCUMENT = "select * from document_key_value where document_id = ?";
        public static final String GET_BY_DOCUMENT_KEY = "select * from document_key_value where document_id = ? and key = ?";
    }

    interface documentGridKeyValue {
        public static final String ADD = "insert into document_grid_key_value (document_id,grid_id,grid_row_index,`key`,value,"
                + "created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,now(),?,now())";
        public static final String UPDATE_VALUE = "update document_grid_key_value set value=?, modified_by=? where document_id=? and grid_id=? and grid_row_index=? and `key`=?";
        public static final String GET_BY_DOCUMENT_GRID = "select * from document_grid_key_value where document_id = ? and grid_id = ?";
        public static final String GET_BY_DOCUMENT = "select * from document_grid_key_value where document_id = ?";
    }

    interface documentSubmittal {
        public static final String ADD = "insert into document_submittal (document_id, assignee_user_id, created_by, created_date, "
                + "modified_by, modified_date) values(?,?, ?, now(), ?, now())";
        public static final String DELETE = "delete from document_submittal where document_submittal_id=?";
        public static final String GET_BY_ID = "select * from document_submittal where document_submittal_id=?";
    }

    interface documentAttachment {
        public static final String ADD = "insert into document_attachment(`document_id`,`file_path`,`created_by`,`created_date`,`modified_by`,`modified_date`) " +
                "values (?,?,?,now(),?,now());";
        public static final String GET_BY_DOCUMENT_ID = "select * from document_attachment where document_id=?";
    }

    public static final String GET_EMAIL_BY_CONTACT_ID = "select * from email where contact_id = ?";
    public static final String GET_USER_BY_ID = "select * from user where user_id=?";


    public static final String ADD_REGISTRATION_INVITATION = new StringBuilder("INSERT INTO registration_request (registration_token, first_name, last_name, email, project_id,status) VALUES (?,?,?,?,?,?) ").toString();


    public static final String GET_TASK_PERCENTAGE = new StringBuilder("select pt.title,pt.project_task_id,pt.project_id,tpl.*  from task_percentage_log tpl, project_task pt, project p")
                .append(" where tpl.task_id=pt.project_task_id and pt.project_id=p.project_id")
                .append(" and tpl.percentage_type='PERCENTAGE' and p.project_id in (select project_id from project where p.project_parent_id=?) order by pt.project_task_id asc").toString();

    public static final String GET_TASK_PERCENTAGE_BY_TASK=new StringBuilder("select * from task_percentage_log tpl where tpl.task_id=? and tpl.end_date='9999-12-31'").toString();

    public static final String GET_TASK_COST_BY_TASK = new StringBuilder("select * from planned_actuals_cost pac where pac.task_id=?").toString();

    public static final String GET_REGISTRATION_INVITATION_BY_USER = new StringBuilder("SELECT * FROM registration_request WHERE user_id=?").toString();


    public static final String GET_USER = new StringBuilder("SELECT * FROM user WHERE user_id = ?").toString();

    public static final String GET_RANDOM_SAFETY_INFO = new StringBuilder("SELECT name FROM user_safety_info where discipline_id=? ORDER BY RAND() LIMIT 1").toString();
    public static final String INSERT_TASK_FILE = new StringBuilder("INSERT INTO project_task_files (project_task_id, file_name, created_by, location) VALUES (?, ?, ?, ?)").toString();

    public static final String GET_TASK_FILE = new StringBuilder("SELECT * FROM project_task_files WHERE project_task_id = ?").toString();

    public static final String GET_REGISTRATION_INVITATION = new StringBuilder("SELECT * FROM registration_request WHERE registration_token=?").toString();

    public static final String GET_ACTIVITY_LOG = new StringBuilder("SELECT * FROM activity_log where id > ? order by id").toString();

    public static final String UPDATE_USER_IMAGE = new StringBuilder("UPDATE contact SET modified_date=?, modified_by=?, contact_image=? WHERE user_id=?").toString();

    public static final String GET_ALL_COMPANY = new StringBuilder("SELECT * FROM company_info").toString();
}
