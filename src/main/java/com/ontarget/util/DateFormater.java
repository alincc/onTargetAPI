package com.ontarget.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
	private static final DateFormat yearMonthDayFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static java.util.Date getFormattedDate(Date date) {
		try {
			String strDate = yearMonthDayFormat.format(date);
			java.util.Date result = yearMonthDayFormat.parse(strDate);
			return result;
		} catch (Exception ex) {
			return null;
		}
	}

}
