package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Owner on 10/29/14.
 */
public class Task implements Serializable {

    private int projectTaskId;
    private String title;
    private String description;
    private String status;
    private String severity;
    private double cost;
    private int numberOfWorkers;
    private int percentageComplete;
    private Date startDate;
    private Date endDate;
    private boolean completed;

    private Project project;
    private Task parentTask;
    private List<TaskComment> comments;

    private List<TaskEstimatedCost> costs;


    public int getProjectTaskId() {
        return projectTaskId;
    }

    public void setProjectTaskId(int projectTaskId) {
        this.projectTaskId = projectTaskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        this.numberOfWorkers = numberOfWorkers;
    }

    public int getPercentageComplete() {
        return percentageComplete;
    }

    public void setPercentageComplete(int percentageComplete) {
        this.percentageComplete = percentageComplete;
    }

    public Task() {
    }


    @Override
    public String toString() {
        return "Task{" +
                "projectTaskId='" + projectTaskId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", severity='" + severity + '\'' +
                ", cost=" + cost +
                ", numberOfWorkers=" + numberOfWorkers +
                ", percentageComplete=" + percentageComplete +
                '}';
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<TaskComment> getComments() {
        return comments;
    }

    public void setComments(List<TaskComment> comments) {
        this.comments = comments;
    }

    public List<TaskEstimatedCost> getCosts() {
        return costs;
    }

    public void setCosts(List<TaskEstimatedCost> costs) {
        this.costs = costs;
    }
}
