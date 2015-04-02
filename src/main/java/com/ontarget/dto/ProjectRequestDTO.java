package com.ontarget.dto;

import com.ontarget.bean.ProjectDTO;
import com.ontarget.bean.UserDTO;

import java.io.Serializable;

/**
 * Created by Owner on 11/6/14.
 */
public class ProjectRequestDTO implements Serializable {

	public ProjectRequestDTO() {
	}

	private ProjectDTO project;
	private UserDTO user;

	public ProjectDTO getProject() {
		return project;
	}

	public void setProject(ProjectDTO project) {
		this.project = project;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
