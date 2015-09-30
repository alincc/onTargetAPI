package com.ontarget.util;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Weeks;

public class JodaDateTimeUtil {
	public static final String sqlDateFormat = "yyyy-MM-dd";

	public static int getWeekDifference(Date fromDate, Date toDate) {
		DateTime dateTime1 = new DateTime(fromDate);
		DateTime dateTime2 = new DateTime(toDate);

		int weeks = Weeks.weeksBetween(dateTime1, dateTime2).plus(1).getWeeks();
		return weeks;
	}

	public static int getDayDifference(Date fromDate, Date toDate) {
		DateTime dateTime1 = new DateTime(fromDate);
		DateTime dateTime2 = new DateTime(toDate);

		int days = Days.daysBetween(dateTime1, dateTime2).plus(1).getDays();
		return days;
	}

	public static DateTime addDays(DateTime date,int day) {
		DateTime increasedDate = date.plusDays(day);
		return increasedDate;
	}

	public static String getFormattedDate(DateTime date, String convertFormat) {
		return date.toString(convertFormat);
	}

}
