package com.ontarget.api.service;

import com.ontarget.dto.AddDocumentAttachmentRequest;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.dto.AddDocumentRequest;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentAttachmentsResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;

public interface DocumentService {
	public AddDocumentResponse addDocument(AddDocumentRequest request) throws Exception;

    public OnTargetResponse updateDocument(UpdateDocumentDataRequest request) throws Exception;

    public GetDocumentsResponse getDocuments(String userName, long projectId) throws Exception;

    public OnTargetResponse updateStatus(UpdateDocumentStatusRequest request) throws Exception;

    public GetDocumentResponse getDocument(long documentId) throws Exception;

    public AddDocumentAttachmentResponse addDocumentAttachment(AddDocumentAttachmentRequest request) throws Exception;

    public GetDocumentAttachmentsResponse getDocumentAttachments(Long documentId) throws Exception;
}
