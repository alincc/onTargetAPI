package com.ontarget.api.rs.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.UploadActivityEndpoint;
import com.ontarget.api.service.UploadActivityService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.UploadActivityResponse;
import com.ontarget.request.bean.ActivityTaskRecord;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.UploadActivityRequest;
import com.ontarget.util.ExcelUtils;
import com.ontarget.util.FileUtils;

@Component
@Path("/uploadActivity")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UploadActivityEndpointImpl implements UploadActivityEndpoint {

	private Logger logger = Logger.getLogger(UploadActivityEndpointImpl.class);

	@Autowired
	private UploadActivityService uploadActivityService;
	@Value("${file.upload.path}")
	public String UPLOAD_FILE_SERVER;

	@POST
	@Override
	public UploadActivityResponse createActivity(UploadActivityRequest request) {
		UploadActivityResponse response = new UploadActivityResponse();
		try {
			response = uploadActivityService.createActivity(request);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("sucessfully uploaded");
			return response;
		} catch (Exception t) {
			logger.error("Error occurred while uploading activity!", t);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error uploading activity");
			return response;
		}
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public UploadActivityResponse uploadExcelFile(@FormDataParam("uploadFile") InputStream fileInputStream,
			@FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition,
			@FormDataParam("projectId") Integer projectId, @FormDataParam("userId") Integer userId) {

		logger.info("project id: " + projectId);
		logger.info("user id: " + userId);

		UploadActivityResponse response = new UploadActivityResponse();

		try {
			String fileName = fileFormDataContentDisposition.getFileName();

			logger.info("file name: " + fileName);

			FileUtils.writeToFileServer(fileInputStream, fileName);

			String uploadFilePath = UPLOAD_FILE_SERVER + fileName;

			logger.info("uploaded file path: " + uploadFilePath);

			FileInputStream fis = new FileInputStream(new File(uploadFilePath));
			Workbook workbook = ExcelUtils.getWorkbook(fileName, fis);

			UploadActivityRequest request = ExcelUtils.getActivityRecords(workbook, projectId, fileName);
			BaseRequest baseRequest = new BaseRequest();
			baseRequest.setLoggedInUserId(userId);
			baseRequest.setLoggedInUserProjectId(projectId);
			request.setBaseRequest(baseRequest);

			for (ActivityTaskRecord record : request.getActivityTaskRecords()) {
				logger.info("==============================");
				logger.info("activity code: " + record.getActivityCode());
				logger.info("activity name: " + record.getActivityName());
				logger.info("activity start date: " + record.getActivityStartDate());
				logger.info("activity end date: " + record.getActivityEndDate());
				logger.info("task code: " + record.getTaskCode());
				logger.info("task name: " + record.getTaskName());
				logger.info("task desc: " + record.getTaskDescription());
				logger.info("task start date: " + record.getTaskStartDate());
				logger.info("task end date: " + record.getTaskEndDate());
				logger.info("estimated cost: " + record.getEstimatedCost());
				logger.info("actual cost: " + record.getActualCost());
				logger.info("task priority: " + record.getPriority());
				logger.info("percentage complete: " + record.getPercentageComplete());
				logger.info("==============================");
			}
			fis.close();
			response = uploadActivityService.createActivity(request);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("sucessfully uploaded");
			return response;

		} catch (IOException e) {
			logger.error("Error occurred while uploading activity!", e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error uploading activity");
			return response;

		} catch (Exception e) {
			logger.error("Error occurred while uploading activity!", e);
			response.setReturnVal(OnTargetConstant.ERROR);
			response.setReturnMessage("Error uploading activity");
			return response;
		}

	}

}
