package com.ontarget.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.AccidentReportDAO;
import com.ontarget.api.service.AccidentReportService;
import com.ontarget.bean.AccidentReport;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.GetAccidentReportsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SaveAccidentReportResponse;

@Service
public class AccidentReportServiceImpl implements AccidentReportService {
	private Logger logger = Logger.getLogger(AccidentReportServiceImpl.class);

	@Autowired
	private AccidentReportDAO accidentReportDAO;

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public SaveAccidentReportResponse saveAccidentReport(
			AccidentReport accidentReport) throws Exception {
		logger.info("Going to save new accident report ...");
		SaveAccidentReportResponse response = new SaveAccidentReportResponse();
		try {
			accidentReportDAO.insert(accidentReport);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Accident report saved successfully!");
			response.setAccidentReportId(accidentReport.getAccidentReportId());
		} catch (Exception ex) {
			logger.error("Error while saving accident report", ex);
			throw new Exception("Error occurred while saving accident report",
					ex);
		}
		return response;
	}

	@Override
	public OnTargetResponse updateAccidentReport(AccidentReport accidentReport)
			throws Exception {
		logger.info("Going to update accident report ...");
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (!accidentReportDAO.update(accidentReport)) {
				throw new RuntimeException("Problem updating accident report.");
			}
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Accident report successfully updated!");

		} catch (Exception ex) {
			throw new Exception(
					"Error occurred while updating accident report", ex);
		}
		return response;
	}

	@Override
	public GetAccidentReportsResponse getAccidentReports(long projectId)
			throws Exception {
		logger.info("Going to accident reports for projec id " + projectId);
		GetAccidentReportsResponse response = new GetAccidentReportsResponse();
		try {
			List<AccidentReport> accidentReports = accidentReportDAO
					.getAccidentReportsByProjectId(projectId);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setAccidentReports(accidentReports);
			response.setReturnMessage("Accident reports successfully retrieved!");

		} catch (Exception ex) {
			throw new Exception(
					"Error occurred while retrieving accident reports", ex);
		}
		return response;
	}

}
