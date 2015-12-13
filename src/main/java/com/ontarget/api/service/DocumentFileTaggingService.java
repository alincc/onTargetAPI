package com.ontarget.api.service;

import java.util.List;

import com.ontarget.bean.DocumentFileTagBean;
import com.ontarget.request.bean.GetDocumentFileTagRequest;
import com.ontarget.response.bean.DocumentFileTagResponse;

public interface DocumentFileTaggingService {
	DocumentFileTagResponse save(List<DocumentFileTagBean> tags, int userId) throws Exception;

	List<DocumentFileTagBean> getDocumentFileTags(GetDocumentFileTagRequest request) throws Exception;
}
