package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.UploadActivityDAO;
import com.ontarget.api.service.UploadActivityService;
import com.ontarget.bean.ActivityInfo;
import com.ontarget.dto.UploadActivityResponse;
import com.ontarget.entities.Project;
import com.ontarget.request.bean.ActivityTaskRecord;
import com.ontarget.request.bean.UploadActivityRequest;
import com.ontarget.util.ActivityTaskUtil;

@Service
public class UploadActivityServiceImpl implements UploadActivityService {

	private Logger logger = Logger.getLogger(UploadActivityServiceImpl.class);

	@Autowired
	@Qualifier("uploadActivityJpaDAOImpl")
	private UploadActivityDAO uploadActivityDAO;
	@Autowired
	@Qualifier("projectJpaDAOImpl")
	private ProjectDAO projectDAO;

	@Transactional(rollbackFor = { Exception.class })
	@Override
	public UploadActivityResponse createActivity(UploadActivityRequest request) throws Exception {

		List<ActivityTaskRecord> invalidActivityRecords = new ArrayList<>();
		try {
			Project project = projectDAO.findProjectById(request.getProjectId());

			ActivityTaskUtil activityTaskUtil = new ActivityTaskUtil(project);
			List<ActivityInfo> activityInfoList = activityTaskUtil.getActivityTaskList(request.getActivityTaskRecords());

			invalidActivityRecords = activityTaskUtil.getInvalidActivityTaskRecords();

			uploadActivityDAO.createActivity(activityInfoList, invalidActivityRecords, request.getFilename(), request
					.getBaseRequest().getLoggedInUserId(), request.getProjectId());

		} catch (Exception e) {
			logger.error("Unable to upload activity!", e);
			throw new Exception("Unable to upload activity!");
		}
		UploadActivityResponse uploadActivityResponse = new UploadActivityResponse();
		uploadActivityResponse.setInvalidActivityRecords(invalidActivityRecords);
		return uploadActivityResponse;
	}

}
