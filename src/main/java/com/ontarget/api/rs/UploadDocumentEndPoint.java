package com.ontarget.api.rs;

import com.ontarget.dto.FileUploadResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UploadDocumentRequest;
import com.ontarget.request.bean.UploadDocumentRequestBean;
import com.ontarget.request.bean.UploadedFileDetailBean;

public interface UploadDocumentEndPoint {
	 public OnTargetResponse saveUploadedDocsInfo(UploadDocumentRequestBean requestData);
	 public FileUploadResponse getUploadedFile(UploadedFileDetailBean uploadedFileDetailBean);
}
