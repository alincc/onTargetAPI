package com.ontarget.dto;

import java.io.Serializable;

/**
 * Created by sumit on 12/18/14.
 */
public class UserImageRequest implements Serializable {
    private long userId;
    private String imagePath;
    private long modifyingUser;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getModifyingUser() {
        return modifyingUser > 0 ? modifyingUser : userId;
    }

    public void setModifyingUser(long modifyingUser) {
        this.modifyingUser = modifyingUser;
    }
}
