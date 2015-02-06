package com.ontarget.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Owner on 11/14/14.
 */
public class TaskComment implements Serializable{

    private int taskCommentId;
    private int taskId;
    private String comment;
    private String commentStatus;
    private int commentedBy;
    private Date commentedDate;
    private Contact commenterContact;

    public Contact getCommenterContact() {
        return commenterContact;
    }

    public void setCommenterContact(Contact commenterContact) {
        this.commenterContact = commenterContact;
    }

    public TaskComment() {
    }

    public int getTaskCommentId() {
        return taskCommentId;
    }

    public void setTaskCommentId(int taskCommentId) {
        this.taskCommentId = taskCommentId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public int getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(int commentedBy) {
        this.commentedBy = commentedBy;
    }

    public Date getCommentedDate() {
        return commentedDate;
    }

    public void setCommentedDate(Date commentedDate) {
        this.commentedDate = commentedDate;
    }

    @Override
    public String toString() {
        return "TaskComment{" +
                "taskCommentId=" + taskCommentId +
                ", taskId=" + taskId +
                ", comment='" + comment + '\'' +
                ", commentStatus='" + commentStatus + '\'' +
                ", commentedBy='" + commentedBy + '\'' +
                ", commentedDate=" + commentedDate +
                '}';
    }
}
