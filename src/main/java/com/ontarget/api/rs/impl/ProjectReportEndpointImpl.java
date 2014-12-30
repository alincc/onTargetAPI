package com.ontarget.api.rs.impl;

import com.ontarget.api.response.ProjectEarnedValueReportResponse;
import com.ontarget.api.rs.ProjectReportEndpoint;
import com.ontarget.api.service.ProjectReportService;
import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.TaskInterval;
import com.ontarget.constant.OnTargetConstant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 12/23/14.
 */
@Component
@Path("/report")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectReportEndpointImpl implements ProjectReportEndpoint {

    @Autowired
    ProjectReportService projectReportService;
    private Logger logger = Logger.getLogger(ProjectReportEndpointImpl.class);

    @Override
    @GET
    @Path("/earnedValueReport/{projectId}")
    public ProjectEarnedValueReportResponse getProjectEarnedValueAnalysis(@PathParam("projectId") int projectId) {
        ProjectEarnedValueReportResponse response = new ProjectEarnedValueReportResponse();

        try {
            List<ProjectEarnedValueAnalysisReport> report = projectReportService.getEarnedValueAnalysisReport(projectId);
            response.setEarnedValueAnalysisReportMap(report);
            response.setReturnMessage("Successfully retrieved report.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Exception while retrieving earned value report", e);
            response.setReturnMessage("Successfully retrieved report.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        }

        return response;
    }


}
