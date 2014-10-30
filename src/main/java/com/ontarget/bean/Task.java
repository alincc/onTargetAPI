package com.ontarget.bean;

/**
 * Created by Owner on 10/29/14.
 */
public class Task {

    private String taskId;
    private String taskTitle;
    private String taskDescrition;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescrition() {
        return taskDescrition;
    }

    public void setTaskDescrition(String taskDescrition) {
        this.taskDescrition = taskDescrition;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId='" + taskId + '\'' +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskDescrition='" + taskDescrition + '\'' +
                '}';
    }
}
