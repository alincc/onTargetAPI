package com.ontarget.api.rs;

import com.ontarget.api.response.ProjectEarnedValueReportResponse;

/**
 * Created by Owner on 12/23/14.
 */
public interface ProjectReportEndpoint {


    public ProjectEarnedValueReportResponse getProjectEarnedValueAnalysis(int projectId);

}
