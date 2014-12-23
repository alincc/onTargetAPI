package com.ontarget.api.response;

import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.TaskInterval;
import com.ontarget.dto.OnTargetResponse;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Owner on 12/23/14.
 */
public class ProjectEarnedValueReportResponse extends OnTargetResponse{

    Map<TaskInterval, ProjectEarnedValueAnalysisReport> earnedValueAnalysisReportMap;

    public ProjectEarnedValueReportResponse() {
    }

    public Map<TaskInterval, ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReportMap() {
        return earnedValueAnalysisReportMap;
    }

    public void setEarnedValueAnalysisReportMap(Map<TaskInterval, ProjectEarnedValueAnalysisReport> earnedValueAnalysisReportMap) {
        this.earnedValueAnalysisReportMap = earnedValueAnalysisReportMap;
    }
}
