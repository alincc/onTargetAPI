package com.ontarget.util;

public class WSResourceKeyConstant {

	public static final String ONTARGET_INVITATION = "/onTargetInvitation";
	public static final String INVITE_TO_NEW_ACCOUNT = "/inviteToNewAccount";
	public static final String PENDING_REGISTRATION_REQUEST = "/pendingRegistrationRequest";
	public static final String REGISTRATION_APPROVAL_REQUEST = "/approvalRequest";
	public static final String VALIDATE_LINK_REQUEST = "/validateLink";

	// onTargetInvitation/inviteToNewAccount
	// onTargetInvitation/pendingRegistrationRequest
	// onTargetInvitation/approvalRequest?id=id
	// onTargetInvitation/validateLink?q=token

	// http://localhost:8080/ontargetrs/services/onTargetInvitation/pendingRegistrationRequest
	/*
	 * http://localhost:8080/ontargetrs/services/onTargetInvitation/
	 * inviteToNewAccountapplication/json { "firstName": "Santosh3", "lastName":
	 * "Pun3", "email": "santosh8pun@gmail.com", "phoneNumber": "9808639594",
	 * "msg": "I would like to request for a demo" }
	 */

	/**
	 * http://localhost:8080/ontargetrs/services/onTargetInvitation/
	 * approvalRequest?id=43
	 */

}
