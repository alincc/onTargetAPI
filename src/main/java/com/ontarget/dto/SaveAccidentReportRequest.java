package com.ontarget.dto;

import com.ontarget.bean.AccidentReport;
import com.ontarget.bean.User;

public class SaveAccidentReportRequest {
	private AccidentReport accidentReport;
	private User user;

	public AccidentReport getAccidentReport() {
		return accidentReport;
	}

	public void setAccidentReport(AccidentReport accidentReport) {
		this.accidentReport = accidentReport;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
