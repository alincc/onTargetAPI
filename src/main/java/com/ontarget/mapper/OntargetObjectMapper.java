package com.ontarget.mapper;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
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

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	public OntargetObjectMapper() {
		this.mapper = createObjectMapper();
	}

	private static ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		

		SerializationConfig serConfig = mapper.getSerializationConfig();
		serConfig.with(dateFormat);

		DeserializationConfig deserializationConfig = mapper.getDeserializationConfig();
		deserializationConfig.with(dateFormat);

		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		return mapper;
	}

	@Override
	public ObjectMapper getContext(Class<?> aClass) {
		return this.mapper;
	}

}
