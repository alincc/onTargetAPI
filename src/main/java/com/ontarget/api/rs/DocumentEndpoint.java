package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.*;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;

import javax.ws.rs.*;

public interface DocumentEndpoint {

	public AddDocumentResponse addDocument(@Valid AddDocumentRequest request);

	public OnTargetResponse updateDocumentData(
			@Valid UpdateDocumentRequest request);

	public OnTargetResponse updateDocumentStatus(
			@Valid UpdateDocumentStatus request);

	public GetDocumentsResponse getDocuments(@Valid UserDocument userDocument);

	public GetDocumentResponse getDocument(@Valid DocumentDetail documentDetail);

	public OnTargetResponse addDocumentAttachment(
			@Valid AddDocumentAttachment request);

    public AddDocumentAttachmentResponse deleteDocumentAttachment(@Valid DeleteDocumentAttachmentRequest request);

    GetDocumentQuestionResponse getDocumentQuestionResponse(@Valid GetDocumentQuestionResponseRequest request);

    UpdateDocumentQuestionResponse addDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);

    UpdateDocumentQuestionResponse updateDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);

    UpdateDocumentQuestionResponse deleteDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);
}
