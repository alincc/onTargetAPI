package com.ontarget.tester;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

import org.joda.time.DateTime;
import org.joda.time.Weeks;

import com.ontarget.util.DateFormater;
import com.ontarget.util.JodaDateTimeUtil;

public class JodaTimeTest {

	@Data
	public static class DateRange {
		private DateTime fromDate;
		private DateTime toDate;
	}

	public static void main(String[] args) {

		// DateTime fromDate = new DateTime(new Date());
		// System.out.println("from date: "+JodaDateTimeUtil.getFormattedDate(fromDate,
		// "yyy-MM-dd"));
		// DateTime toDate = JodaDateTimeUtil.addDays(fromDate, 2);
		// System.out.println("to date: "+JodaDateTimeUtil.getFormattedDate(toDate,
		// "yyy-MM-dd"));
		
		

		DateTime date = new DateTime(new Date());
		date = date.plusDays(29);

		DateTime fromDate = new DateTime(new Date());
		DateTime toDate = new DateTime(date);

		DateTime endDate = toDate;

		System.out.println("from date: " + JodaDateTimeUtil.getFormattedDate(fromDate, "yyyy-MM-dd"));
		System.out.println("to date: " + JodaDateTimeUtil.getFormattedDate(toDate, "yyyy-MM-dd"));

		int weeks = Weeks.weeksBetween(fromDate, toDate).plus(1).getWeeks();
		System.out.println("weeks: " + weeks);

		List<DateRange> dateRanges = new ArrayList<JodaTimeTest.DateRange>();

		for (int i = 0; i < weeks; i++) {

			DateRange dateRange = new DateRange();
			dateRange.setFromDate(fromDate);
			if (i + 1 == weeks) {
				dateRange.setToDate(endDate);
			} else {
				DateTime plusDate = JodaDateTimeUtil.addDays(fromDate, 7);
				fromDate = plusDate;
				dateRange.setToDate(plusDate);

			}
			dateRanges.add(dateRange);
		}

		int i = 1;
		for (DateRange dateRange : dateRanges) {
			System.out.println("====================================" + i);

			System.out.println("from date: " + JodaDateTimeUtil.getFormattedDate(dateRange.getFromDate(), "yyy-MM-dd"));
			System.out.println("to date: " + JodaDateTimeUtil.getFormattedDate(dateRange.getToDate(), "yyy-MM-dd"));
			System.out.println("====================================");
			i++;
		}
	}
}
