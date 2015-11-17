package com.ontarget.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.Weeks;

public class TaskBurnDownUtil {

	public static List<DateRange> getDateRangeBetweenDates(Date startDate, Date endDate) {
		DateTime fromDate = new DateTime(startDate);
		DateTime toDate = new DateTime(endDate);

		int weeks = Weeks.weeksBetween(fromDate, toDate).plus(1).getWeeks();

		List<DateRange> dateRanges = new ArrayList<DateRange>();

		for (int i = 0; i < weeks; i++) {
			DateRange dateRange = new DateRange();
			dateRange.setFromDate(fromDate);
			if (i + 1 == weeks) {
				dateRange.setToDate(toDate);
			} else {
				DateTime plusDate = JodaDateTimeUtil.addDays(fromDate, 7);
				fromDate = plusDate;
				dateRange.setToDate(plusDate);
			}
			dateRanges.add(dateRange);
		}
		return dateRanges;
	}

}
