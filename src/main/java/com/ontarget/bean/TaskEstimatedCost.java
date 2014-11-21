package com.ontarget.bean;

import java.util.Date;

/**
 * Created by Owner on 11/17/14.
 */
public class TaskEstimatedCost {

    private int id;
    private Task task;
    private Date fromDate;
    private Date toDate;
    private String costType; // PLANNED OR ESTIMATED
    private Double cost;

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
}
