package com.ontarget.api.mail;

import com.ontarget.bean.Contact;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.util.DateFormater;
import com.ontarget.util.EmailConstant;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

/**
 * Created by sanjeevghimire on 1/11/16.
 */
public class SendSubmittalAssignEmail extends SendEmail {


    public SendSubmittalAssignEmail(JavaMailSender javaMailSender, VelocityEngine velocityEngine, TaskExecutor taskExecutor) {
        super(javaMailSender, velocityEngine, taskExecutor);
    }

    @Override
    public void prepareEmailAttributes(Map<String, Object> emailAttributes) throws Exception {

        Contact assignee = (Contact) emailAttributes.get("assignee");
        Contact sender = (Contact)emailAttributes.get("sender");
        DocumentDTO document = (DocumentDTO) emailAttributes.get("document");

        String emailFrom = new StringBuilder().append(sender.getFirstName()).append(" ").append(sender.getLastName())
                .append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();

        emailAttributes.put("from",emailFrom);
        emailAttributes.put("to",assignee.getEmail());
        emailAttributes.put("subject",EmailConstant.EmailSubject.DOCUMENT_SUBMITTAL_SUBJECT);

        emailAttributes.put("documentTitle", document.getName());
        emailAttributes.put("assigneeFirstName", assignee.getFirstName());
        emailAttributes.put("assigneeLastName", assignee.getLastName());
        emailAttributes.put("creatorFirstName", sender.getFirstName());
        emailAttributes.put("creatorLastName", sender.getLastName());

        emailAttributes.put("dueDate", DateFormater.convertToString(new java.util.Date(document.getDueDate().getTime()), "yyyy-MM-dd"));
        emailAttributes.put("documentUrl", OnTargetConstant.URL.VIEW_DOCUMENT_URL);
        emailAttributes.put("emailTemplate", EmailConstant.Template.DOCUMENT_SUBMITTAL);
    }


}
