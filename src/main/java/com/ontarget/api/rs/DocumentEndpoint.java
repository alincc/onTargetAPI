package com.ontarget.api.rs;

import com.ontarget.dto.AddDocumentAttachmentRequest;
import com.ontarget.dto.AddDocumentRequest;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentAttachmentsResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;

public interface DocumentEndpoint {
	AddDocumentResponse addDocument(AddDocumentRequest request);
	OnTargetResponse updateDocumentData(UpdateDocumentDataRequest request);
	OnTargetResponse updateDocumentStatus(UpdateDocumentStatusRequest request);
	GetDocumentsResponse getDocuments(String userName);
	OnTargetResponse addDocumentAttachment(AddDocumentAttachmentRequest request);
	GetDocumentAttachmentsResponse getDocumentAttachments(Long documentId);
}
