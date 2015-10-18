package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.AddDocumentAttachment;
import com.ontarget.request.bean.AddDocumentRequest;
import com.ontarget.request.bean.DeleteDocumentAttachmentRequest;
import com.ontarget.request.bean.DocumentDetail;
import com.ontarget.request.bean.GetDocumentQuestionResponseRequest;
import com.ontarget.request.bean.UpdateDocumentQuestionResponseRequest;
import com.ontarget.request.bean.UpdateDocumentRequest;
import com.ontarget.request.bean.UpdateDocumentStatus;
import com.ontarget.request.bean.UserDocument;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;

public interface DocumentEndpoint {

	public AddDocumentResponse addDocument(@Valid AddDocumentRequest request);

	public OnTargetResponse updateDocumentData(@Valid UpdateDocumentRequest request);

	public OnTargetResponse updateDocumentStatus(@Valid UpdateDocumentStatus request);

	public GetDocumentsResponse getDocuments(@Valid UserDocument userDocument);

	public GetDocumentResponse getDocument(@Valid DocumentDetail documentDetail);

	public OnTargetResponse addDocumentAttachment(@Valid AddDocumentAttachment request);

	public AddDocumentAttachmentResponse deleteDocumentAttachment(@Valid DeleteDocumentAttachmentRequest request);

	GetDocumentQuestionResponse getDocumentQuestionResponse(@Valid GetDocumentQuestionResponseRequest request);

	UpdateDocumentQuestionResponse addDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);

	UpdateDocumentQuestionResponse updateDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);

	UpdateDocumentQuestionResponse deleteDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);
}
