package com.ontarget.constant;

/**
 * Created by Owner on 10/30/14.
 */
public interface OnTargetQuery {

    public static final String REGISTRATION_REQUEST=new StringBuilder("INSERT INTO REGISTRATION_REQUEST (project_id,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER, MSG,STATUS) VALUES (?,?,?,?,?,?,?)").toString();

    public static final  String USER_LOGIN=new StringBuilder("SELECT * FROM USER WHERE USER_NAME=? AND PASSWORD=? AND ACCOUNT_STATUS!='LOCKED'").toString();

    public static final String EXPIRE_TOKEN = new StringBuilder("UPDATE USER_SESSION_INFO SET EXPIRE_DATE=NOW(),is_expired='1' WHERE USER_ID=(SELECT USER_ID FROM USER WHERE USER_NAME=?) and is_expired='0'").toString();

    public static final String  GET_USER_REQUEST_INFO=new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE REGISTRATION_REQ_ID=?").toString();

    public static final String GET_USER_REGISTRATION_PENDING_REQUEST = new StringBuilder("SELECT REGISTRATION_REQ_ID,NAME,EMAIL,COMPANY_NAME,PHONE_NUMBER,MSG,STATUS FROM REGISTRATION_REQUEST WHERE status='PENDING'").toString();

    public static final String APPROVE_PENDING_USER_REQUEST= new StringBuilder("UPDATE REGISTRATION_REQUEST SET STATUS=? WHERE REGISTRATION_REQ_ID=?").toString();


    public static final String CREATE_NEW_USER = new StringBuilder("INSERT INTO USER (USER_NAME, USER_TYPE_id, PASSWORD, USER_STATUS,NUMBER_OF_LOGIN, MODIFIED_DATE, ACCOUNT_STATUS) VALUES (?,?,?,?,?,NOW(),?)").toString();


    //TODO: MOVE ACTIVE TO CONSTANT CLASS. ADD MORE FIELDS TO THIS QUERY.
    public static final String CREATE_CONTACT=new StringBuilder("INSERT INTO CONTACT (user_id, contact_company_id, first_name,last_name, title, created_date, created_by, modified_date, modified_by, contact_status,contact_image) values (?,?,?,?,?,  NOW(),'SYSTEM', NOW(),'SYSTEM','ACTIVE',?)").toString();

    public static final String CREATE_COMPANY=new StringBuilder("INSERT INTO COMPANY_INFO (COMPANY_NAME, COMPANY_TYPE_ID,ADDRESS1, ADDRESS2, CITY, STATE, ZIPCODE,COUNTRY, WEBSITE,STATUS) values (?,?,?,?,?,?,?,?,?,?)").toString();

    public static final String GET_COMPANY = new StringBuilder("SELECT * FROM COMPANY_INFO").toString();


    public static final String ADD_PROJECT = new StringBuilder("INSERT INTO  PROJECT (PROJECT_NAME, PROJECT_DESCRIPTION,PROJECT_TYPE_ID, COMPANY_ID, ADDRESS_ID,PROJECT_STATUS,PROJECT_PARENT_ID,project_start_date,project_end_date, CREATED_DATE, CREATED_BY, MODIFIED_DATE,MODIFIED_BY,project_image_path ) VALUES (?,?,?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM',?)").toString();

    public static final String ADD_ADDRESS = new StringBuilder("INSERT INTO ADDRESS (address1,address2,city,state,zip,country,address_type) values (?,?,?,?,?,?,?)").toString();

    public static  final String ADD_TASK=new StringBuilder("INSERT INTO PROJECT_TASK (PROJECT_ID,TITLE,DESCRIPTION, PARENT_TASK_ID,STATUS,SEVERITY, START_DATE, END_DATE, CREATED_DATE, CREATED_BY, MODIFIED_DATE, MODIFIED_BY) values (?,?,?,?,?,?,?,?,NOW(),'SYSTEM',NOW(),'SYSTEM')").toString();

    public static final String GET_PROJECT_TASK=new StringBuilder("SELECT * , if(status='COMPLETED',true,false) as completed FROM PROJECT_TASK WHERE PROJECT_ID=?").toString();

    public final static String GET_PROJECT = new StringBuilder("SELECT * FROM PROJECT WHERE PROJECT_ID=?").toString();

    public static final String GET_ADDRESS = new StringBuilder("SELECT * FROM ADDRESS WHERE ADDRESS_ID=?").toString();

    public static final String GET_PROJECT_BY_COMPANY = new StringBuilder("SELECT p.* FROM contact c, PROJECT p")
            .append(" where p.company_id=c.contact_company_id and p.company_id=? and c.user_id=? order by p.project_id, p.project_parent_id").toString();

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

    public static final String UPDATE_TASK = new StringBuilder("update project_task set title=?,description=?,parent_task_id=?,status=?,start_date=?,end_date=?,percentage_complete=?,severity=?,modified_by=?, modified_date=now() where project_task_id=?").toString();

    public static final String UPDATE_TASK_PLANNED_ESTIMATED_COST = new StringBuilder("update planned_actuals_cost set value=?,modified_by=?,modified_date=now() where id=?").toString();

    public static final String GET_TASK_COST_MIN_MAX_DATE = new StringBuilder("select min(pac.from_date) as min_date,max(pac.to_date) as max_date  from")
            .append(" planned_actuals_cost pac, project_task pt, project p")
            .append(" where pac.task_id=pt.project_task_id and pt.project_id=p.project_id and pac.cost_type=? and p.project_id=?").toString();

    public static final String GET_TASK_PLANNED_ESTIMATED_COST_BY_PROJECT = new StringBuilder("select pt.title,pt.project_task_id,pt.project_id,pac.* from planned_actuals_cost pac, project_task pt, project p ")
            .append(" where pac.task_id=pt.project_task_id and pt.project_id=p.project_id and pac.cost_type=? and p.project_id=? order by pt.created_date asc").toString();

    public static final String ADD_TASK_PERCENTAGE_COMPLETE = new StringBuilder("insert into task_percentage_log (task_id, start_date, end_date, percentage_type, percentage_complete, created_by, created_date, modified_by, modified_date) values (?,?,?,?,?, ?, now(), ?, now())").toString();

    public static final String UPDATE_TASK_PERCENTAGE_COMPLETE = new StringBuilder("update task_percentage_log set percentage_complete=?,modified_by=?,modified_date=now() where id=?").toString();

    public static final String SAVE_UPLOADED_DOCUMENT =  new StringBuilder("insert into project_file (file_name,project_id,created_by,created_date) values (?,?,?,now())").toString();
    
    public static final String GET_PROJECT_FILE=new StringBuilder("SELECT * FROM PROJECT_FILE WHERE PROJECT_ID=?").toString();


    interface documentTemplate {
    	String ADD = "insert into document_template (name, created_by, created_date, modified_by, modfied_date) values(?, ?, now(), ?, now())";
    	String UPDATE = "";
    	String DELETE = "";
    	String GET_BY_ID = "select * from document_template where document_template_id = ?";
    }
    
    interface document {
    	String ADD = "insert into document (document_template_id, name, status, created_by, created_date, modified_by, modified_date) values(?, ?, ?, ?, now(), ?, now())";
    	String UPDATE_STATUS = "update document set status=?, modified_by=?, modified_date=now() where document_id=?";
    	String DELETE = "";
    	String GET_BY_ID = "select * from document where document_id = ?";
    	String GET_BY_TEMPLATE_ID = "select * from document where document_template_id = ?";
    	String GET_BY_CREATED_BY = "select * from document where created_by = ?";
    	String GET_BY_ASSIGNEE_USERNAME = "select doc.* from document doc " +
						"inner join document_submittal sub on doc.document_id = sub.document_id " +
						"inner join user u on u.user_id = sub.assignee_user_id " +
						"where u.user_name=?";
    }
    
    interface documentKeyValue {
    	String ADD = "insert into document_key_value (document_id,`key`,value,created_by,created_date,modified_by,modified_date) values(?, ?, ?, ?, now(), ?, now())";
    	String UPDATE_VALUE = "update document_key_value set value = ?, modified_by=? where document_id = ? and `key` = ?";
    	String DELETE = "";
    	String GET_BY_DOCUMENT = "select * from document_key_value where document_id = ?";
    	String GET_BY_DOCUMENT_KEY = "select * from document_key_value where document_id = ? and key = ?";
    }
    
    interface documentGridKeyValue {
    	String ADD = "insert into document_grid_key_value (document_id,grid_id,grid_row_index,`key`,value,"
    			+ "created_by,created_date,modified_by,modified_date) values(?,?,?,?,?,?,now(),?,now())";
    	String UPDATE_VALUE = "update document_grid_key_value set value=?, modified_by=? where document_id=? and grid_id=? and grid_row_index=? and `key`=?";
    	String DELETE = "";
    	String GET_BY_DOCUMENT_GRID = "select * from document_grid_key_value where document_id = ? and grid_id = ?";
    }
    
    interface documentSubmittal {
    	String ADD = "insert into document_submittal (document_id, assignee_user_id, created_by, created_date, "
    			+ "modified_by, modified_date) values(?,?, ?, now(), ?, now())";
    	String DELETE = "delete from document_submittal where document_submittal_id=?";
    	String GET_BY_ID = "select * from document_submittal where document_submittal_id=?";
    }
    
    interface documentAttachment {
    	String ADD = "insert into document_attachment(`document_id`,`file_path`,`created_by`,`created_date`,`modified_by`,`modified_date`) " +
    				 "values (?,?,?,now(),?,now());";
    	String GET_BY_DOCUMENT_ID = "select * from document_attachment where document_id=?";
    }
    
    String GET_EMAIL_BY_CONTACT_ID = "select * from email where contact_id = ?";
    String GET_USER_BY_ID = "select * from user where user_id=?";


}
