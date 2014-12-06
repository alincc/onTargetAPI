package com.ontarget.dto;

import com.ontarget.bean.ActivityLog;

import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
public class ActivityLogResponse extends OnTargetResponse {

    private long recentActivityId;
    private List<ActivityLog> logs;

    public long getRecentActivityId() {
        return recentActivityId;
    }

    public void setRecentActivityId(long recentActivityId) {
        this.recentActivityId = recentActivityId;
    }

    public List<ActivityLog> getLogs() {
        return logs;
    }

    public void setLogs(List<ActivityLog> logs) {
        this.logs = logs;
    }
}
