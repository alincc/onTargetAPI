package com.ontarget.api.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Provider;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ElementKind;
import javax.validation.Path;
import javax.validation.ValidationException;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Variant;
import javax.ws.rs.ext.ExceptionMapper;

import org.glassfish.jersey.server.validation.ValidationError;
import org.glassfish.jersey.server.validation.internal.LocalizationMessages;

/**
 * {@link ExceptionMapper} for {@link ValidationException}.
 * <p>
 * Send a list of {@link ValidationError} instances in {@link Response} in
 * addition to HTTP 400/500 status code. Supported media types are:
 * {@code application/json} / {@code application/xml} (if appropriate provider
 * is registered on server).
 * </p>
 * 
 * @see org.glassfish.jersey.server.validation.internal.ValidationExceptionMapper
 *      The original Glassfish class:
 *      {@code org.glassfish.jersey.server.validation.internal.ValidationExceptionMapper}
 */
@javax.ws.rs.ext.Provider
public class ValidationExceptionMapper implements
		ExceptionMapper<ConstraintViolationException> {
	// https://github.com/samaxes/jaxrs-beanvalidation-javaee7/blob/master/glassfish/src/main/java/com/samaxes/javax/rs/validation/ValidationExceptionMapper.java
	// http://stackoverflow.com/questions/28529204/jersey-jsr-303-validation-custom-path-and-invalidvalue-in-validationerror
	private static final Logger LOGGER = Logger
			.getLogger(ValidationExceptionMapper.class.getName());

	@Context
	private Configuration config;

	@Context
	private Provider<Request> request;

	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		if (exception instanceof ConstraintViolationException) {
			LOGGER.log(Level.FINER,
					LocalizationMessages.CONSTRAINT_VIOLATIONS_ENCOUNTERED(),
					exception);

			final ConstraintViolationException cve = (ConstraintViolationException) exception;
			final Response.ResponseBuilder response = Response
					.status(getStatus(cve));

			final List<Variant> variants = Variant.mediaTypes(
					MediaType.APPLICATION_XML_TYPE,
					MediaType.APPLICATION_JSON_TYPE).build();
			final Variant variant = request.get().selectVariant(variants);

			// if (variant != null) {
			// System.out.println("media type:: " + variant.getMediaType());
			// response.type(variant.getMediaType());
			// } else {
			/*
			 * default media type which will be used only when none media type
			 * from {@value variants} is in accept header of original request.
			 */
			// response.type(MediaType.TEXT_PLAIN_TYPE);
			response.type(MediaType.APPLICATION_JSON);
			// }
			response.entity(new GenericEntity<List<ValidationError>>(
					getEntity(cve.getConstraintViolations()),
					new GenericType<List<ValidationError>>() {
					}.getType()));

			// response.entity(new GenericEntity<List<ValidationError>>(
			// ValidationHelper.constraintViolationToValidationErrors(cve),
			// new GenericType<List<ValidationError>>() {
			// }.getType()));

			return response.build();
		} else {
			LOGGER.log(Level.WARNING,
					LocalizationMessages.VALIDATION_EXCEPTION_RAISED(),
					exception);

			return Response.serverError().entity(exception.getMessage())
					.build();
		}
	}

	private List<ValidationError> getEntity(
			final Set<ConstraintViolation<?>> violations) {
		final List<ValidationError> errors = new ArrayList<ValidationError>();

		for (final ConstraintViolation<?> violation : violations) {

			errors.add(new ValidationError(violation.getMessage(), violation
					.getMessageTemplate(), getPath(violation),
					getInvalidValue(violation.getInvalidValue())));
		}

		return errors;
	}

	private String getInvalidValue(final Object invalidValue) {
		if (invalidValue == null) {
			return null;
		}

		if (invalidValue.getClass().isArray()) {
			return Arrays.toString((Object[]) invalidValue);
		}

		return invalidValue.toString();
	}

	private Response.Status getStatus(
			final ConstraintViolationException exception) {
		return getResponseStatus(exception.getConstraintViolations());
	}

	private Response.Status getResponseStatus(
			final Set<ConstraintViolation<?>> constraintViolations) {
		final Iterator<ConstraintViolation<?>> iterator = constraintViolations
				.iterator();

		if (iterator.hasNext()) {
			return getResponseStatus(iterator.next());
		} else {
			return Response.Status.BAD_REQUEST;
		}
	}

	private Response.Status getResponseStatus(
			final ConstraintViolation<?> constraintViolation) {
		for (final Path.Node node : constraintViolation.getPropertyPath()) {
			final ElementKind kind = node.getKind();

			if (ElementKind.RETURN_VALUE.equals(kind)) {
				return Response.Status.INTERNAL_SERVER_ERROR;
			}
		}

		return Response.Status.BAD_REQUEST;
	}

	private String getPath(final ConstraintViolation<?> violation) {
		// final String leafBeanName = violation.getLeafBean().getClass()
		// .getSimpleName();
		// final String leafBeanCleanName = (leafBeanName.contains("$")) ?
		// leafBeanName
		// .substring(0, leafBeanName.indexOf("$")) : leafBeanName;

		final String propertyPath = violation.getPropertyPath().toString();
		if (!"".equals("propertyPath")) {
			String param = propertyPath.split("arg")[1];
			String actualParam = param.substring(param.indexOf(".") + 1);
			return actualParam;
		} else {
			return "";
		}

		// return leafBeanCleanName
		// + (!"".equals(propertyPath) ? '.' + propertyPath : "");
	}
}
