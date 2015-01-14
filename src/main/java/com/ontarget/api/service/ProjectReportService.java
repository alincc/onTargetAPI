package com.ontarget.api.service;

import com.ontarget.api.response.BIReportResponse;
import com.ontarget.bean.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 12/3/14.
 */
public interface ProjectReportService {


    public List<ProjectEarnedValueAnalysisReport> getEarnedValueAnalysisReport(long projectId) throws Exception;

    public TimeSaved getTimeSaved(long projectId) throws Exception;

    TreesSaved getTreesSaved(long projectId) throws Exception;
}
