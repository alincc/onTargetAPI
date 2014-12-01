package com.ontarget.api.service.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.service.EmailService;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Owner on 11/2/14.
 */
@Service
public class EmailServiceImpl implements EmailService {

    private Logger logger = Logger.getLogger(EmailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private VelocityEngine velocityEngine;

    @Autowired
    private AuthenticationDAO authenticationDAO;


    @Override
    public boolean sendUserRequestEmail(int userRequestId) {
        try {
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @SuppressWarnings({"rawtypes", "unchecked"})
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

                    message.setFrom(new InternetAddress(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_FROM));
                    message.setSubject(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_SUBJECT);
                    message.setSentDate(new Date());

                    //get values from the database.
                    UserRegistrationRequest info = authenticationDAO.getUserRegistrationRequestInfo(userRequestId);

                    message.setTo(info.getEmail());

                    Map model = new HashMap();
                    model.put("userRegistrationInfo", info);

                    String text = VelocityEngineUtils.mergeTemplateIntoString(
                            velocityEngine, "/template/userRegistrationRequestEmail.vm", "UTF-8", model);
                    message.setText(text, true);
                }
            };
            javaMailSender.send(preparator);
        }catch(Exception e){
            logger.error("Not able to send user request email",e);
            return false;
        }

        return true;
    }

    @Override
    public boolean sendUserRequestEmailToAdmin(int userRequestId) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @SuppressWarnings({ "rawtypes", "unchecked" })
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_ADMIN_EMAIL);
                message.setFrom(new InternetAddress(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_FROM) );
                message.setSubject(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_REQUEST_APPROVAL_SUBJECT);
                message.setSentDate(new Date());

                //get values from the database.
                UserRegistrationRequest info = authenticationDAO.getUserRegistrationRequestInfo(userRequestId);

                Map model = new HashMap();
                model.put("userRegistrationInfo", info);
                model.put("approvalUrl", "");

                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, "/template/userRegistrationRequestInfoEmail.vm", "UTF-8", model);
                message.setText(text, true);
            }
        };
        javaMailSender.send(preparator);

        return true;
    }

    @Override
    public boolean sendUserRegistrationEmail(String userEmail, String tokenId, String receiverFirstName, String senderFirstName, String senderLastName) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @SuppressWarnings({"rawtypes", "unchecked"})
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setTo(userEmail);
                message.setFrom(new InternetAddress(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_FROM));
                message.setSubject(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_REQUEST_APPROVAL_SUBJECT);
                message.setSentDate(new Date());

                Map model = new HashMap();
                model.put("senderName", senderFirstName + " " + senderLastName);
                model.put("receiverFirstName", receiverFirstName);
                model.put("url", "http://localhost:8080/");

                String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/registrationRequestsApproval.vm", "UTF-8", model);
                message.setText(text, true);
            }
        };
        javaMailSender.send(preparator);

        return true;
    }

}
