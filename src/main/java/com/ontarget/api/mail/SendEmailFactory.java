package com.ontarget.api.mail;

import com.ontarget.util.EmailConstant;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;

/**
 * Created by sanjeevghimire on 1/11/16.
 */
public class SendEmailFactory {

    private static  Logger logger = Logger.getLogger(SendEmailFactory.class);

    public static SendEmail getSendEmailObject(String emailType, JavaMailSender javaMailSender, VelocityEngine velocityEngine, TaskExecutor taskExecutor){
        logger.debug("Object for email type: "+ emailType);
        if(EmailConstant.SendEmailType.REQUEST_FOR_DEMO_APPROVED.equals(emailType)){
            return new SendRegistrationEmail(javaMailSender,velocityEngine,taskExecutor);
        }else if(EmailConstant.SendEmailType.TASK_ASSIGNMENT.equals(emailType)) {
            return new SendTaskAssignmentEmail(javaMailSender,velocityEngine,taskExecutor);
        }else{
            throw new UnsupportedOperationException("Email type not found ::"+ emailType);
        }
    }

}
