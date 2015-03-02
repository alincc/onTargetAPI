package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.GetAccidentReportsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SaveAccidentReportResponse;
import com.ontarget.request.bean.AccidentReportInfoRequest;
import com.ontarget.request.bean.AccidentReportRequest;

public interface AccidentReportEndpoint {
	SaveAccidentReportResponse saveAccidentReport(
			@Valid AccidentReportRequest request);

	GetAccidentReportsResponse getAccidentReports(
			@Valid AccidentReportInfoRequest accidentReportInfoRequestBean);

	OnTargetResponse updateAccidentReport(
			@Valid AccidentReportRequest request);
}
