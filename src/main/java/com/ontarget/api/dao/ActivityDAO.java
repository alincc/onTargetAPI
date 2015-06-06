package com.ontarget.api.dao;

import com.ontarget.dto.ActivityLogDTO;

/**
 * Created by sumit on 12/6/14.
 */
public interface ActivityDAO {

	public ActivityLogDTO getActivityLog(int pageNumber, int perPageLimit, int projectId) throws Exception;

}
