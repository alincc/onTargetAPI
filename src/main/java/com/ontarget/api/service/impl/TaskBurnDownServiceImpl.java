package com.ontarget.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.dao.TaskBurnDownDAO;
import com.ontarget.api.service.TaskBurnDownService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Project;
import com.ontarget.response.bean.TaskBurnDown;
import com.ontarget.response.bean.TaskBurnDownListResponse;
import com.ontarget.util.DateFormater;
import com.ontarget.util.DateRange;
import com.ontarget.util.JodaDateTimeUtil;
import com.ontarget.util.TaskBurnDownUtil;

@Service
public class TaskBurnDownServiceImpl implements TaskBurnDownService {
	private Logger logger = Logger.getLogger(TaskBurnDownServiceImpl.class);

	@Autowired
	private TaskBurnDownDAO taskBurnDownDAO;
	@Autowired
	@Qualifier("projectJpaDAOImpl")
	private ProjectDAO projectDAO;

	@Override
	public TaskBurnDownListResponse getTaskBurnDownOfProject(Integer projectId) throws Exception {
		TaskBurnDownListResponse response = new TaskBurnDownListResponse();
		try {
			Project project = projectDAO.findProjectById(projectId);

			logger.info("getting task burn down of project id: " + projectId);
			System.out.println("getting task burn down of project id: " + projectId);

			List<DateRange> dateRanges = TaskBurnDownUtil.getDateRangeBetweenDates(project.getProjectStartDate(),
					project.getProjectEndDate());

			logger.info("project start date: " + DateFormater.convertToString(project.getProjectStartDate(), "yyyy-MM-dd"));
			logger.info("project end date: " + DateFormater.convertToString(project.getProjectEndDate(), "yyyy-MM-dd"));

			int i = 1;
			for (DateRange dateRange : dateRanges) {
				logger.debug("====================================" + i);
				logger.debug("from date: " + JodaDateTimeUtil.getFormattedDate(dateRange.getFromDate(), JodaDateTimeUtil.sqlDateFormat));
				logger.debug("to date: " + JodaDateTimeUtil.getFormattedDate(dateRange.getToDate(), JodaDateTimeUtil.sqlDateFormat));
				logger.debug("====================================");
				i++;
			}

			List<Project> activities = projectDAO.getUndeletedProjectsByParentId(projectId);

			List<TaskBurnDown> burnDownList = new ArrayList<TaskBurnDown>();

			for (DateRange dateRange : dateRanges) {
				long completeSum = 0;
				long incompleteSum = 0;

				TaskBurnDown taskBurnDown = new TaskBurnDown();
				taskBurnDown.setFromDate(JodaDateTimeUtil.getFormattedDate(dateRange.getFromDate(), JodaDateTimeUtil.sqlDateFormat));
				taskBurnDown.setToDate(JodaDateTimeUtil.getFormattedDate(dateRange.getToDate(), JodaDateTimeUtil.sqlDateFormat));

				for (Project activity : activities) {
					completeSum += taskBurnDownDAO.getCompleteTaskOfActivity(activity.getProjectId(), taskBurnDown.getToDate()).longValue();
					incompleteSum += taskBurnDownDAO.getIncompleteTaskOfActivity(activity.getProjectId(), taskBurnDown.getToDate())
							.longValue();
				}
				taskBurnDown.setComplete(completeSum);
				taskBurnDown.setIncomplete(incompleteSum);
				burnDownList.add(taskBurnDown);
			}
			response.setTaskBurnDownData(burnDownList);
			response.setReturnMessage("Successfully retrieved task burn down");
			response.setReturnVal(OnTargetConstant.SUCCESS);
		} catch (Exception e) {
			logger.error("error: " + e);
			response.setReturnMessage("Error while getting task burn down");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
