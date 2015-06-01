package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.UploadActivityEndpoint;
import com.ontarget.api.service.UploadActivityService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UploadActivityResponse;
import com.ontarget.request.bean.UploadActivityRequest;

@Component
@Path("/uploadActivity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UploadActivityEndpointImpl implements UploadActivityEndpoint {

	private Logger logger = Logger.getLogger(UploadActivityEndpointImpl.class);

	@Autowired
	private UploadActivityService uploadActivityService;

	@POST
	@Override
	public UploadActivityResponse createActivity(UploadActivityRequest request) {
		UploadActivityResponse response = new UploadActivityResponse();
		try {
			response = uploadActivityService.createActivity(request);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("sucessfully uploaded");
			return response;
		} catch (Exception t) {
			logger.error("Error occurred while uploading activity!", t);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error uploading activity");
			return response;
		}
	}

}
