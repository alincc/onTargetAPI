package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.api.response.BIReportResponse;
import com.ontarget.api.response.ProjectEarnedValueReportResponse;
import com.ontarget.request.bean.ProjectReportInfo;

/**
 * Created by Owner on 12/23/14.
 */
public interface ProjectReportEndpoint {

	public ProjectEarnedValueReportResponse getProjectEarnedValueAnalysis(
			@Valid ProjectReportInfo projectReportRequest);

	public BIReportResponse getTimeSaved(
			@Valid ProjectReportInfo projectReportRequest);
}
