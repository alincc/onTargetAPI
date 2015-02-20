package com.ontarget.api.rs.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.AccidentReportEndpoint;
import com.ontarget.api.service.AccidentReportService;
import com.ontarget.bean.AccidentReport;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.GetAccidentReportsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.SaveAccidentReportResponse;
import com.ontarget.request.bean.AccidentReportInfoRequestBean;
import com.ontarget.request.bean.AccidentReportRequestBean;
import com.ontarget.util.ConvertPOJOUtils;

@Component
@Path("/accidentreports")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccidentReportEndpointImpl implements AccidentReportEndpoint {
	private Logger logger = Logger.getLogger(AccidentReportEndpointImpl.class);

	@Autowired
	private AccidentReportService accidentReportService;

	@PUT
	@Override
	public SaveAccidentReportResponse saveAccidentReport(
			AccidentReportRequestBean accidentReportRequestBean) {
		SaveAccidentReportResponse response;
		try {
			AccidentReport accidentReport = ConvertPOJOUtils
					.convertToAccidentReport(accidentReportRequestBean);
			logger.info("accident report:: " + accidentReport);
			response = accidentReportService.saveAccidentReport(accidentReport);
		} catch (Exception t) {
			t.printStackTrace();
			logger.error(t);
			response = new SaveAccidentReportResponse();
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(t.getMessage());
		}
		return response;
	}

	@Override
	@POST
	@Path("/getAccidentReportsOfProject")
	public GetAccidentReportsResponse getAccidentReports(
			AccidentReportInfoRequestBean accidentReportInfoRequestBean) {
		GetAccidentReportsResponse response;
		try {
			response = accidentReportService
					.getAccidentReports(accidentReportInfoRequestBean
							.getProjectId());
		} catch (Throwable t) {
			logger.error(t);
			response = new GetAccidentReportsResponse();
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(t.getMessage());
		}
		return response;
	}

	@Override
	@POST
	public OnTargetResponse updateAccidentReport(
			AccidentReportRequestBean accidentReportRequestBean) {
		OnTargetResponse response;
		try {
			AccidentReport accidentReport = ConvertPOJOUtils
					.convertToAccidentReport(accidentReportRequestBean);
			response = accidentReportService
					.updateAccidentReport(accidentReport);
		} catch (Throwable t) {
			logger.error(t);
			response = new OnTargetResponse();
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage(t.getMessage());
		}
		return response;
	}

}
