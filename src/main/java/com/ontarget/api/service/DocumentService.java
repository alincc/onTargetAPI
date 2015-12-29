package com.ontarget.api.service;

import com.ontarget.response.bean.DocumentStatsResponse;
import com.ontarget.response.bean.GetDocumentQuestionResponse;
import com.ontarget.dto.AddDocumentAttachmentResponse;
import com.ontarget.dto.AddDocumentResponse;
import com.ontarget.dto.GetDocumentAttachmentsResponse;
import com.ontarget.dto.GetDocumentResponse;
import com.ontarget.dto.GetDocumentsResponse;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.UpdateDocumentQuestionResponse;

public interface DocumentService {

	public AddDocumentResponse addDocument(AddDocumentRequest request) throws Exception;

	public OnTargetResponse updateDocument(UpdateDocumentRequest request) throws Exception;

	public GetDocumentsResponse getDocuments(Integer userId, int projectId) throws Exception;

	public OnTargetResponse updateStatus(UpdateDocumentStatus request) throws Exception;

    public AddDocumentAttachmentResponse deleteDocumentAttachment(DeleteDocumentAttachmentRequest request) throws Exception;

    public GetDocumentResponse getDocument(int documentId) throws Exception;

    public UpdateDocumentQuestionResponse saveDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) throws Exception;

    public UpdateDocumentQuestionResponse deleteDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) throws Exception;

    public AddDocumentAttachmentResponse addDocumentAttachment(AddDocumentAttachment request) throws Exception;

	public GetDocumentAttachmentsResponse getDocumentAttachments(int documentId) throws Exception;

    public GetDocumentQuestionResponse getDocumentQuestionsResponses(GetDocumentQuestionResponseRequest request) throws Exception;

    public UpdateDocumentQuestionResponse updateDocumentQuestionResponse(UpdateDocumentQuestionResponseRequest request) throws Exception;

    public DocumentStatsResponse getDocumentStatisticsByProject(Integer loggedInUserProjectId) throws Exception;

    public DocumentStatsResponse getDocumentStatisticsByUserByProject(Integer loggedInUserId, Integer loggedInUserProjectId1);
}
