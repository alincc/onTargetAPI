package com.ontarget.api.service;

import com.ontarget.bean.AccidentReport;
import com.ontarget.dto.GetAccidentReportsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SaveAccidentReportRequest;
import com.ontarget.dto.SaveAccidentReportResponse;

public interface AccidentReportService {
	
	SaveAccidentReportResponse saveAccidentReport(AccidentReport request) throws Exception;
	OnTargetResponse updateAccidentReport(AccidentReport request) throws Exception;
	GetAccidentReportsResponse getAccidentReports(long projectId) throws Exception;
}
