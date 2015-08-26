package com.ontarget.bean;

import java.util.Date;

/**
 * Created by sanjeevghimire on 8/22/15.
 */
public class WeekInterval {

    private Date weekStartDate;
    private Date weekEndDate;
    private int weekNum;

    public Date getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(Date weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public Date getWeekEndDate() {
        return weekEndDate;
    }

    public void setWeekEndDate(Date weekEndDate) {
        this.weekEndDate = weekEndDate;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeekInterval)) return false;

        WeekInterval that = (WeekInterval) o;

        if (weekNum != that.weekNum) return false;
        if (!weekEndDate.equals(that.weekEndDate)) return false;
        if (!weekStartDate.equals(that.weekStartDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = weekStartDate.hashCode();
        result = 31 * result + weekEndDate.hashCode();
        result = 31 * result + weekNum;
        return result;
    }

    @Override
    public String toString() {
        return "WeekInterval{" +
                "weekStartDate=" + weekStartDate +
                ", weekEndDate=" + weekEndDate +
                ", weekNum=" + weekNum +
                '}';
    }
}
