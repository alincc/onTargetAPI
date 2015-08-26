package com.ontarget.response.bean;

import java.util.List;

import com.ontarget.dto.OnTargetResponse;

import lombok.Data;

@Data
public class ProjectFileCategoryListResponse extends OnTargetResponse {
	private static final long serialVersionUID = 1L;
	private List<ProjectFileCategory> categories;
}
