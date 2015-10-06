package com.ontarget.api.dao;

import org.springframework.data.domain.Page;

import com.ontarget.dto.ActivityLogDTO;

/**
 * Created by sumit on 12/6/14.
 */
public interface ActivityDAO {

	Page<com.ontarget.entities.ActivityLog> getActivityLogList(int pageNumber, int perPageLimit, int projectId) throws Exception;
	
	ActivityLogDTO getActivityLog(int pageNumber, int perPageLimit, int projectId) throws Exception;

}
