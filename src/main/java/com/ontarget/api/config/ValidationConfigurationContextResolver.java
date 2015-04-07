package com.ontarget.api.config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;

import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

public class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {

	@Context
	private ResourceContext resourceContext;

	@Override
	public ValidationConfig getContext(final Class<?> type) {
		return new ValidationConfig().constraintValidatorFactory(
				resourceContext.getResource(InjectingConstraintValidatorFactory.class)).parameterNameProvider(
				new CustomParameterNameProvider());
	}

	private class CustomParameterNameProvider implements ParameterNameProvider {

		private final ParameterNameProvider nameProvider;

		public CustomParameterNameProvider() {
			nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
		}

		@Override
		public List<String> getParameterNames(final Constructor<?> constructor) {
			return nameProvider.getParameterNames(constructor);
		}

		@Override
		public List<String> getParameterNames(final Method method) {
			return nameProvider.getParameterNames(method);
		}
	}

	public static class JsonConfiguration implements ContextResolver<MoxyJsonConfig> {

		@Override
		public MoxyJsonConfig getContext(final Class<?> type) {
			final MoxyJsonConfig config = new MoxyJsonConfig();
			config.setFormattedOutput(true);
			return config;
		}
	}
}
