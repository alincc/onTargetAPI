package com.ontarget.dto;

import java.util.List;

import com.ontarget.bean.AccidentReport;

public class GetAccidentReportsResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	
	private List<AccidentReport> accidentReports;

	public List<AccidentReport> getAccidentReports() {
		return accidentReports;
	}

	public void setAccidentReports(List<AccidentReport> accidentReports) {
		this.accidentReports = accidentReports;
	}
	
}
