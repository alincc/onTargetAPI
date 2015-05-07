package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.entities.FieldWorker;
import com.ontarget.request.bean.AddFieldWorkerRequest;
import com.ontarget.request.bean.AddTimeCardRequest;
import com.ontarget.request.bean.UpdateFieldWorkerRequest;
import com.ontarget.request.bean.UpdateTimeCardRequest;

public interface TimeCardDAO {

	boolean add(AddTimeCardRequest request) throws Exception;
	
	boolean update(UpdateTimeCardRequest request) throws Exception;

	boolean addFieldWorker(AddFieldWorkerRequest request) throws Exception;

	boolean updateFieldWorker(UpdateFieldWorkerRequest request) throws Exception;
	
	List<FieldWorker> getAllFieldWorkers() throws Exception;

}
