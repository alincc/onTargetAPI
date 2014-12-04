package com.ontarget.constant;

/**
 * Created by Owner on 10/29/14.
 */
public interface OnTargetConstant {

    public static  final String SUCCESS="SUCCESS";
    public static  final String ERROR="ERROR";


    public static final String RETURN_MESSAGE_AUTHENTICATION = "Successfully Authenticated";
    public static final String SUCCESSFULLY_REGISTERED = "Registration Successfully Requested";
    public static final String REGISTRATION_REQUEST_FAILED = "Registration request failed";
    public static final String REGISTRATION_PENDING = "PENDING";
    public static final String REGISTRATION_APPROVAL_REQUEST_FAILED = "Registration approval request failed";
    public static final String PENDING_REQUEST_RECEIVED = "Pending Requests Retrieved";
    public static final String LOGOUT_SUCCESSFULL = "Successfully Logged out";
    public static final String ERROR_LOGGEDOUT = "Error Logging out";
    public static final String REGISTRATION_APPROVAL_REQUEST_SUCCESS = "Registration approval request success";
    public static final String AUTHENTICATION_FAILED = "Authentication Failed";
    public static final String REGSITRATION_REQUEST_APPROVED = "APPROVED";


    interface AddressType{
        public static final String PROJECT_ADDR = "PROJECT";
        public static final String COMPANY_ADDR = "COMPANY";
        public static final String CONTACT_ADDR = "CONTACT";
    }

    /**
     * Email Constants
     */


    interface EmailServiceConstants{
        public static final String USER_REGISTRATION_SUBJECT="OnTarget Registration Request";
        public static final String USER_REGISTRATION_FROM="dontoreply@ontarget.com";
        public static final String USER_REGISTRATION_REQUEST_APPROVAL_SUBJECT = "OnTarget Registration Approval";

        public static final String USER_REGISTRATION_ADMIN_EMAIL="ontarget@gmail.com";
    }

    public interface USER_STATUS {
        public static final String ACTIVE="1";
        public static final String PENDING="0";

    }
    public interface AccountStatus {

        public static final String ACTIVE="ACTIVE";
        public static final String LOCKED="LOCKED";
        public static final String ACCOUNT_INVITATION="ACCT_INVITE";
        public static final String ACCT_NEW = "ACCT_NEW";
    }

    public interface CompanyStatus {
        public static final String STATUS="ACTIVE";
    }

    public interface CostType {
        public static final String PLANNED="PLANNED";
        public static final String ACTUAL="ACTUAL";
    }

    public interface PROJECT_STATUS {
        public static final String ACTIVE="1";
        public static final String PENDING="0";
    }
}
