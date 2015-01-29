package com.ontarget.webapp.config;


import com.ontarget.api.rs.ProjectEndoint;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Owner on 1/24/15.
 */
public class OnTargetApplication extends ResourceConfig {


    public OnTargetApplication() {
        // Resources.
        packages(ProjectEndoint.class.getPackage().getName());

        // Validation.
        register(ValidationConfigurationContextResolver.class);

        // Providers - JSON.
        register(MoxyJsonFeature.class);
        register(JsonConfiguration.class);
    }


    /**
     * Configuration for {@link org.eclipse.persistence.jaxb.rs.MOXyJsonProvider} - outputs formatted JSON.
     */
    public static class JsonConfiguration implements ContextResolver<MoxyJsonConfig> {

        @Override
        public MoxyJsonConfig getContext(final Class<?> type) {
            final MoxyJsonConfig config = new MoxyJsonConfig();
            config.setFormattedOutput(true);
            return config;
        }
    }


    /**
     * Custom configuration of validation. This configuration defines custom:
     * <ul>
     *     <li>ConstraintValidationFactory - so that validators are able to inject Jersey providers/resources.</li>
     *     <li>ParameterNameProvider - if method input parameters are invalid, this class returns actual parameter names
     *     instead of the default ones ({@code arg0, arg1, ..})</li>
     * </ul>
     */
    public static class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {

        @Context
        private ResourceContext resourceContext;

        @Override
        public ValidationConfig getContext(final Class<?> type) {
            return new ValidationConfig()
                    .constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class))
                    .parameterNameProvider(new CustomParameterNameProvider());
        }

        /**
         * See ContactCardTest#testAddInvalidContact.
         */
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
//                // See ContactCardTest#testAddInvalidContact.
//                if ("addContact".equals(method.getName())) {
//                    return Arrays.asList("contact");
//                }
                return nameProvider.getParameterNames(method);
            }
        }
    }


}
