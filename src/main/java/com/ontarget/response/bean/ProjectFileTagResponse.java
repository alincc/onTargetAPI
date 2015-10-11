package com.ontarget.response.bean;

import java.util.List;

import lombok.Data;

import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.dto.OnTargetResponse;

@Data
public class ProjectFileTagResponse extends OnTargetResponse {
	private List<ProjectFileTagBean> tags;

}
