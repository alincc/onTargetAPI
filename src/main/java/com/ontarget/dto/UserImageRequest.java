package com.ontarget.dto;

import java.io.Serializable;

/**
 * Created by sumit on 12/18/14.
 */
public class UserImageRequest implements Serializable {
    private int userId;
    private String imagePath;
    private int modifyingUser;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getModifyingUser() {
        return modifyingUser > 0 ? modifyingUser : userId;
    }

    public void setModifyingUser(int modifyingUser) {
        this.modifyingUser = modifyingUser;
    }
}
