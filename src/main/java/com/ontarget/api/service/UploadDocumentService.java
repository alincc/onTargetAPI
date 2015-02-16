package com.ontarget.api.service;

import java.util.List;

import com.ontarget.dto.UploadDocumentRequest;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.request.bean.UploadDocumentRequestBean;

public interface UploadDocumentService {
	 public boolean saveUploadedDocsInfo(UploadDocumentRequestBean documentInfo) throws Exception;
	 public List<UploadedDocumentDetail> getUploadedFile(int projectId) throws Exception;
}
