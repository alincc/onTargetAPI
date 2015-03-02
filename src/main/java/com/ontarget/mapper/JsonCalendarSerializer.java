package com.ontarget.mapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

public class JsonCalendarSerializer extends JsonSerializer<Calendar> {

	public static final String DATE_FORMAT = "yyyy-MM-dd";

	@Override
	public void serialize(Calendar date, JsonGenerator gen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat(
				JsonCalendarSerializer.DATE_FORMAT);
		String formattedDate = formatter.format(date.getTime());
		gen.writeString(formattedDate);
	}
}
