package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import com.ontarget.request.bean.*;
import org.junit.Test;

public class DocumentEndpointTest extends BaseTest {

	@Test
	public void addDocument() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(10);
		baseRequest.setLoggedInUserProjectId(42);

		AddDocumentRequest documentRequest = new AddDocumentRequest();
		documentRequest.setBaseRequest(baseRequest);

		documentRequest.setDocumentTemplateId(1);
		documentRequest.setDocumentName("test doc");
		documentRequest.setDueDate(new java.sql.Date(new Date().getTime()));
		documentRequest.setProjectId(42);

		List<Assignee> assignees = new ArrayList<>();
		Assignee assignee = new Assignee();
		assignee.setUserId(10);
		assignee.setUsername("santosh8pun@gmail.com");
		assignees.add(assignee);

		List<DocumentKeyValue> keyValues = new ArrayList<>();
		DocumentKeyValue documentKeyValue = new DocumentKeyValue();
		documentKeyValue.setKey("name");
		documentKeyValue.setValue("Santosh Pun");
		keyValues.add(documentKeyValue);

		List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();
		DocumentGridKeyValue documentGridKeyValue = new DocumentGridKeyValue();
		documentGridKeyValue.setGridId("C000");
		documentGridKeyValue.setGridRowIndex(1);
		documentGridKeyValue.setKey("gridkey1");
		documentGridKeyValue.setValue("gridkeyvalue");

		gridKeyValues.add(documentGridKeyValue);

		documentRequest.setSubmittedBy(10);
		documentRequest.setAssignees(assignees);
		documentRequest.setKeyValues(keyValues);
		documentRequest.setGridKeyValues(gridKeyValues);

		System.out.println("Client request....addDocument \n");
		System.out.println(toJsonString(documentRequest, true));
		Response response = sendPutRequest("/documents", documentRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void updateDocumentData() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		UpdateDocumentRequest request = new UpdateDocumentRequest();
		request.setDocumentId(2);
		request.setDueDate(new java.sql.Date(new Date().getTime()));

		request.setBaseRequest(baseRequest);

		List<DocumentKeyValue> keyValues = new ArrayList<>();
		DocumentKeyValue documentKeyValue = new DocumentKeyValue();
		documentKeyValue.setKey("name1");
		documentKeyValue.setValue("keyvalue123");
		keyValues.add(documentKeyValue);

		request.setKeyValues(keyValues);

		List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();
		DocumentGridKeyValue documentGridKeyValue = new DocumentGridKeyValue();
		documentGridKeyValue.setGridId("C0001");
		documentGridKeyValue.setGridRowIndex(1);
		documentGridKeyValue.setKey("gridkey2");
		documentGridKeyValue.setValue("** PC1");
		gridKeyValues.add(documentGridKeyValue);

		request.setGridKeyValues(gridKeyValues);

		request.setSubmittedBy(11);

		System.out.println("Client request....updateDocumentData \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/document", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void status() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		UpdateDocumentStatus request = new UpdateDocumentStatus();
		request.setDocumentId(1);

		request.setBaseRequest(baseRequest);

		request.setModifiedBy(11);
		request.setNewStatus("APPROVED");

		System.out.println("Client request....status \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/document/status", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getDocuments() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		UserDocument request = new UserDocument();
		request.setBaseRequest(baseRequest);
		request.setProjectId(45);

		System.out.println("Client request....getDocuments \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/document/getUserDocument", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getDocument() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		DocumentDetail request = new DocumentDetail();
		request.setBaseRequest(baseRequest);
		request.setDcoumentId(1);

		System.out.println("Client request....getDocument \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/document/getDocument", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void addDocumentAttachment() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		AddDocumentAttachment request = new AddDocumentAttachment();
		request.setBaseRequest(baseRequest);
		request.setAddedBy(11);
		request.setDocumentId(1);
		request.setFilePath("/home/ontargetrs/sa.jpg");

		System.out.println("Client request....addDocumentAttachment \n");
		System.out.println(toJsonString(request, true));
		Response response = sendPutRequest("/document/attachment/save", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void deleteDocumentAttachment() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		DeleteDocumentAttachmentRequest request = new DeleteDocumentAttachmentRequest();
		request.setBaseRequest(baseRequest);
		request.setDocumentAttachmentId(1L);

		System.out.println("Client request....deleteDocumentAttachment \n");
		System.out.println(toJsonString(request, true));
		Response response = sendPutRequest("/document/attachment/delete", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void getDocumentAttachment() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(45);

		GetDocumentAttachmentRequest request = new GetDocumentAttachmentRequest();
		request.setDocumentId(1);
		request.setBaseRequest(baseRequest);

		System.out.println("Client request....getDocumentAttachment \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/document/attachment/getAll", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void addDocumentQuestionResponse() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(43);

		UpdateDocumentQuestionResponseRequest request = new UpdateDocumentQuestionResponseRequest();
		request.setBaseRequest(baseRequest);
		request.setResponse("Test question?");
		request.setDocumentId(2);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendPutRequest("/document/response/save", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void updateDocumentQuestionResponse() {
		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(11);
		baseRequest.setLoggedInUserProjectId(43);

		UpdateDocumentQuestionResponseRequest request = new UpdateDocumentQuestionResponseRequest();
		request.setBaseRequest(baseRequest);
		request.setResponse("Test question?");
		request.setDocumentId(2);
		request.setDocumentResponseId(1);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/document/response/save", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
