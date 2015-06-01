package com.ontarget.api.rs.impl;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.service.ActivityLogService;
import com.ontarget.bean.ActivityLog;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.ActivityLogResponse;
import com.ontarget.request.bean.ActivityLogRequest;

/**
 * Created by sumit on 12/6/14.
 */
@Component
@Path("/activityLog")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ActivityLogImpl implements com.ontarget.api.rs.ActivityLog {

	private Logger logger = Logger.getLogger(ActivityLogImpl.class);

	@Autowired
	private ActivityLogService activityLogService;

	@Override
	@POST
	@Path("/getLog")
	public ActivityLogResponse getActivityLog(ActivityLogRequest activityLogRequest) {
		ActivityLogResponse response = new ActivityLogResponse();
		try {
			long recentId = activityLogRequest.getRecentId();
			List<ActivityLog> activityLogs = activityLogService.getActivityLog(activityLogRequest.getRecentId());
			if (activityLogs == null || activityLogs.isEmpty()) {
				response.setLogs(new LinkedList<ActivityLog>());
				response.setRecentActivityId(recentId);
			} else {
				response.setLogs(activityLogs);
				response.setRecentActivityId(activityLogs.get(activityLogs.size() - 1).getId());
			}
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Activity log read");
		} catch (Exception e) {
			logger.error("Authentication error", e);
			response.setReturnMessage("Authentication Error");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
