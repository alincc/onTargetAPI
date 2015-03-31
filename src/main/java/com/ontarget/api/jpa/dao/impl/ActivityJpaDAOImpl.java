package com.ontarget.api.jpa.dao.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ActivityDAO;
import com.ontarget.api.repository.ActivityLogRepository;
import com.ontarget.bean.ActivityLog;

@Repository("activityJpaDAOImpl")
public class ActivityJpaDAOImpl implements ActivityDAO {
	@Resource
	private ActivityLogRepository activityLogRepository;

	@Override
	public List<ActivityLog> getActivityLog(long recentId) throws Exception {
		List<ActivityLog> activityLogs = new LinkedList<ActivityLog>();

		List<com.ontarget.entities.ActivityLog> activities = activityLogRepository.findByIdGreaterThan(recentId);

		if (activities != null && !activities.isEmpty()) {
			for (com.ontarget.entities.ActivityLog activity : activities) {
				ActivityLog activityLog = new ActivityLog();
				activityLog.setCategory(activity.getCategory().longValue());
				activityLog.setId(activity.getId());
				activityLog.setTsInsert(activity.getTsInsert().getTime());
				activityLog.setText(activity.getText());
				activityLogs.add(activityLog);
			}
		}

		return activityLogs;
	}

}
