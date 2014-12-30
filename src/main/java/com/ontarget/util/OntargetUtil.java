package com.ontarget.util;

import com.ontarget.bean.TaskInterval;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Owner on 12/4/14.
 */
public class OntargetUtil {


    /**
     * Get time intervals between two dates
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<TaskInterval> getTimeInterval(Date startDate, Date endDate) {
        List<TaskInterval> taskIntervals = new LinkedList<>();

        Calendar startCal = null;
        if (startDate != null) {
            startCal = Calendar.getInstance();
            startCal.setTime(startDate);

        }
        int month = 0;
        int year = 0;

        Calendar endCal = null;
        int endMonth = 0;
        int endYear = 0;
        if (endDate != null) {
            endCal = Calendar.getInstance();
            endCal.setTime(endDate);
            endYear = endCal.get(Calendar.YEAR);
            endMonth = endCal.get(Calendar.MONTH);

        }

        boolean run = true;
        while (run) {

            TaskInterval taskInterval = new TaskInterval();
            month = startCal.get(Calendar.MONTH);
            year = startCal.get(Calendar.YEAR);
            taskInterval.setYear(year);
            taskInterval.setMonth(month+1);
            taskIntervals.add(taskInterval);

            startCal.add(Calendar.MONTH, 1);

            if (year < endYear) {
                run = true;
            } else if (year == endYear) {
                if (month < endMonth) {
                    run = true;
                }else{
                    run=false;
                }
            } else {
                run = false;
            }
        }

        Comparator<TaskInterval> byYear = (o1, o2) -> Integer.valueOf(o1.getYear()).compareTo(Integer.valueOf(o2.getYear()));
        Comparator<TaskInterval> byMonth = (o1, o2) -> Integer.valueOf(o1.getMonth()).compareTo(Integer.valueOf(o2.getMonth()));
        taskIntervals.stream().sorted(byYear.thenComparing(byMonth));

        return taskIntervals;
    }

    public static void main(String args[]) throws Exception {
        String string = "January 1, 2014";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date startdate = format.parse(string);

        string = "January 1, 2015";
        Date endDate = format.parse(string);

        List<TaskInterval> intervals = getTimeInterval(startdate, endDate);

//        System.out.println(intervals);

    }


}
