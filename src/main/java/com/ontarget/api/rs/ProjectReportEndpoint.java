package com.ontarget.api.rs;

import com.ontarget.api.response.BIReportResponse;
import com.ontarget.api.response.ProjectEarnedValueReportResponse;

import javax.ws.rs.PathParam;

/**
 * Created by Owner on 12/23/14.
 */
public interface ProjectReportEndpoint {


    public ProjectEarnedValueReportResponse getProjectEarnedValueAnalysis(int projectId);

    public BIReportResponse getTimeSaved(int projectId);
}
