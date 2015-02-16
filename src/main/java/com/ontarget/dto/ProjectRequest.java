package com.ontarget.dto;

import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.User;

import java.io.Serializable;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectRequest implements Serializable {

	public ProjectRequest() {
	}

	private ProjectDTO project;
	private User user;

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
