package com.ontarget.api.service;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddTimeCardRequest;

public interface TimeCardService {

	OnTargetResponse addTimeCard(AddTimeCardRequest request) throws Exception;
}
