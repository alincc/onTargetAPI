package com.ontarget.api.service;

import java.util.List;

import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.request.bean.UploadDocumentRequest;

public interface UploadDocumentService {
	 public boolean saveUploadedDocsInfo(UploadDocumentRequest documentInfo) throws Exception;
	 public List<UploadedDocumentDetail> getUploadedFile(int projectId) throws Exception;
}
