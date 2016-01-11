package com.ontarget.api.mail;

import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.util.EmailConstant;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

/**
 * Created by sanjeevghimire on 1/10/16.
 */
public class SendTaskAssignmentEmail extends SendEmail {

    public SendTaskAssignmentEmail(JavaMailSender javaMailSender, VelocityEngine velocityEngine, TaskExecutor taskExecutor) {
        super(javaMailSender, velocityEngine, taskExecutor);
    }

    @Override
    public void prepareEmailAttributes(Map<String, Object> emailAttributes) throws Exception {
        Contact assignee = (Contact) emailAttributes.get("assigneeUser");
        ProjectTaskInfo task = (ProjectTaskInfo) emailAttributes.get("task");
        logger.debug("creator id: " + task.getCreatorId());
        Contact sender = (Contact)emailAttributes.get("sender");
        String emailFrom = new StringBuilder().append(sender.getFirstName()).append(" ").append(sender.getLastName()).append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();
        emailAttributes.put("from", emailFrom);
        emailAttributes.put("to", assignee.getEmail());
        emailAttributes.put("subject", EmailConstant.EmailSubject.TASK_ASSIGNED_SUBJECT);
        emailAttributes.put("assignee", assignee);
        emailAttributes.put("task", task);
        emailAttributes.put("sender", sender);
        emailAttributes.put("taskLink", new StringBuffer().append(OnTargetConstant.URL.TASK_URL).append("?activityId=").append(task.getProjectId()).append("&taskId=").append(task.getProjectTaskId()).toString());
        emailAttributes.put("emailTemplate", EmailConstant.Template.TASK_ASSIGNMENT);

    }
}
