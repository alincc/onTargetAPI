package com.ontarget.dto;

import com.ontarget.bean.ActivityLog;

import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
public class ActivityLogResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private long totalActivity;
	private List<ActivityLog> logs;

	public long getTotalActivity() {
		return totalActivity;
	}

	public void setTotalActivity(long totalActivity) {
		this.totalActivity = totalActivity;
	}

	public List<ActivityLog> getLogs() {
		return logs;
	}

	public void setLogs(List<ActivityLog> logs) {
		this.logs = logs;
	}
}
