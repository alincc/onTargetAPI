package com.ontarget.api.service;

import com.ontarget.dto.AddDocumentRequest;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;

public interface DocumentService {
	AddDocumentResponse addDocument(AddDocumentRequest request) throws Exception;
	OnTargetResponse updateDocument(UpdateDocumentDataRequest request) throws Exception;
	OnTargetResponse updateStatus(UpdateDocumentStatusRequest request) throws Exception;
	GetDocumentsResponse getDocuments(String userName) throws Exception;
}
