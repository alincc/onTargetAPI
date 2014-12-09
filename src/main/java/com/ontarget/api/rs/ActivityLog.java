package com.ontarget.api.rs;

import com.ontarget.dto.ActivityLogResponse;

import javax.ws.rs.QueryParam;

/**
 * Created by sumit on 12/6/14.
 */
public interface ActivityLog {
    ActivityLogResponse getActivityLog(@QueryParam("recentId") long recentId);
}
