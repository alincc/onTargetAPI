package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.Document;
import com.ontarget.bean.User;

/**
 * Created by Owner on 11/2/14.
 */
public interface EmailService {

    public boolean sendUserRequestEmail(int userRequestId);

    public boolean sendUserRequestEmailToAdmin(int userRequestId);

    public boolean sendUserRegistrationEmail() throws Exception;

    public boolean sendDocumentAssignmentEmails(Document document, List<User> assignees);
    //public boolean sendSubmittalEmailForApproval() throws Exception;

}
