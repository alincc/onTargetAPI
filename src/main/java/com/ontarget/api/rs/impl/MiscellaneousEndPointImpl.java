package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.MiscellaneousEndPoint;
import com.ontarget.api.service.Miscellaneous;
import com.ontarget.api.service.TaskService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.CountryListResponse;
import com.ontarget.dto.StateListResponse;
import com.ontarget.dto.TaskIdListResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Yam on 12-12-2014.
 */
@Component
@Path("/configuration")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MiscellaneousEndPointImpl implements MiscellaneousEndPoint {

    private Logger logger = Logger.getLogger(MiscellaneousEndPointImpl.class);

    @Autowired
    private Miscellaneous miscellaneousService;

    @Override
    @GET
    @Path("/getStatesByCountry")
    public StateListResponse getStatesByCountry(@QueryParam("countryId") long countryId) {
        StateListResponse response = new StateListResponse();
        System.out.println("this is country id "+countryId);
        logger.info("Getting all states by country: " + countryId);
        try {
            response.setStateId(miscellaneousService.getStatesByCountry(countryId));
            response.setReturnMessage("Successfully retrieved states by country");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Get states by country failed." + e);
            response.setReturnMessage("Get states by country failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    @Override
    @GET
    @Path("/getCountryList")
    public CountryListResponse getCountryList() {
        CountryListResponse response = new CountryListResponse();
        System.out.println("this is country list ");
        logger.info("Getting all countries");
        try {
            response.setCountryId(miscellaneousService.getCountryList());
            response.setReturnMessage("Successfully retrieved countries");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Get countries failed." + e);
            response.setReturnMessage("Get countries country failed");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }
}
