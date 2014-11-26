package com.ontarget.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by Owner on 10/29/14.
 */
public class Task implements Serializable{

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
    private User assignedTo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (Double.compare(task.cost, cost) != 0) return false;
        if (percentageComplete != task.percentageComplete) return false;
        if (projectTaskId != task.projectTaskId) return false;
        if (description != null ? !description.equals(task.description) : task.description != null) return false;
        if (!endDate.equals(task.endDate)) return false;
        if (!severity.equals(task.severity)) return false;
        if (!startDate.equals(task.startDate)) return false;
        if (!status.equals(task.status)) return false;
        if (!title.equals(task.title)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = projectTaskId;
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + status.hashCode();
        result = 31 * result + severity.hashCode();
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + percentageComplete;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }
}
