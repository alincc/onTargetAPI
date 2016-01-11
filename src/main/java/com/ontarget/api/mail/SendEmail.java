package com.ontarget.api.mail;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Map;

/**
 * Created by sanjeevghimire on 12/3/15.
 */
public abstract class SendEmail implements ISendEmail{

    protected Logger logger = Logger.getLogger(SendEmail.class);

    protected JavaMailSender javaMailSender;

    protected VelocityEngine velocityEngine;

    protected TaskExecutor taskExecutor;

    public SendEmail(JavaMailSender javaMailSender, VelocityEngine velocityEngine, TaskExecutor taskExecutor) {
        this.javaMailSender=javaMailSender;
        this.velocityEngine=velocityEngine;
        this.taskExecutor=taskExecutor;
    }


    /**
     * Send asynchronous email.
     * @throws Exception
     */
    @Override
    public void sendAsynchronousMail(final Map<String, Object> emailAttributes) throws Exception {
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
    public void sendEmail(final Map<String, Object> emailAttributes) throws Exception {

        try {
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @SuppressWarnings({ "rawtypes", "unchecked" })
                public void prepare(MimeMessage mimeMessage) throws Exception {

                    String emailFrom = (String)emailAttributes.get("from");
                    String emailTo = (String)emailAttributes.get("to");
                    String subject = (String)emailAttributes.get("subject");

                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                    message.setFrom(new InternetAddress(emailFrom));
                    message.setTo(emailTo);
                    message.setSubject(subject);
                    message.setSentDate(new Date());

                    String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/taskAssignedEmail.vm", "UTF-8",
                            emailAttributes);
                    message.setText(text, true);
                }
            };
            javaMailSender.send(preparator);
        } catch (Exception e) {
            logger.error("Error while sending email for task.", e);
        }

    }


    public abstract void prepareEmailAttributes(Map<String, Object> emailAttributes) throws Exception;


}
