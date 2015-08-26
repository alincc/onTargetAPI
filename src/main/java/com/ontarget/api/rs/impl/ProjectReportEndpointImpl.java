package com.ontarget.api.rs.impl;

import com.ontarget.api.response.BIReportResponse;
import com.ontarget.api.response.ProjectEarnedValueReportResponse;
import com.ontarget.api.response.TaskBurnDownResponse;
import com.ontarget.api.rs.ProjectReportEndpoint;
import com.ontarget.api.service.ProjectReportService;
import com.ontarget.bean.NoAccidentReport;
import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.TimeSaved;
import com.ontarget.bean.TreesSaved;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.request.bean.ProjectReportInfo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

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
	@POST
	@Path("/earnedValueReport")
	public ProjectEarnedValueReportResponse getProjectEarnedValueAnalysis(ProjectReportInfo projectReportRequest) {
		logger.debug("Getting earned value report for projectId: " + projectReportRequest.getProjectId());
		ProjectEarnedValueReportResponse response = new ProjectEarnedValueReportResponse();

		try {
			List<ProjectEarnedValueAnalysisReport> report = projectReportService
					.getEarnedValueAnalysisReport(projectReportRequest.getProjectId());
			response.setEarnedValueAnalysisReportMap(report);
			response.setReturnMessage("Successfully retrieved report.");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			logger.error("Exception while retrieving earned value report", e);
			response.setReturnMessage("Error while  retrieving report.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

	@Override
	@POST
	@Path("/bireport")
	public BIReportResponse getBIReport(ProjectReportInfo projectReportRequest) {
		BIReportResponse response = new BIReportResponse();

		try {
			TimeSaved timeSaved = projectReportService.getTimeSaved(projectReportRequest.getProjectId());
			TreesSaved treesSaved = projectReportService.getTreesSaved(projectReportRequest.getProjectId());
			NoAccidentReport noAccidentReport = projectReportService.getNoAccidentReport(projectReportRequest.getProjectId());

			response.setTimeSaved(timeSaved);
			response.setTreesSaved(treesSaved);
			response.setNoAccidentReport(noAccidentReport);

			response.setReturnMessage("Successfully retrieved BI report.");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			logger.error("Exception while retrieving BI report", e);
			response.setReturnMessage("Error while retrieving BI report.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}

		return response;
	}

    @Override
    @POST
    @Path("/taskBurnDown")
    public TaskBurnDownResponse getTaskBurnDownReport(ProjectReportInfo projectReportRequest) {
        TaskBurnDownResponse response = new TaskBurnDownResponse();

        try {
            response=projectReportService.getTaskBurnDownReport(projectReportRequest.getProjectId());
            response.setReturnMessage("Successfully retrieved task burndown report.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } catch (Exception e) {
            logger.error("Exception while retrieving BI report", e);
            response.setReturnMessage("Error while retrieving task burn down report.");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

}
