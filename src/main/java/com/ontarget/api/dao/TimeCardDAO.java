package com.ontarget.api.dao;

import com.ontarget.request.bean.AddTimeCardRequest;

public interface TimeCardDAO {

	boolean add(AddTimeCardRequest request) throws Exception;

}
