package com.ontarget.api.constraint;

import java.util.Date;

import org.apache.log4j.Logger;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.entities.Project;
import com.ontarget.util.DateFormater;

public class ActivityDateRangeValidator {
	private ProjectDAO projectDAO;
	private Logger logger = Logger.getLogger(ActivityDateRangeValidator.class);

	public ActivityDateRangeValidator(ProjectDAO projectDAO) {
		super();
		this.projectDAO = projectDAO;
	}

	public boolean isValid(Date activityStartDate, Date activityEndDate, Integer projectId) throws Exception {
		Project project = projectDAO.findProjectById(projectId);

		Date projectStartDate = DateFormater.getFormattedDate(project.getProjectStartDate());
		Date projectEndDate = DateFormater.getFormattedDate(project.getProjectEndDate());

		logger.info("project start date:: " + projectStartDate);
		logger.info("project end date:: " + projectEndDate);

		if (activityStartDate.before(projectStartDate)) {
			logger.info(activityStartDate.toString() + " less than " + projectStartDate.toString());
			return false;
		} else {
			if (activityEndDate.after(projectEndDate)) {
				logger.info(activityEndDate.toString() + " more than " + projectEndDate.toString());
				return false;
			}
		}
		return true;
	}

}
