package com.ontarget.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormater {
	private static final DateFormat yearMonthDayFormat = new SimpleDateFormat("yyyy-MM-dd");

	public static java.util.Date getFormattedDate(Date date) {
		try {
			String strDate = yearMonthDayFormat.format(date);
			java.util.Date result = yearMonthDayFormat.parse(strDate);
			return result;
		} catch (Exception ex) {
			return null;
		}
	}

	public static java.util.Date addDays(java.util.Date oldDate, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(oldDate);
		calendar.add(5, days);
		return calendar.getTime();
	}

	public static java.util.Date addMonths(java.util.Date oldDate, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(oldDate);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}

	public static java.sql.Date utilDateToSqlDate(java.util.Date uDate) throws ParseException {
		DateFormat sqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		return java.sql.Date.valueOf(sqlDateFormatter.format(uDate));
	}

	public static String convertToString(java.util.Date date, String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(date);
	}

	public static Date convertToDate(String date) throws ParseException {
		DateFormat sqlDateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		return sqlDateFormatter.parse(date);
	}

	public static java.util.Date changeFormat(java.util.Date date, String format) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
			String formatedDate = simpleDateFormat.format(date);
			return simpleDateFormat.parse(formatedDate);
		} catch (ParseException e) {
			return null;
		}
	}

}
