package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddProjectFileTagRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;
import com.ontarget.response.bean.ProjectFileTagResponse;

public interface ProjectFileTagging {

	OnTargetResponse save(@Valid AddProjectFileTagRequest request);

	ProjectFileTagResponse getProjectFileTags(@Valid GetProjectFileTagRequest request);
}
