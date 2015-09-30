package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.ProjectDetailRequest;

public interface TaskBurnDown {

	OnTargetResponse getTaskBurnDownOfProject(@Valid ProjectDetailRequest request);

}
