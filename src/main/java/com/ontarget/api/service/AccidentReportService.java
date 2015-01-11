package com.ontarget.api.service;

import com.ontarget.dto.GetAccidentReportsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SaveAccidentReportRequest;
import com.ontarget.dto.SaveAccidentReportResponse;

public interface AccidentReportService {
	
	SaveAccidentReportResponse saveAccidentReport(SaveAccidentReportRequest request) throws Exception;
	OnTargetResponse updateAccidentReport(SaveAccidentReportRequest request) throws Exception;
	GetAccidentReportsResponse getAccidentReports(long projectId) throws Exception;
}
