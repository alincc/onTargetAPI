package com.ontarget.api.mail;

import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;
import com.ontarget.util.EmailConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Map;

/**
 * Created by sanjeevghimire on 12/3/15.
 */
@Component("sendRegistrationEmail")
public class SendRegistrationEmail extends SendEmail {

    @Autowired
    @Qualifier("userInvitationJpaDAOImpl")
    private UserInvitationDAO userInvitationDAO;

    /**
     * Send request for demo approval email.
     * @throws Exception
     */
    @Override
    public void sendEmail(Map<String, Object> emailAttributes) throws Exception {

        try {
            MimeMessagePreparator preparator = new MimeMessagePreparator() {
                @SuppressWarnings({ "rawtypes", "unchecked" })
                public void prepare(MimeMessage mimeMessage) throws Exception {
                    MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

                    message.setFrom(new InternetAddress(OnTargetConstant.EmailServiceConstants.EMAIL_FROM));
                    message.setSubject(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_SUBJECT);
                    message.setSentDate(new Date());

                    Integer registratioinRequestId=(Integer)emailAttributes.get("registrationRequestId");

                    // get values from the database.
                    RegistrationRequestResponseDTO info = userInvitationDAO.findRegRequestById(registratioinRequestId);

                    message.setTo(info.getEmail());


                    emailAttributes.put(EmailConstant.EmailParameter.FIRST_NAME, info.getFirstName());
                    emailAttributes.put("signUpUrl", OnTargetConstant.URL.SIGNUP_URL + "?q=" + info.getRegistrationToken());

                    String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/registrationRequest.vm", "UTF-8",
                            emailAttributes);
                    message.setText(text, true);
                }
            };
            javaMailSender.send(preparator);
        } catch (Exception e) {
            logger.error("Not able to send request for demo approval email", e);
        }


    }


}
