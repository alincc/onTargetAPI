package com.ontarget.api.constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.bean.ProjectDTO;
import com.ontarget.request.bean.Task;
import com.ontarget.request.bean.TaskRequest;
import com.ontarget.util.DateFormater;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TaskDateRangeBetweenProject.Validator.class)
public @interface TaskDateRangeBetweenProject {

	String message() default "{task.date.range.not.between.project}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class Validator implements ConstraintValidator<TaskDateRangeBetweenProject, TaskRequest> {

		private Logger logger = Logger.getLogger(TaskDateRangeBetweenProject.class);

		@Autowired
		@Qualifier("projectJpaDAOImpl")
		private ProjectDAO projectDAO;

		@Override
		public void initialize(final TaskDateRangeBetweenProject hasId) {
		}

		@Override
		public boolean isValid(final TaskRequest taskRequest, final ConstraintValidatorContext constraintValidatorContext) {
			try {
				Task task = taskRequest.getTask();

				Date startDate = DateFormater.getFormattedDate(task.getStartDate());
				Date endDate = DateFormater.getFormattedDate(task.getEndDate());

				ProjectDTO project = projectDAO.getProject(task.getProjectId());

				Date projectStartDate = DateFormater.getFormattedDate(project.getStartDate());
				Date projectEndDate = DateFormater.getFormattedDate(project.getEndDate());

				logger.info("project start date:: " + projectStartDate);
				logger.info("project end date:: " + projectEndDate);

				if (startDate.before(projectStartDate)) {
					logger.info(startDate.toString() + " less than " + projectStartDate.toString());
					return false;
				} else {
					if (endDate.after(projectEndDate)) {
						logger.info(endDate.toString() + " more than " + projectEndDate.toString());
						return false;
					}
				}
			} catch (Exception e) {
				logger.error(e);
				return false;
			}
			return true;
		}
	}
}
