package com.ontarget.dto;

import java.util.List;

import lombok.Data;

import com.ontarget.bean.ProjectDTO;

/**
 * Created by Owner on 11/6/14.
 */
@Data
public class ProjectListResponse extends OnTargetResponse {

	private static final long serialVersionUID = 1L;
	private ProjectDTO mainProject;
	private List<ProjectDTO> projects;

}