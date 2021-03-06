package com.ontarget.constant;

/**
 * Created by Owner on 10/29/14.
 */
public interface OnTargetConstant {

	public static final String SUCCESS = "SUCCESS";
	public static final String ERROR = "ERROR";

	public static final String SUCCESS_CODE = "200"; // does not necessary means
														// transaction
														// completed. just when
														// application is aware
														// of the issue
	public static final String INTERNAL_SERVER_ERROR_CODE = "500";
	public static final String INTERNAL_SERVER_ERROR_MSG = "Unable to process request on server. Please try later";
	public static final String DEFAULT_SUCCESS_MESSAGE = "Request processed successfully";

	public static final String RETURN_MESSAGE_AUTHENTICATION = "Successfully Authenticated";
	public static final String SUCCESSFULLY_REGISTERED = "Registration Successfully Requested";
	public static final String REGISTRATION_REQUEST_FAILED = "Registration request failed";
	public static final String REGISTRATION_APPROVAL_REQUEST_FAILED = "Registration approval request failed";
	public static final String REGISTRATION_REJECT_REQUEST_FAILED = "Registration reject request failed";
	public static final String RETRIEVE_PENDING_REQUEST_FAILED = "Obtaining pending registration requests failed";
	public static final String PENDING_REQUEST_RECEIVED = "Pending Requests Retrieved";
	public static final String LOGOUT_SUCCESSFULL = "Successfully Logged out";
	public static final String ERROR_LOGGEDOUT = "Error Logging out";
	public static final String REGISTRATION_APPROVAL_REQUEST_SUCCESS = "Registration approval request success";
	public static final String REGISTRATION_REJECT_REQUEST_SUCCESS = "Registration request rejected success";
	public static final String AUTHENTICATION_FAILED = "Authentication Failed";
	public static final String REGISTRATION_PENDING = "PENDING";
	public static final String REGSITRATION_REQUEST_APPROVED = "APPROVED";
	public static final String REGISTRATION_REQUEST_NEW = "ACCT_NEW";
	public static final int TOKEN_LENGTH = 25;
	public static final long TOKEN_MAX_LIFE = 2l * 24l * 60l * 60l * 1000l;
	public static final String APPROVED = "APPROVED";
	public static final String TOKEN_VERIFIED = "Token verification successful";
	public static final String TOKEN_VERIFICATION_FAILED = "Token verification failed";
	public static final String REGISTRATION_REQUEST_REJECTED = "REJECTED";
	public static final int VersionOne = 1;

	interface AddressType {
		public static final String PROJECT_ADDR = "PROJECT";
		public static final String COMPANY_ADDR = "COMPANY";
		public static final String CONTACT_ADDR = "CONTACT";
	}

	interface ProfileType {
		public static final String MENU_PROFILE = "MENU";
		public static final String PERMISSION_PROFILE = "PERMISSION";
	}

	/**
	 * Email Constants
	 */

	interface EmailServiceConstants {
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
	}

	public interface USER_STATUS {
		public static final int ACTIVE = 1;
		public static final int PENDING = 0;

	}

	public interface AccountStatus {
		public static final String ACTIVE = "ACTIVE";
		public static final String LOCKED = "LOCKED";
		public static final String ACCOUNT_INVITATION = "ACCT_INVITE";
		public static final String ACCT_NEW = "ACCT_NEW";
	}

	public interface RegistrationRequestStatus {
		public static final String PENDING = "PENDING";
		public static final String ACCT_INVITE = "ACCT_INVITE";
		public static final String ACCT_NEW = "ACCT_NEW";
		public static final String PROJECT_MEMBER_INVITE = "PROJECT_MEMBER_INVITE";
	}

	public interface CompanyStatus {
		public static final String STATUS = "ACTIVE";
	}

	public interface CostType {
		public static final String PLANNED = "PLANNED";
		public static final String ACTUAL = "ACTUAL";
	}

	public interface DocumentStatus {
		public static final String SUBMITTED = "SUBMITTED";
		public static final String APPROVED = "APPROVED";
		public static final String REJECTED = "REJECTED";
	}

	public interface ProjectStatus {
		public static final int ACTIVE = 1;
		public static final int PENDING = 0;
		public static final int DELETED = 2;
	}

	public interface TaskStatus {
		public static final int ACTIVE = 1;
		public static final int PENDING = 2;
		public static final int COMPLETED = 3;
		public static final int DELETED = 4;
	}

	public interface ProjectFileCommentStatus {
		public static final String ACTIVE = "ACTIVE";
		public static final String DELETED = "DELETED";
	}

	public interface MemberStatus {
		public static final String ACTIVE = "ACTIVE";
	}

	public interface TaskFieldWorkerStatus {
		public static final Integer ASSIGNED = new Integer(1);
		public static final Integer DELETED = new Integer(2);
	}

	public interface TaskCommentStatus {
		public static final String ACTIVE = "ACTIVE";
	}

	public interface TaskAssigneeStatus {
		public static final int ASSIGNED = 1;
		public static final int DELETED = 2;
	}

	public interface PhoneType {
		public static final String CELL = "CELL";
	}

	public interface PhoneStatus {
		public static final String ACTIVE = "ACTIVE";
	}

	public interface URL {
		public static final String forgotPasswordUrl = "/#/pages/reset-password";
		public static final String SIGNUP_URL = "/#/pages/signup";
		public static final String INVITE_TO_PROJECT_URL = "/#/pages/invite-to-project";
		public static final String VIEW_DOCUMENT_URL = "/#/app/onFile";
		public static final String TASK_URL = "#/app/onTime";
	}

	public interface UserNotificationStatus {
		public static final String NEW = "NEW";
		public static final String SEEN = "SEEN";
	}

	public interface FORGOT_PASSWORD {

		public static final String FORGOT_PASSWORD_ACTIVE = "ACTIVE";
		public static final String FORGOT_PASSWORD_EXPIRED = "EXPIRED";
	}

	public interface ProjectInfoType {
		public static final String BASE_PROJECT = "BASE_PROJECT";
		public static final String MAIN_PROJECT = "MAIN_PROJECT";
		public static final String PROJECT = "PROJECT";
		public static final String ACTIVITY = "ACTIVITY";
	}

	public interface ProjectFileStatus {
		public static final String ACTIVE = "ACTIVE";
		public static final String DELETED = "DELETED";
	}

	public interface ProjectTaskFileStatus {
		public static final String ACTIVE = "ACTIVE";
		public static final String DELETED = "DELETED";
	}

	public interface ProjectConfigurationConstant {
		public static final String unitOfMeasurement = "UNIT_OF_MEASUREMENT";
	}

	public static final String OPEN_RS_ENDPOINT = "/register,/user,/onTargetInvitation,/profile,"
			+ "/project/getProjectsByUser,/project/getUserProjectList,"
			+ "/company,/file,/hello,/timeCard/getFieldWorkers,/menuProfile,/permissionProfile,/uploadActivity,/profile/userProfileInfo";

	public static final double HOUR = 60 * 60 * 1000D;

	public interface ApplicationPermission {
		public static final String AUTHORIZED = "AUTHORIZED";
		public static final String UNAUTHORIZED = "UNAUTHORIZED";
	}

	public interface GenericStatus {
		public static final String ACTIVE = "ACTIVE";
		public static final String DELETED = "DELETED";
	}

	public interface DocumentAttachmentStatus {
		public static final String ACTIVE = "ACTIVE";
		public static final String DELETED = "DELETED";
	}

	public interface UserType {

		public static final String PROJECT_MANAGER = "PROJECT_MANAGER";
		public static final String SUPER_USER = "SUPER_USER";
		public static final String USER = "USER";
	}
}
