package com.ontarget.bean;

/**
 * Created by sanjeevghimire on 8/22/15.
 */
public class TaskBurndownReport {

    private WeekInterval weekInterval;
    private int completedTaskCount;
    private int incompleteTaskCount;

    public WeekInterval getWeekInterval() {
        return weekInterval;
    }

    public void setWeekInterval(WeekInterval weekInterval) {
        this.weekInterval = weekInterval;
    }

    public int getCompletedTaskCount() {
        return completedTaskCount;
    }

    public void setCompletedTaskCount(int completedTaskCount) {
        this.completedTaskCount = completedTaskCount;
    }

    public int getIncompleteTaskCount() {
        return incompleteTaskCount;
    }

    public void setIncompleteTaskCount(int incompleteTaskCount) {
        this.incompleteTaskCount = incompleteTaskCount;
    }
}
