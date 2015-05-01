package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.TimeCardEndpoint;
import com.ontarget.api.service.TimeCardService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddTimeCardRequest;

@Component
@Path("/timeCard")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TimeCardEndpointImpl implements TimeCardEndpoint {

	private Logger logger = Logger.getLogger(TimeCardEndpointImpl.class);

	@Autowired
	private TimeCardService timeCardService;

	@Override
	@POST
	@Path("/add")
	public OnTargetResponse addTimeCard(AddTimeCardRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			return timeCardService.addTimeCard(request);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Add time card failed." + e);
			response.setReturnMessage("Add time card failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
