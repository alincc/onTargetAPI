package com.ontarget.api.rs.impl;

import com.ontarget.api.service.CompanyService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.CompanyListResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by sumit on 12/24/14.
 */
@Component
@Path("/company")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CompanyEndpointImpl implements com.ontarget.api.rs.CompanyEndpoint {

    @Autowired
    private CompanyService companyService;

    @Override
    @Path("/getCompanyList")
    @GET
    public CompanyListResponse getCompanyList() {
        CompanyListResponse response = new CompanyListResponse();
        try {
            response.setCompanyList(companyService.getCompanyList());
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            response.setReturnMessage(OnTargetConstant.REGISTRATION_REQUEST_FAILED);
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }
}
