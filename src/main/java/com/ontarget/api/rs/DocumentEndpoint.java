package com.ontarget.api.rs;

import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddDocumentAttachment;
import com.ontarget.request.bean.AddDocumentRequest;
import com.ontarget.request.bean.DocumentDetail;
import com.ontarget.request.bean.UpdateDocumentRequest;
import com.ontarget.request.bean.UpdateDocumentStatus;
import com.ontarget.request.bean.UserDocument;

public interface DocumentEndpoint {

	public AddDocumentResponse addDocument(AddDocumentRequest request);

	public OnTargetResponse updateDocumentData(UpdateDocumentRequest request);

	public OnTargetResponse updateDocumentStatus(UpdateDocumentStatus request);

	public GetDocumentsResponse getDocuments(UserDocument userDocument);

	public GetDocumentResponse getDocument(DocumentDetail documentDetail);

	public OnTargetResponse addDocumentAttachment(AddDocumentAttachment request);
}
