package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.FileUploadResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.UploadDocumentRequest;
import com.ontarget.request.bean.UploadedFileDetail;

public interface UploadDocumentEndPoint {
	public OnTargetResponse saveUploadedDocsInfo(
			@Valid UploadDocumentRequest requestData);

	public FileUploadResponse getUploadedFile(
			@Valid UploadedFileDetail uploadedFileDetailBean);
}
