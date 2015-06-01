package com.ontarget.api.constraint;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.apache.log4j.Logger;

import com.ontarget.request.bean.UpdateTimeCardRequest;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TimeCardTimeRangeForEdit.Validator.class)
public @interface TimeCardTimeRangeForEdit {

	String message() default "{time-out.before.time-in}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class Validator implements ConstraintValidator<TimeCardTimeRangeForEdit, UpdateTimeCardRequest> {

		private Logger logger = Logger.getLogger(TimeCardTimeRangeForEdit.class);

		@Override
		public void initialize(final TimeCardTimeRangeForEdit hasId) {
		}

		@Override
		public boolean isValid(final UpdateTimeCardRequest request, final ConstraintValidatorContext constraintValidatorContext) {
			try {
				if (request.getTimeOut().before(request.getTimeIn())) {
					logger.info("time-out should not be before time-in");
					return false;
				}
			} catch (Exception e) {
				logger.error(e);
				return false;
			}
			return true;
		}
	}
}
