package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.ontarget.api.response.BIReportResponse;
import com.ontarget.api.response.ProjectEarnedValueReportResponse;
import com.ontarget.api.response.TaskBurnDownResponse;
import com.ontarget.request.bean.ProjectReportInfo;

/**
 * Created by Owner on 12/23/14.
 */
public interface ProjectReportEndpoint {

	public ProjectEarnedValueReportResponse getProjectEarnedValueAnalysis(
			@Valid ProjectReportInfo projectReportRequest);

	public BIReportResponse getBIReport(
			@Valid ProjectReportInfo projectReportRequest);

    TaskBurnDownResponse getTaskBurnDownReport(@Valid ProjectReportInfo projectReportRequest);
}
