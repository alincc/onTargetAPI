package com.ontarget.api.service;

import com.ontarget.dto.FieldWorkerResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;

public interface TimeCardService {

	OnTargetResponse addTimeCard(AddTimeCardRequest request) throws Exception;

	OnTargetResponse addFieldWorker(AddFieldWorkerRequest request) throws Exception;
	
	OnTargetResponse editFieldWorker(UpdateFieldWorkerRequest request) throws Exception;
	
	FieldWorkerResponse fetchAllFieldWorkers() throws Exception;
}
