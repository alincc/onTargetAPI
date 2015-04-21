package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.UploadActivityResponse;
import com.ontarget.request.bean.UploadActivityRequest;

public interface UploadActivityEndpoint {

	public UploadActivityResponse createActivity(@Valid UploadActivityRequest uploadActivityRequest);

}
