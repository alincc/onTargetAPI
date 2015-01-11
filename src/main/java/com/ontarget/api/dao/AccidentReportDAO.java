package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.AccidentReport;

public interface AccidentReportDAO extends GenericDAO<AccidentReport> {
	List<AccidentReport> getAccidentReportsByProjectId(long projectId);
}
