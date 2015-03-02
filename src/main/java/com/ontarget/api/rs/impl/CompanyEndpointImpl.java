package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.service.CompanyService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.CompanyListResponse;
import com.ontarget.request.bean.CompanyList;

/**
 * Created by sumit on 12/24/14.
 */
@Component
@Path("/company")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyEndpointImpl implements com.ontarget.api.rs.CompanyEndpoint {

	private Logger logger = Logger.getLogger(ActivityLogImpl.class);

	@Autowired
	private CompanyService companyService;

	@Override
	@Path("/getCompanyList")
	@POST
	public CompanyListResponse getCompanyList(CompanyList companyList) {
		CompanyListResponse response = new CompanyListResponse();
		try {
			response.setCompanyList(companyService.getCompanyList());
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			logger.error("Error while getting company list", e);
			response.setReturnMessage("Error while getting company list.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}
}
