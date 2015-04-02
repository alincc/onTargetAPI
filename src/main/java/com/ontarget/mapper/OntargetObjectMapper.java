package com.ontarget.mapper;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.SimpleDateFormat;

/**
 * Created by Owner on 12/24/14.
 */
@Component
@Provider
public class OntargetObjectMapper implements ContextResolver<ObjectMapper> {

	private final ObjectMapper mapper;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss");

	public OntargetObjectMapper() {
		this.mapper = createObjectMapper();
	}

	private static ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();

		SerializationConfig serConfig = mapper.getSerializationConfig();
		serConfig.setDateFormat(dateFormat);

		DeserializationConfig deserializationConfig = mapper
				.getDeserializationConfig();
		deserializationConfig.setDateFormat(dateFormat);

		// mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
		// true);
		// mapper.setDateFormat(dateFormat);
		// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
		// return mapper;

		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
				false);
		mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);

		System.out.println("ontarget object mapper called.");

		return mapper;
	}

	@Override
	public ObjectMapper getContext(Class<?> aClass) {
		return this.mapper;
	}

}
