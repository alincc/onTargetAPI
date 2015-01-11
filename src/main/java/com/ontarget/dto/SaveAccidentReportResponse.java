package com.ontarget.dto;

public class SaveAccidentReportResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	
	private Long accidentReportId;

	public Long getAccidentReportId() {
		return accidentReportId;
	}

	public void setAccidentReportId(Long accidentReportId) {
		this.accidentReportId = accidentReportId;
	}
}
