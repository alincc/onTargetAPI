package com.ontarget.bean;

import com.ontarget.util.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Owner on 11/17/14.
 */
public class TaskEstimatedCost implements Serializable{

    private int id;
    private Task task;
    private Date fromDate;
    private Date toDate;
    private String costType; // PLANNED OR ESTIMATED
    private Double cost;
    private int month;
    private int year;
    private String createdBy;

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

    public TaskEstimatedCost() {
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getCostType() {
        return costType;
    }

    public void setCostType(String costType) {
        this.costType = costType;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "TaskEstimatedCost{" +
                "task=" + task +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", costType='" + costType + '\'' +
                ", cost=" + cost +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskEstimatedCost)) return false;

        TaskEstimatedCost cost1 = (TaskEstimatedCost) o;

        if (id != cost1.id) return false;
        if (month != cost1.month) return false;
        if (year != cost1.year) return false;
        if (!cost.equals(cost1.cost)) return false;
        if (!costType.equals(cost1.costType)) return false;
        if (!fromDate.equals(cost1.fromDate)) return false;
        if (!task.equals(cost1.task)) return false;
        if (!toDate.equals(cost1.toDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + task.hashCode();
        result = 31 * result + fromDate.hashCode();
        result = 31 * result + toDate.hashCode();
        result = 31 * result + costType.hashCode();
        result = 31 * result + cost.hashCode();
        result = 31 * result + month;
        result = 31 * result + year;
        return result;
    }


    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
