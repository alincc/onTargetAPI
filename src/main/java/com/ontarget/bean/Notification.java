package com.ontarget.bean;

import java.io.Serializable;

/**
 * Created by sumit on 12/26/14.
 */
public class Notification implements Serializable {
    private long id;
    private String text;
    private long category;
    private long tsInsert;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public long getTsInsert() {
        return tsInsert;
    }

    public void setTsInsert(long tsInsert) {
        this.tsInsert = tsInsert;
    }
}
