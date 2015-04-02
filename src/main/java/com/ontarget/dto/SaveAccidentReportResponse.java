package com.ontarget.dto;

public class SaveAccidentReportResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	
	private int accidentReportId;

	public int getAccidentReportId() {
		return accidentReportId;
	}

	public void setAccidentReportId(int accidentReportId) {
		this.accidentReportId = accidentReportId;
	}
}
