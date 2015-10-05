package com.ontarget.api.service;

import com.ontarget.response.bean.TaskBurnDownListResponse;

public interface TaskBurnDownService {

	TaskBurnDownListResponse getTaskBurnDownOfProject(Integer projectId) throws Exception;

}
