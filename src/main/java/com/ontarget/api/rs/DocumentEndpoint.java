package com.ontarget.api.rs;

import com.ontarget.dto.*;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.DocumentStatsResponse;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public interface DocumentEndpoint {

	public AddDocumentResponse addDocument(@Valid AddDocumentRequest request);

	public OnTargetResponse updateDocumentData(@Valid UpdateDocumentRequest request);

	public OnTargetResponse updateDocumentStatus(@Valid UpdateDocumentStatus request);

	public GetDocumentsResponse getDocuments(@Valid UserDocument userDocument);

	public GetDocumentResponse getDocument(@Valid DocumentDetail documentDetail);

	public OnTargetResponse addDocumentAttachment(@Valid AddDocumentAttachment request);

	public AddDocumentAttachmentResponse deleteDocumentAttachment(@Valid DeleteDocumentAttachmentRequest request);

	public GetDocumentQuestionResponse getDocumentQuestionResponse(@Valid GetDocumentQuestionResponseRequest request);

	public UpdateDocumentQuestionResponse addDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);

	public UpdateDocumentQuestionResponse updateDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);

	public UpdateDocumentQuestionResponse deleteDocumentQuestionResponse(@Valid UpdateDocumentQuestionResponseRequest request);

    public GetDocumentAttachmentsResponse getDocumentAttachments(@Valid GetDocumentAttachmentRequest request);

    public DocumentStatsResponse getDocumentStatisticsByProject(@Valid DocumentStatsRequest request);

    public DocumentStatsResponse getDocumentStatsByUserByProject(@Valid DocumentStatsRequest request);
}
