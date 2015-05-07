package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.api.constraint.TimeCardTimeRange;
import com.ontarget.api.constraint.TimeCardTimeRangeForEdit;
import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;
import com.ontarget.request.bean.UpdateTimeCardRequest;

public interface TimeCardEndpoint {

	OnTargetResponse addTimeCard(@TimeCardTimeRange @Valid AddTimeCardRequest request);

	OnTargetResponse edit(@TimeCardTimeRangeForEdit @Valid UpdateTimeCardRequest request);

	OnTargetResponse addFieldWorker(@Valid AddFieldWorkerRequest request);

	OnTargetResponse editFieldWorker(@Valid UpdateFieldWorkerRequest request);

	FieldWorkerResponse getFieldWorkers();

}
