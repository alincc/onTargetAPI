package com.ontarget.api.service;

import com.ontarget.dto.UploadActivityResponse;
import com.ontarget.request.bean.UploadActivityRequest;

public interface UploadActivityService {

	public UploadActivityResponse createActivity(UploadActivityRequest request) throws Exception;
}
