package com.ontarget.api.rs;

import com.ontarget.dto.GetAccidentReportsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SaveAccidentReportRequest;
import com.ontarget.dto.SaveAccidentReportResponse;

public interface AccidentReportEndpoint {
	SaveAccidentReportResponse saveAccidentReport(SaveAccidentReportRequest request);
	GetAccidentReportsResponse getAccidentReports(String projectId);
	OnTargetResponse updateAccidentReport(SaveAccidentReportRequest request);
}
