package com.ontarget.api.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import com.ontarget.api.config.ValidationConfigurationContextResolver.JsonConfiguration;
import com.ontarget.api.filter.AuthorizationFilter;

@ApplicationPath("resources")
public class JerseyResourceInitializer extends ResourceConfig {
	public JerseyResourceInitializer() {
		packages("com.ontarget.api.rs.impl");
		register(AuthorizationFilter.class);
		register(ValidationConfigurationContextResolver.class);
		register(ValidationExceptionMapper.class);
		//register(OntargetObjectMapper.class);

		property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
		property(ServerProperties.TRACING, true);
		property(
				ServerProperties.BV_DISABLE_VALIDATE_ON_EXECUTABLE_OVERRIDE_CHECK,
				true);
		register(MoxyJsonFeature.class);
		register(JsonConfiguration.class);
	}

}