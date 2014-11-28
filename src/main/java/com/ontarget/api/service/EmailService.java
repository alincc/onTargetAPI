package com.ontarget.api.service;

/**
 * Created by Owner on 11/2/14.
 */
public interface EmailService {

    public boolean sendUserRequestEmail(int userRequestId);

    public boolean sendUserRequestEmailToAdmin(int userRequestId);

    public boolean sendUserRegistrationEmail(String userEmail, String tokenId, String receiverFirstName, String senderFirstName, String senderLastName) throws Exception;
}
