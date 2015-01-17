package com.ontarget.api.service;

import com.ontarget.bean.NoAccidentReport;
import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.TimeSaved;
import com.ontarget.bean.TreesSaved;

import java.util.List;

/**
 * Created by Owner on 12/3/14.
 */
public interface ProjectReportService {


    public List<ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(long projectId) throws Exception;

    public TimeSaved getTimeSaved(long projectId) throws Exception;

    public TreesSaved getTreesSaved(long projectId) throws Exception;

    public NoAccidentReport getNoAccidentReport(long projectId) throws Exception;
}
