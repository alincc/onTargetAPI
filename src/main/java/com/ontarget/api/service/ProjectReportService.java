package com.ontarget.api.service;

import com.ontarget.bean.ProjectEarnedValueAnalysisReport;

import java.util.List;

/**
 * Created by Owner on 12/3/14.
 */
public interface ProjectReportService {


    public java.util.Map<com.ontarget.bean.TaskInterval, ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(int projectId) throws Exception;

}
