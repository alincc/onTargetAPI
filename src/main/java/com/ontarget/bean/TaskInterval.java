package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by Owner on 11/22/14.
 */
public class TaskInterval implements Serializable {

    private int month;
    private int year;

    public TaskInterval() {
    }

    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskInterval)) return false;

        TaskInterval that = (TaskInterval) o;

        if (month != that.month) return false;
        if (year != that.year) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = month;
        result = 31 * result + year;
        return result;
    }

    @Override
    public String toString() {
        return "TaskInterval{" +
                "month=" + month +
                ", year=" + year +
                '}';
    }
}
