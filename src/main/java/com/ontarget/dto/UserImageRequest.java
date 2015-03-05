package com.ontarget.dto;

import java.io.Serializable;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by sumit on 12/18/14.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "userId", "newPassword", "currentPassword" })
public class UserImageRequest implements Serializable {
	private Integer userId;
	private String imagePath;
	private Integer modifyingUser;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getModifyingUser() {
		return modifyingUser;
	}

	public void setModifyingUser(Integer modifyingUser) {
		this.modifyingUser = modifyingUser;
	}

}
