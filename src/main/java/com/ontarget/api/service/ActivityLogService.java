package com.ontarget.api.service;

import com.ontarget.bean.ActivityLog;

import java.util.List;

/**
 * Created by sumit on 12/6/14.
 */
public interface ActivityLogService {
    List<ActivityLog> getActivityLog(long recentId) throws Exception;
}
