package com.ontarget.api.response;

import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.TaskInterval;
import com.ontarget.dto.OnTargetResponse;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 12/23/14.
 */
public class ProjectEarnedValueReportResponse extends OnTargetResponse{

    private List<ProjectEarnedValueAnalysisReport> earnedValueAnalysisReportMap;

    public ProjectEarnedValueReportResponse() {
    }


    public List<ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReportMap() {
        return earnedValueAnalysisReportMap;
    }

    public void setEarnedValueAnalysisReportMap(List<ProjectEarnedValueAnalysisReport> earnedValueAnalysisReportMap) {
        this.earnedValueAnalysisReportMap = earnedValueAnalysisReportMap;
    }
}
