package com.ontarget.api.service;

import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.Task;
import com.ontarget.bean.TaskInterval;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 12/3/14.
 */
public interface ProjectReportService {


    public Map<TaskInterval, ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(int projectId) throws Exception;

}
