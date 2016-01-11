package com.ontarget.util;

public class EmailConstant {

	public interface Template {
		public static final String REGISTRATION_REQUEST = "/template/registrationRequest.vm";
        public static final String TASK_ASSIGNMENT = "/template/taskAssignedEmail.vm";
        public static final String DOCUMENT_SUBMITTAL = "/template/documentSubmittal.vm";
    }

	public interface EmailParameter {
		public static final String FIRST_NAME = "firstName";
		public static final String URL = "url";

	}

    public interface SendEmailType{
        public static final String REQUEST_FOR_DEMO_APPROVED="REQUEST_FOR_DEMO_APPROVED";
        public static final String TASK_ASSIGNMENT="TASK_ASSIGNMENT";
        public static final String DOCUMENT_SUBMITTAL = "DOCUMENT_SUBMITTAL";
    }


    public static final String APP_LINK="https://itunes.apple.com/us/app/ontarget-field/id971808755?ls=1&amp;mt=8";

    public interface EmailSubject {
        public static final String USER_REGISTRATION_SUBJECT = "OnTarget Registration Request";
        public static final String EMAIL_FROM = "onTarget <no-reply@ontargetcloud.com>";
        public static final String EMAIL_FROM_WITHOUT_NAME = "no-reply@ontargetcloud.com";
        public static final String DO_NOT_REPLY_EMAIL = "<no-reply@ontargetcloud.com>";
        public static final String ONBOARDING_TO_ONTARGET_SUBJECT = "Onboarding to OnTarget";

        public static final String DOCUMENT_APPROVAL_SUBJECT = "New document available for approval";
        public static final String USER_REGISTRATION_ADMIN_EMAIL = "niran@ontargetcloud.com";
        public static final String INVITE_USER_TO_ACCOUNT_SUBJECT = "Invitation to OnTarget";
        public static final String TASK_ASSIGNED_SUBJECT = "Task Assigned";
        public static final String TASK_STATUS_SUBJECT = "Task status";
        public static final String TASK_COMMENT_SUBJECT = "Task comment";
        public static final String TASK_ATTACHMENT_SUBJECT = "Task attachment";
        public static final String FORGOT_PASSWORD_SUBJECT = "Forgot Password";
        public static final String DOCUMENT_STATUS_UPDATE_SUBJECT = "Document status";
        public static final String DOCUMENT_SUBMITTAL_SUBJECT = "Document submittal";

        public static final String REQUEST_FOR_DEMO_APPROVE_URL = "/#/app/pending-account-request";
        public static final String USER_INVITE_TO_COLLABORATE = "Invite to Collaborate";

        public static final String DEFAULT_NAME="there";
    }
}
