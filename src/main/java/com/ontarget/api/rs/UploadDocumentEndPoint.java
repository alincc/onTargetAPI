package com.ontarget.api.rs;

import com.ontarget.dto.FileUploadResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UploadDocumentRequest;

public interface UploadDocumentEndPoint {
	 public OnTargetResponse saveUploadedDocsInfo(UploadDocumentRequest requestData);
	 public FileUploadResponse getUploadedFile(int projectId);
}
