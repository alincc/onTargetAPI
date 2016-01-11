package com.ontarget.api.service.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.UserInvitationDAO;
import com.ontarget.api.mail.SendEmail;
import com.ontarget.api.mail.SendEmailFactory;
import com.ontarget.api.service.EmailService;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectTaskInfo;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entity.pojo.RegistrationRequestResponseDTO;
import com.ontarget.enums.TaskStatusEnum;
import com.ontarget.util.EmailConstant;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
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
/**
 * @author santosh
 *
 */
@Service
public class EmailServiceImpl implements EmailService {

	private Logger logger = Logger.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private VelocityEngine velocityEngine;

    @Autowired
    protected TaskExecutor taskExecutor;

	@Autowired
	@Qualifier("authenticationJpaDAOImpl")
	private AuthenticationDAO authenticationDAO;

	@Autowired
	@Qualifier("userInvitationJpaDAOImpl")
	private UserInvitationDAO registrationDAO;

	@Autowired
	@Qualifier("contactJpaDAOImpl")
	private ContactDAO contactDAO;

	@Value("${baseUIUrl}")
	private String baseUrl;

	@Value("${email.asset.server.url}")
	private String emailAssetServerUrl;

	@Value("${email.asset.construction.worker.image}")
	private String emailConstructionWorkerImage;

	@Value("${email.asset.task.percentage.image}")
	private String emailTaskPercentageImage;

	@Value("${email.asset.ontarget.logo.image}")
	private String emailOnTargetLogoImage;

	@Value("${email.asset.task.info.image}")
	private String emailTaskInfoImage;

	@Value("${email.asset.task.detail.image}")
	private String taskDetailImgUrl;

	@Value("${email.asset.task.dashboard.image}")
	private String taskDashboardImgUrl;

    @Value("${email.asset.ipadscreen.mockup.image}")
    private String ipadScreenMockup;

	/**
	 * Email after the request for demo is approved
	 * 
	 * @param userRequestId
	 * @return
	 */
	@Override
	public boolean sendInvitationEmailForRegistration(int userRequestId) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

					message.setFrom(new InternetAddress(OnTargetConstant.EmailServiceConstants.EMAIL_FROM));
					message.setSubject(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_SUBJECT);
					message.setSentDate(new Date());

					// get values from the database.
					RegistrationRequestResponseDTO info = registrationDAO.findRegRequestById(userRequestId);

					message.setTo(info.getEmail());

					Map model = getDefaultMapProperties(new HashMap());
					model.put(EmailConstant.EmailParameter.FIRST_NAME, info.getFirstName());
					model.put("url", baseUrl + OnTargetConstant.URL.SIGNUP_URL + "?q=" + info.getRegistrationToken());

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/registrationRequest.vm", "UTF-8",
							model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Not able to send assigneeUser request email", e);
		}

		return true;
	}

	private Map getDefaultMapProperties(Map model) {
        model.put("constructionWorkerImgUrl", emailAssetServerUrl + "/" + emailConstructionWorkerImage);
        model.put("ontargetLogoImgUrl", emailAssetServerUrl + "/" + emailOnTargetLogoImage);
        model.put("baseUrl", baseUrl);
        model.put("ontargetUrl", baseUrl);
        model.put("appLink", EmailConstant.APP_LINK);
        model.put("emailConstructionWorkerImage",emailAssetServerUrl + "/" +emailConstructionWorkerImage);
        model.put("emailTaskPercentageImage",emailAssetServerUrl + "/" +emailTaskPercentageImage);
        model.put("emailOnTargetLogoImage",emailAssetServerUrl + "/" +emailOnTargetLogoImage);
        model.put("emailTaskInfoImage",emailAssetServerUrl + "/" +emailTaskInfoImage);
        model.put("taskDetailImgUrl",emailAssetServerUrl + "/" +taskDetailImgUrl);
        model.put("taskDashboardImgUrl",emailAssetServerUrl + "/" +taskDashboardImgUrl);
        model.put("ipadScreenMockup",emailAssetServerUrl +"/"+ipadScreenMockup);
		return model;
	}

	/**
	 * Send task status change email to assignee.
	 * 
	 * @param task
	 * @param assigneeUserId
	 */

	@Override
	public void sendTaskStatusChangeEmail(ProjectTaskInfo task, int assigneeUserId) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {

					UserDTO assigneeUser = authenticationDAO.getUserResponse(assigneeUserId);
					assigneeUser.setContact(getContactDetails(assigneeUser.getUserId()));

                    Contact sender = getContactDetails(task.getModifierId());

                    String emailFrom = new StringBuilder().append(sender.getFirstName()).append(" ").append(sender.getLastName())
                            .append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();

					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setFrom(new InternetAddress(emailFrom));
					message.setTo(assigneeUser.getContact().getEmail());
					message.setSubject(OnTargetConstant.EmailServiceConstants.TASK_STATUS_SUBJECT);
					message.setSentDate(new Date());

					Map model = getDefaultMapProperties(new HashMap());
					model.put("assignee", assigneeUser);
					model.put("task", task);
					model.put("taskStatus", TaskStatusEnum.getStatusTextByStatus(Integer.parseInt(task.getStatus())));
					model.put("modifier", sender);
					model.put("creator", getContactDetails(task.getCreatorId()));
					model.put("taskPercentageImgUrl", emailAssetServerUrl + "/" + emailTaskPercentageImage);
                    model.put("taskLink", baseUrl + OnTargetConstant.URL.TASK_URL + "?activityId=" + task.getProjectId() + "&taskId="
                            + task.getProjectTaskId());

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/taskStatusChangedEmail.vm",
							"UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending email for task.", e);
		}
	}

	private Contact getContactDetails(int userId) throws Exception {
		return contactDAO.getContact(userId);
	}

	/**
	 * Send task comment email to assignee.
	 * 
	 * @param task
	 * @param assigneeUserId
	 */

	@Override
	public void sendTaskCommentEmail(ProjectTaskInfo task, Contact commentedBy, int assigneeUserId) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {

					UserDTO assigneeUser = authenticationDAO.getUserResponse(assigneeUserId);
					assigneeUser.setContact(getContactDetails(assigneeUser.getUserId()));

                    Contact sender = getContactDetails(task.getCreatorId());

                    String emailFrom = new StringBuilder().append(sender.getFirstName()).append(" ").append(sender.getLastName())
                            .append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();

					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(assigneeUser.getContact().getEmail());
                    message.setFrom(new InternetAddress(emailFrom));
					message.setSubject(OnTargetConstant.EmailServiceConstants.TASK_COMMENT_SUBJECT);
					message.setSentDate(new Date());

					Map model = getDefaultMapProperties(new HashMap());
					model.put("assignee", assigneeUser);
					model.put("task", task);
					model.put("commentor", commentedBy);
					model.put("creator", sender);
					model.put("taskDetailImgUrl", emailAssetServerUrl + "/" + emailTaskPercentageImage);
                    model.put("taskLink", baseUrl + OnTargetConstant.URL.TASK_URL + "?activityId=" + task.getProjectId() + "&taskId="
                            + task.getProjectTaskId());

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/taskComment.vm", "UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending email for task.", e);
		}
	}

	/**
	 * Send task attachment email to assignee.
	 * 
	 * @param task
	 * @param assigneeUserId
	 */

	@Override
	public void sendTaskAttachmentEmail(ProjectTaskInfo task, Contact attachmentDoneBy, int assigneeUserId) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {

					UserDTO assigneeUser = authenticationDAO.getUserResponse(assigneeUserId);
					assigneeUser.setContact(getContactDetails(assigneeUser.getUserId()));

                    Contact sender = getContactDetails(task.getCreatorId());

                    String emailFrom = new StringBuilder().append(sender.getFirstName()).append(" ").append(sender.getLastName())
                            .append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();

					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(assigneeUser.getContact().getEmail());
                    message.setFrom(new InternetAddress(emailFrom));
					message.setSubject(OnTargetConstant.EmailServiceConstants.FORGOT_PASSWORD_SUBJECT);
					message.setSentDate(new Date());

					Map model = getDefaultMapProperties(new HashMap());
					model.put("assignee", assigneeUser);
					model.put("task", task);
					model.put("commentor", attachmentDoneBy);
					model.put("creator", sender);
					model.put("taskDashboardImgUrl", emailAssetServerUrl + "/" + taskDashboardImgUrl);
                    model.put("taskLink", baseUrl + OnTargetConstant.URL.TASK_URL + "?activityId=" + task.getProjectId() + "&taskId="
                            + task.getProjectTaskId());

					String text = VelocityEngineUtils
							.mergeTemplateIntoString(velocityEngine, "/template/taskAttachment.vm", "UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending email for task.", e);
		}
	}

	/**
	 * Request for demo email to Admin for approval.
	 *
	 * @return
	 */
	@Override
	public boolean sendUserRequestEmailToAdmin() {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(OnTargetConstant.EmailServiceConstants.USER_REGISTRATION_ADMIN_EMAIL);
					message.setFrom(new InternetAddress(OnTargetConstant.EmailServiceConstants.EMAIL_FROM));
					message.setSubject(OnTargetConstant.EmailServiceConstants.ONBOARDING_TO_ONTARGET_SUBJECT);
					message.setSentDate(new Date());

					Map model = new HashMap();

					model.put("url", baseUrl + OnTargetConstant.EmailServiceConstants.REQUEST_FOR_DEMO_APPROVE_URL);

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
							"/template/requestForDemoApprovalEmailToAdmin.vm", "UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending assigneeUser request email to admin", e);
		}

		return true;
	}

	/**
	 * Invite to collaborate email.
	 * 
	 * @param userEmail
	 * @param tokenId
	 * @param receiverFirstName
	 * @param senderFirstName
	 * @param senderLastName
	 * @return
	 */
	@Override
	public boolean sendUserRegistrationEmail(String userEmail, String tokenId,  String receiverFirstName, String senderFirstName,
			String senderLastName, String projectName) {
		try {

			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(userEmail);

					String emailFrom = new StringBuilder().append(senderFirstName).append(" ").append(senderLastName)
							.append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();
					message.setFrom(new InternetAddress(emailFrom));
					message.setSubject(OnTargetConstant.EmailServiceConstants.USER_INVITE_TO_COLLABORATE);
					message.setSentDate(new Date());

					Map model = new HashMap();
					if (senderFirstName != null && senderFirstName.trim().length() > 0) {
						model.put("senderName", senderFirstName + " " + senderLastName);
					} else {
						model.put("senderName", OnTargetConstant.EmailServiceConstants.EMAIL_FROM);
					}


					model.put("receiverFirstName", OnTargetConstant.EmailServiceConstants.DEFAULT_NAME);
					model.put("url", baseUrl + OnTargetConstant.URL.SIGNUP_URL + "?q=" + tokenId);
					model.put("projectName", projectName);

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/registrationRequestsApproval.vm",
							"UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Unable to send assigneeUser registration email.", e);
		}

		return true;
	}

	/**
	 * Invite user into project email.
	 * 
	 * @param userEmail
	 * @param tokenId
	 * @param receiverFirstName
	 * @param senderFirstName
	 * @param senderLastName
	 * @return
	 */
	@Override
	public boolean sendInviteUserToProjectEmail(String userEmail, String tokenId, String receiverFirstName, String senderFirstName,
			String senderLastName, String projectName) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(userEmail);

					logger.debug("sender first name: " + senderFirstName);
					logger.debug("sender last name: " + senderLastName);

					String emailFrom = new StringBuilder().append(senderFirstName).append(" ").append(senderLastName)
							.append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();
					message.setFrom(new InternetAddress(emailFrom));
					message.setSubject(OnTargetConstant.EmailServiceConstants.USER_INVITE_TO_COLLABORATE);
					message.setSentDate(new Date());

					Map model = getDefaultMapProperties(new HashMap());
					if (senderFirstName != null && senderFirstName.trim().length() > 0) {
						model.put("senderName", senderFirstName + " " + senderLastName);
					} else {
						model.put("senderName", OnTargetConstant.EmailServiceConstants.EMAIL_FROM);
					}
					model.put("receiverFirstName", receiverFirstName);
					model.put("url", baseUrl + OnTargetConstant.URL.INVITE_TO_PROJECT_URL + "?q=" + tokenId);
					model.put("project", projectName);

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/inviteUserIntoProject.vm",
							"UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Unable to send assigneeUser registration email.", e);
		}

		return true;
	}



	@Override
	public void sendTaskAssignmentEmail(ProjectTaskInfo task, Contact contact) throws Exception {

		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {

					UserDTO assigneeUser = authenticationDAO.getUserResponse(contact.getUser().getUserId());
					assigneeUser.setContact(getContactDetails(assigneeUser.getUserId()));

					logger.debug("creator id: " + task.getCreatorId());
					Contact sender = getContactDetails(task.getCreatorId());

                    String emailFrom = new StringBuilder().append(sender.getFirstName()).append(" ").append(sender.getLastName())
                            .append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();


					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                    message.setFrom(new InternetAddress(emailFrom));
					message.setTo(assigneeUser.getContact().getEmail());
					message.setSubject(OnTargetConstant.EmailServiceConstants.TASK_ASSIGNED_SUBJECT);
					message.setSentDate(new Date());

					Map model = getDefaultMapProperties(new HashMap());
					model.put("assignee", assigneeUser);
					model.put("task", task);
					model.put("sender", sender);
					model.put("taskInfoImageImgUrl", emailAssetServerUrl + emailTaskInfoImage);
					model.put("taskLink", baseUrl + OnTargetConstant.URL.TASK_URL + "?activityId=" + task.getProjectId() + "&taskId="
							+ task.getProjectTaskId());

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/taskAssignedEmail.vm", "UTF-8",
							model);

					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending email for task.", e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ontarget.api.service.EmailService#sendForgotPasswordEmail(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	@Override
	public void sendForgotPasswordEmail(final String emailAddress, final String name, final String forgotPasswordToken) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
					message.setTo(emailAddress);
					message.setFrom(new InternetAddress(OnTargetConstant.EmailServiceConstants.EMAIL_FROM));
					message.setSubject(OnTargetConstant.EmailServiceConstants.FORGOT_PASSWORD_SUBJECT);
					message.setSentDate(new Date());

					Map model = new HashMap();
					model.put("forgotPasswordEmailUrl", baseUrl + OnTargetConstant.URL.forgotPasswordUrl + "?q=" + forgotPasswordToken);
					model.put("personName", name);

					String text = VelocityEngineUtils
							.mergeTemplateIntoString(velocityEngine, "/template/forgotPassword.vm", "UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending forgot password email.", e);
		}

	}

	/**
	 * Document status update email
	 * 
	 * @param documentTitle
	 * @param updatedStatus
	 * @param assigneeFirstName
	 * @param assigneeLastName
	 * @param assigneeEmail
	 * @param modifierFirstName
	 * @param modifierLastName
	 * @return
	 */
	@Override
	public void sendDocumentStatusUpdateEmail(String documentTitle, String updatedStatus, String assigneeFirstName,
                                              String assigneeLastName, String assigneeEmail, String modifierFirstName, String modifierLastName) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                    String emailFrom = new StringBuilder().append(modifierFirstName).append(" ").append(modifierLastName)
                            .append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();

					message.setFrom(new InternetAddress(emailFrom));
					message.setTo(assigneeEmail);
					message.setSubject(OnTargetConstant.EmailServiceConstants.DOCUMENT_STATUS_UPDATE_SUBJECT);
					message.setSentDate(new Date());

					Map model = getDefaultMapProperties(new HashMap());
					model.put("documentTitle", documentTitle);
					model.put("status", updatedStatus);
					model.put("assigneeFirstName", assigneeFirstName);
					model.put("assigneeLastName", assigneeLastName);
					model.put("modifierFirstName", modifierFirstName);
					model.put("modifierLastName", modifierLastName);

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/template/documentStatusUpdateEmail.vm",
							"UTF-8", model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending email for document status update.", e);
		}
	}

	@Override
	public void sendDocumentSubmittalEmail(String documentTitle, String assigneeEmail, String assigneeFirstName, String assigneeLastName,
			String creatorFirstName, String creatorLastName,String dueDate) {
		try {
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@SuppressWarnings({ "rawtypes", "unchecked" })
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                    String emailFrom = new StringBuilder().append(creatorFirstName).append(" ").append(creatorLastName)
                            .append(OnTargetConstant.EmailServiceConstants.DO_NOT_REPLY_EMAIL).toString();

                    message.setFrom(new InternetAddress(emailFrom));
					message.setTo(assigneeEmail);
					message.setSubject(OnTargetConstant.EmailServiceConstants.DOCUMENT_SUBMITTAL_SUBJECT);
					message.setSentDate(new Date());

					Map model = getDefaultMapProperties(new HashMap());
					model.put("documentTitle", documentTitle);
					model.put("assigneeFirstName", assigneeFirstName);
					model.put("assigneeLastName", assigneeLastName);
					model.put("creatorFirstName", creatorFirstName);
					model.put("creatorLastName", creatorLastName);
					model.put("dueDate", dueDate);
					model.put("documentUrl", baseUrl + OnTargetConstant.URL.VIEW_DOCUMENT_URL);

					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "template/documentSubmittal.vm", "UTF-8",
							model);
					message.setText(text, true);
				}
			};
			javaMailSender.send(preparator);
		} catch (Exception e) {
			logger.error("Error while sending email for document submittal.", e);
		}
	}


    @Override
    public void sendEmail(Map<String, Object> emailAttributes) throws  Exception{
        SendEmail sendEmail = SendEmailFactory.getSendEmailObject((String)emailAttributes.get("emailType"),javaMailSender, velocityEngine, taskExecutor);
        sendEmail.prepareEmailAttributes(emailAttributes);
        sendEmail.sendAsynchronousMail(getDefaultMapPropertiesAsObj(emailAttributes));
    }


    /**
     * default map properties
     * @return
     */
    private Map<String, Object> getDefaultMapPropertiesAsObj(Map<String, Object> emailAttributes) {
        emailAttributes.put("constructionWorkerImgUrl", emailAssetServerUrl + "/" + emailConstructionWorkerImage);
        emailAttributes.put("ontargetLogoImgUrl", emailAssetServerUrl + "/" + emailOnTargetLogoImage);
        emailAttributes.put("baseUrl", baseUrl);
        emailAttributes.put("ontargetUrl", baseUrl);
        emailAttributes.put("appLink", EmailConstant.APP_LINK);
        emailAttributes.put("emailConstructionWorkerImage",emailAssetServerUrl + "/" +emailConstructionWorkerImage);
        emailAttributes.put("emailTaskPercentageImage",emailAssetServerUrl + "/" +emailTaskPercentageImage);
        emailAttributes.put("emailOnTargetLogoImage",emailAssetServerUrl + "/" +emailOnTargetLogoImage);
        emailAttributes.put("emailTaskInfoImage",emailAssetServerUrl + "/" +emailTaskInfoImage);
        emailAttributes.put("taskDetailImgUrl",emailAssetServerUrl + "/" +taskDetailImgUrl);
        emailAttributes.put("taskDashboardImgUrl",emailAssetServerUrl + "/" +taskDashboardImgUrl);
        return emailAttributes;
    }



}
