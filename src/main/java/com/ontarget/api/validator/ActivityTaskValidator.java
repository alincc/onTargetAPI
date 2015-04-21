package com.ontarget.api.validator;

import java.text.ParseException;
import java.util.Date;

import com.ontarget.entities.Project;
import com.ontarget.request.bean.ActivityTaskRecord;
import com.ontarget.util.DateFormater;
import com.ontarget.util.DateValidator;
import com.ontarget.util.StringUtility;

public class ActivityTaskValidator {
	private ActivityTaskRecord activityTaskRecord;
	private Project project;
	private boolean isValid;

	public ActivityTaskValidator(ActivityTaskRecord activityTaskRecord, Project project) {
		this.activityTaskRecord = activityTaskRecord;
		this.project = project;
	}

	public void validate() {
		StringBuilder sb = new StringBuilder();
		if (StringUtility.isEmpty(activityTaskRecord.getActivityCode())) {
			sb.append("activity code empty,");
		}
		if (StringUtility.isEmpty(activityTaskRecord.getActivityName())) {
			sb.append("activity name empty,");
		}
		boolean actvityDateValid = true;
		if (!DateValidator.isThisDateValid(activityTaskRecord.getActivityStartDate(), DateValidator.dateFormat)) {
			actvityDateValid = false;
			sb.append("activity start date invalid,");
		}
		if (!DateValidator.isThisDateValid(activityTaskRecord.getActivityEndDate(), DateValidator.dateFormat)) {
			actvityDateValid = false;
			sb.append("activity end date invalid,");
		}

		if (actvityDateValid && !isActivityDatesBetweenProject(activityTaskRecord)) {
			sb.append("activity date range must be between project date range,");
		}

		if (StringUtility.isEmpty(activityTaskRecord.getTaskCode())) {
			sb.append("task code empty,");
		}
		if (StringUtility.isEmpty(activityTaskRecord.getTaskName())) {
			sb.append("task name empty,");
		}
		boolean taskDateValid = true;
		if (!DateValidator.isThisDateValid(activityTaskRecord.getTaskStartDate(), DateValidator.dateFormat)) {
			sb.append("task start date invalid,");
			taskDateValid = false;
		}
		if (!DateValidator.isThisDateValid(activityTaskRecord.getTaskEndDate(), DateValidator.dateFormat)) {
			sb.append("task end date invalid,");
			taskDateValid = false;
		}

		if (taskDateValid && !isTaskDatesBetweenActivity(activityTaskRecord)) {
			sb.append("task date range must be between activity date range,");
		}

		try {
			Double.parseDouble(String.valueOf(activityTaskRecord.getPercentageComplete()));
		} catch (NumberFormatException nre) {
			sb.append("task percentage is invalid,");
		}
		try {
			Double.parseDouble(String.valueOf(activityTaskRecord.getEstimatedCost()));
		} catch (NumberFormatException nre) {
			sb.append("estimated cost is invalid,");
		}
		try {
			Double.parseDouble(String.valueOf(activityTaskRecord.getActualCost()));
		} catch (NumberFormatException nre) {
			sb.append("actual cost is invalid,");
		}

		isValid = true;

		if (sb.length() > 0) {
			isValid = false;
			String invalidMsg = sb.toString();
			invalidMsg = invalidMsg.substring(0, invalidMsg.length() - 1);
			activityTaskRecord.setInvalidMsg(invalidMsg);
		}
	}

	private boolean isActivityDatesBetweenProject(ActivityTaskRecord activityTaskRecord) {
		try {
			Date projectStartDate = DateFormater.getFormattedDate(project.getProjectStartDate());
			Date projectEndDate = DateFormater.getFormattedDate(project.getProjectEndDate());

			Date activityStartDate = DateFormater.convertToDate(activityTaskRecord.getActivityStartDate(),
					DateValidator.dateFormat);
			Date activityEndDate = DateFormater.convertToDate(activityTaskRecord.getActivityEndDate(), DateValidator.dateFormat);

			if (activityStartDate.before(projectStartDate)) {
				return false;
			} else {
				if (activityEndDate.after(projectEndDate)) {
					return false;
				}
			}
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean isTaskDatesBetweenActivity(ActivityTaskRecord activityTaskRecord) {
		try {
			Date activityStartDate = DateFormater.convertToDate(activityTaskRecord.getActivityStartDate(),
					DateValidator.dateFormat);
			Date activityEndDate = DateFormater.convertToDate(activityTaskRecord.getActivityEndDate(), DateValidator.dateFormat);

			Date taskStartDate = DateFormater.convertToDate(activityTaskRecord.getTaskStartDate(), DateValidator.dateFormat);
			Date taskEndDate = DateFormater.convertToDate(activityTaskRecord.getTaskEndDate(), DateValidator.dateFormat);

			if (taskStartDate.before(activityStartDate)) {
				return false;
			} else {
				if (taskEndDate.after(activityEndDate)) {
					return false;
				}
			}
			return true;
		} catch (ParseException p) {
			p.printStackTrace();
			return false;
		}
	}

	public boolean isValid() {
		return isValid;
	}

	public ActivityTaskRecord getActivityTaskRecord() {
		return activityTaskRecord;
	}

}
