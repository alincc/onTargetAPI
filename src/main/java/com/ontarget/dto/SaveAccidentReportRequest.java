package com.ontarget.dto;

import com.ontarget.bean.AccidentReport;
import com.ontarget.bean.UserDTO;

public class SaveAccidentReportRequest {
	private AccidentReport accidentReport;
	private UserDTO user;

	public AccidentReport getAccidentReport() {
		return accidentReport;
	}

	public void setAccidentReport(AccidentReport accidentReport) {
		this.accidentReport = accidentReport;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
