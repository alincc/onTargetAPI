package com.ontarget.api.mail;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;
import com.ontarget.util.EmailConstant;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

/**
 * Created by sanjeevghimire on 12/3/15.
 */
@Configurable
public class SendRegistrationEmail extends SendEmail {

    public SendRegistrationEmail(JavaMailSender javaMailSender, VelocityEngine velocityEngine, TaskExecutor taskExecutor) {
        super(javaMailSender,velocityEngine,taskExecutor);
    }

    @Override
    public void prepareEmailAttributes(Map<String, Object> emailAttributes) throws Exception {
        RegistrationRequestResponseDTO info=(RegistrationRequestResponseDTO)emailAttributes.get("registrationRequestInfo");
        emailAttributes.put("from",OnTargetConstant.EmailServiceConstants.EMAIL_FROM);
        emailAttributes.put("to",info.getEmail());
        emailAttributes.put("subject",EmailConstant.EmailSubject.USER_REGISTRATION_SUBJECT);
        emailAttributes.put(EmailConstant.EmailParameter.FIRST_NAME, info.getFirstName());
        emailAttributes.put("signUpUrl", OnTargetConstant.URL.SIGNUP_URL + "?q=" + info.getRegistrationToken());
        emailAttributes.put("emailTemplate", EmailConstant.Template.REGISTRATION_REQUEST);
    }


}
