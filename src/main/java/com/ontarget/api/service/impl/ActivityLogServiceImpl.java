package com.ontarget.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.ActivityDAO;
import com.ontarget.dto.ActivityLogDTO;

/**
 * Created by sumit on 12/6/14.
 */
@Service
public class ActivityLogServiceImpl implements com.ontarget.api.service.ActivityLogService {

	@Autowired
	@Qualifier("activityJpaDAOImpl")
	private ActivityDAO activityDAO;

	@Override
	public ActivityLogDTO getActivityLog(int pageNumber, int perPageLimit, int projectId) throws Exception {
		return activityDAO.getActivityLog(pageNumber, perPageLimit, projectId);
	}
}
