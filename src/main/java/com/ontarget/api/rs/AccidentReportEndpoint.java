package com.ontarget.api.rs;

import com.ontarget.dto.GetAccidentReportsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SaveAccidentReportRequest;
import com.ontarget.dto.SaveAccidentReportResponse;
import com.ontarget.request.bean.AccidentReportInfoRequestBean;
import com.ontarget.request.bean.AccidentReportRequestBean;

public interface AccidentReportEndpoint {
	SaveAccidentReportResponse saveAccidentReport(
			AccidentReportRequestBean request);

	GetAccidentReportsResponse getAccidentReports(
			AccidentReportInfoRequestBean accidentReportInfoRequestBean);

	OnTargetResponse updateAccidentReport(AccidentReportRequestBean request);
}
