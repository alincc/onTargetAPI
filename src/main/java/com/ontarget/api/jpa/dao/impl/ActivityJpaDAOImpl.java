package com.ontarget.api.jpa.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ActivityDAO;
import com.ontarget.api.repository.ActivityLogRepository;
import com.ontarget.bean.ActivityLog;
import com.ontarget.dto.ActivityLogDTO;
import com.ontarget.entities.User;

@Repository("activityJpaDAOImpl")
public class ActivityJpaDAOImpl implements ActivityDAO {
	@Resource
	private ActivityLogRepository activityLogRepository;

	@Override
	public ActivityLogDTO getActivityLog(int pageNumber, int perPageLimit, int projectId) throws Exception {

		Pageable pageable = new PageRequest(pageNumber - 1, perPageLimit);
		Page<com.ontarget.entities.ActivityLog> activityLogList = activityLogRepository.findActivityLogsByProjectId(
				projectId, pageable);

		ActivityLogDTO activityLogDTO = new ActivityLogDTO();
		List<ActivityLog> activityLogs = new LinkedList<>();

		if (activityLogList != null && activityLogList.getTotalPages() > 0) {
			for (com.ontarget.entities.ActivityLog activity : activityLogList) {
				ActivityLog activityLog = new ActivityLog();
				activityLog.setCategory(activity.getCategory().longValue());
				activityLog.setId(activity.getId());
				activityLog.setTsInsert(activity.getTsInsert().getTime());
				activityLog.setText(activity.getText());
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
				activityLogs.add(activityLog);
			}
		}
		activityLogDTO.setTotalActivity(activityLogList.getTotalElements());
		activityLogDTO.setActivityLogList(activityLogs);
		return activityLogDTO;
	}
}
