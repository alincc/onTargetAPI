package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.ActivityLogResponse;
import com.ontarget.request.bean.ActivityLogRequest;

/**
 * Created by sumit on 12/6/14.
 */
public interface ActivityLog {
	ActivityLogResponse getActivityLog(
			@Valid ActivityLogRequest activityLogRequest);
}
