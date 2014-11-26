package com.ontarget.api.service;

/**
 * Created by Owner on 11/2/14.
 */
public interface EmailService {

    public boolean sendUserRequestEmail(int userRequestId);

    public boolean sendUserRequestEmailToAdmin(int userRequestId);

    public boolean sendUserRegistrationEmail() throws Exception;

    //public boolean sendSubmittalEmailForApproval() throws Exception;

}
