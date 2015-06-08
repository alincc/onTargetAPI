package com.ontarget.api.service;

import com.ontarget.dto.ActivityLogDTO;

/**
 * Created by sumit on 12/6/14.
 */
public interface ActivityLogService {
	public ActivityLogDTO getActivityLog(int pageNumber, int perPageLimit, int projectId) throws Exception;
}
