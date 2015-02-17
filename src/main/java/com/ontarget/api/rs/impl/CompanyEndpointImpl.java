package com.ontarget.api.rs.impl;

import com.ontarget.api.service.CompanyService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.CompanyListResponse;
import com.ontarget.request.bean.BaseRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
    public CompanyListResponse getCompanyList(BaseRequest baseRequest) {
        CompanyListResponse response = new CompanyListResponse();
        try {
            response.setCompanyList(companyService.getCompanyList());
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
           logger.error("Error while getting company list",e);
            response.setReturnMessage("Error while getting company list.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }
}
