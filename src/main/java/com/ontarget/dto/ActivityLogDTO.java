package com.ontarget.dto;

import java.io.Serializable;
import java.util.List;

import com.ontarget.bean.ActivityLog;

public class ActivityLogDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private long totalActivity;
	private List<ActivityLog> activityLogList;

	public long getTotalActivity() {
		return totalActivity;
	}

	public void setTotalActivity(long totalActivity) {
		this.totalActivity = totalActivity;
	}

	public List<ActivityLog> getActivityLogList() {
		return activityLogList;
	}

	public void setActivityLogList(List<ActivityLog> activityLogList) {
		this.activityLogList = activityLogList;
	}

}
