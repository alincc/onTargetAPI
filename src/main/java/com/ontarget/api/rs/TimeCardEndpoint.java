package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.api.constraint.TimeCardTimeRange;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddTimeCardRequest;

public interface TimeCardEndpoint {

	OnTargetResponse addTimeCard(@TimeCardTimeRange @Valid AddTimeCardRequest request);

}
