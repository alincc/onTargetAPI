package com.ontarget.api.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.ActivityDAO;
import com.ontarget.api.dao.NotificationMessageDAO;
import com.ontarget.api.notification.message.composer.Message;
import com.ontarget.api.notification.message.composer.MessageComposer;
import com.ontarget.api.notification.message.composer.MessageFactory;
import com.ontarget.api.notification.message.composer.MessageTemplateConfig;
import com.ontarget.bean.ActivityLog;
import com.ontarget.dto.ActivityLogDTO;
import com.ontarget.entities.ActivityLogAttribute;
import com.ontarget.entities.User;
import com.ontarget.util.NotificationUtil;

/**
 * Created by sumit on 12/6/14.
 */
@Service
public class ActivityLogServiceImpl implements com.ontarget.api.service.ActivityLogService {

	@Autowired
	@Qualifier("activityJpaDAOImpl")
	private ActivityDAO activityDAO;
	@Autowired
	private NotificationMessageDAO notificationMessageDAO;
	@Autowired
	private MessageTemplateConfig notificationTemplateConfig;

	@Override
	public ActivityLogDTO getActivityLog(int pageNumber, int perPageLimit, int projectId) throws Exception {
		Page<com.ontarget.entities.ActivityLog> activityLogList = activityDAO.getActivityLogList(pageNumber, perPageLimit, projectId);

		ActivityLogDTO activityLogDTO = new ActivityLogDTO();
		List<ActivityLog> activityLogs = new LinkedList<>();

		String formattedMessage = "";
		if (activityLogList != null && activityLogList.getTotalPages() > 0) {
			for (com.ontarget.entities.ActivityLog activity : activityLogList) {
				ActivityLog activityLog = new ActivityLog();
				activityLog.setActivityLogId(activity.getActivityLogId());
				activityLog.setTsInsert(activity.getTsInsert().getTime());
				activityLog.setActivityType(activity.getActivityType());
				activityLog.setUserImage("N/A");
				User user = activity.getUser();

				String userImage = "";
				if (user != null) {
					if (user.getContactList() != null && !user.getContactList().isEmpty()) {
						if (user.getContactList().get(0).getContactImage() != null) {
							userImage = user.getContactList().get(0).getContactImage();
						}
					}
				}
				if (userImage != null & userImage.trim().length() > 0) {
					activityLog.setUserImage(userImage);
				}

				List<ActivityLogAttribute> activityLogAttributes = activity.getActivityLogAttributeList();

				MessageComposer messageComposer = MessageFactory.getMessageComposer(NotificationUtil.getActivityType(
						activity.getActivityType(), activity.getAction()));
				if (messageComposer != null) {
					Message notificationMessage = messageComposer.getMessage(
							NotificationUtil.getActivityKeyValueMap(activityLogAttributes), notificationMessageDAO,
							notificationTemplateConfig);
					formattedMessage = notificationMessage.getMessage();
				} else {
					continue;
				}
				activityLog.setText(formattedMessage);
				activityLog.setAction(activity.getAction());

				activityLogs.add(activityLog);
			}
		}
		activityLogDTO.setTotalActivity(activityLogList.getTotalElements());
		activityLogDTO.setActivityLogList(activityLogs);
		return activityLogDTO;
	}
}
