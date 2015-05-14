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
import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.FieldWorkerList;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;
import com.ontarget.request.bean.UpdateTimeCardRequest;

@Component
@Path("/timecard")
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

	@Override
	@POST
	@Path("/edit")
	public OnTargetResponse edit(UpdateTimeCardRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			return timeCardService.editTimeCard(request);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Edit time card failed." + e);
			response.setReturnMessage("Edit time card failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/addFieldWorker")
	public OnTargetResponse addFieldWorker(AddFieldWorkerRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			return timeCardService.addFieldWorker(request);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Add field worker failed." + e);
			response.setReturnMessage("Add field worker failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/editFieldWorker")
	public OnTargetResponse editFieldWorker(UpdateFieldWorkerRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			return timeCardService.editFieldWorker(request);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("edit field worker failed." + e);
			response.setReturnMessage("edit field worker failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@Path("/getFieldWorkers")
	@POST
	public FieldWorkerResponse getFieldWorkers(FieldWorkerList request) {
		FieldWorkerResponse response = new FieldWorkerResponse();
		try {
			return timeCardService.fetchAllFieldWorkers();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error while retrieving field workers." + e);
			response.setReturnMessage("Error while retrieving field workers");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
