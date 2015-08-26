package com.ontarget.api.rs;

import java.io.InputStream;

import javax.validation.Valid;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.ontarget.dto.UploadActivityResponse;
import com.ontarget.request.bean.UploadActivityRequest;

public interface UploadActivityEndpoint {

	public UploadActivityResponse createActivity(@Valid UploadActivityRequest uploadActivityRequest);

	UploadActivityResponse uploadExcelFile(InputStream fileInputStream, FormDataContentDisposition fileFormDataContentDisposition,
			Integer projectId, Integer userId);

}
