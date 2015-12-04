package com.ontarget.api.mail;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by sanjeevghimire on 12/3/15.
 */
@Component
public class SendEmail implements ISendEmail{

    protected Logger logger = Logger.getLogger(SendEmail.class);

    @Autowired
    protected JavaMailSender javaMailSender;

    @Autowired
    protected VelocityEngine velocityEngine;

    @Autowired
    protected TaskExecutor taskExecutor;


    /**
     * Send asynchronous email.
     * @throws Exception
     */
    public void sendAsynchronousMail(Map<String, Object> emailAttributes) throws Exception {
        taskExecutor.execute( new Runnable() {
            public void run() {
                try {
                    sendEmail(emailAttributes);
                } catch (Exception e) {
                    logger.error("Failed to send email to: ",e);
                }
            }
        });
    }

    @Override
    public void sendEmail(Map<String, Object> emailAttributes) throws Exception {

    }
}
