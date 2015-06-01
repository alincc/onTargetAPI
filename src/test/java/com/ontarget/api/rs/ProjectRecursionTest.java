package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import com.ontarget.bean.ProjectDTO;
import com.ontarget.dto.ProjectTask;

public class ProjectRecursionTest {

	

	public static List<ProjectDTO> setProjects(ProjectDTO projectDTO, int level) {
		List<ProjectDTO> childProjects = new ArrayList<>();
		ProjectDTO project = new ProjectDTO();
		project.setProjectName("proj" + level);
		childProjects.add(project);
		if (level < 4) {
			level++;
			for (ProjectDTO p : childProjects) {
				setProjects(projectDTO, level);
			}
		}
		projectDTO.setProjects(childProjects);
		return childProjects;
	}

	public static void main(String args[]) {
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setProjectName("proj1");
		
		setProjects(projectDTO, 1);
		
		
		
	}
}
