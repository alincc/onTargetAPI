package com.ontarget.util;

import com.ontarget.bean.TaskInterval;
import com.ontarget.bean.WeekInterval;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

/**
 * Created by Owner on 12/4/14.
 */
public class OntargetUtil {


    /**
     * Get time intervals month-year between two dates
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
            taskInterval.setMonth(month + 1);
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
        String string = "January 11, 2015";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date startdate = format.parse(string);

        string = "December 14, 2015";
        Date endDate = format.parse(string);

        //List<TaskInterval> intervals = getTimeInterval(startdate, endDate);

        List<WeekInterval> weeks = getAllWeeksBetweenDates(startdate,endDate);

        System.out.println(weeks);

    }


    /**
     * Get all the weeks between startdate and end date.
     * This will return the week name, week start date, week end date
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<WeekInterval> getAllWeeksBetweenDates(Date startDate, Date endDate){
        List<WeekInterval> weeks = new LinkedList<>();


        LocalDate today = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate projectEndDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int weekNum=1;
        while(today.isBefore(projectEndDate) || today.isEqual(projectEndDate)) {

            // Go backward to get Monday
            LocalDate monday = today;
            while (monday.getDayOfWeek() != DayOfWeek.MONDAY) {
                monday = monday.minusDays(1);
            }

            // Go forward to get Sunday
            LocalDate sunday = today;
            while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
                sunday = sunday.plusDays(1);
            }

            WeekInterval weekInterval = new WeekInterval();
            weekInterval.setWeekStartDate(Date.from(monday.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            weekInterval.setWeekEndDate(Date.from(sunday.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            weekInterval.setWeekNum(weekNum++);
            weeks.add(weekInterval);

            today = sunday.plusDays(1);

        }

        return weeks;
    }




}
