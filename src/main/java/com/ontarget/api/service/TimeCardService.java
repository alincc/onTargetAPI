package com.ontarget.api.service;

import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;
import com.ontarget.request.bean.UpdateTimeCardRequest;

public interface TimeCardService {

	OnTargetResponse addTimeCard(AddTimeCardRequest request) throws Exception;

	OnTargetResponse editTimeCard(UpdateTimeCardRequest request) throws Exception;

	OnTargetResponse addFieldWorker(AddFieldWorkerRequest request) throws Exception;

	OnTargetResponse editFieldWorker(UpdateFieldWorkerRequest request) throws Exception;

	FieldWorkerResponse fetchAllFieldWorkers() throws Exception;
}
