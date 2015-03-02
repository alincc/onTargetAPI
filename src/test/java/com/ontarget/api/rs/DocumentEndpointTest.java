package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.request.bean.AddDocumentRequest;
import com.ontarget.request.bean.Assignee;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DocumentGridKeyValue;
import com.ontarget.request.bean.DocumentKeyValue;
import com.ontarget.request.bean.UpdateDocumentRequest;
import com.ontarget.request.bean.UpdateDocumentStatus;

public class DocumentEndpointTest extends BaseTest {

	@Test
	public void testAddDocument() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		AddDocumentRequest documentRequest = new AddDocumentRequest();
		documentRequest.setBaseRequest(baseRequest);

		documentRequest.setDocumentTemplateId(20);
		documentRequest.setDocumentName("test doc");
		documentRequest.setDueDate(new java.sql.Date(new Date().getTime()));
		documentRequest.setProjectId(0);

		List<Assignee> assignees = new ArrayList<>();
		Assignee assignee = new Assignee();
		assignee.setUserId(1);
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

		documentRequest.setSubmittedBy(1);
		documentRequest.setAssignees(assignees);
		documentRequest.setKeyValues(keyValues);
		documentRequest.setGridKeyValues(gridKeyValues);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(documentRequest, true));
		Response response = sendPutRequest("/documents", documentRequest);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void updateDocumentData() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		UpdateDocumentRequest request = new UpdateDocumentRequest();
		request.setDocumentId(139);
		request.setDueDate(new java.sql.Date(new Date().getTime()));

		request.setBaseRequest(baseRequest);

		List<DocumentKeyValue> keyValues = new ArrayList<>();
		DocumentKeyValue documentKeyValue = new DocumentKeyValue();
		documentKeyValue.setKey("name");
		documentKeyValue.setValue("keyvalue123");
		keyValues.add(documentKeyValue);

		request.setKeyValues(keyValues);

		List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();
		DocumentGridKeyValue documentGridKeyValue = new DocumentGridKeyValue();
		documentGridKeyValue.setGridId("C000");
		documentGridKeyValue.setGridRowIndex(1);
		documentGridKeyValue.setKey("gridkey1");
		documentGridKeyValue.setValue("** PC1");
		gridKeyValues.add(documentGridKeyValue);

		request.setGridKeyValues(gridKeyValues);

		request.setSubmittedBy(1);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/documents", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	@Test
	public void status() {

		BaseRequest baseRequest = new BaseRequest();
		baseRequest.setLoggedInUserId(1);
		baseRequest.setLoggedInUserProjectId(1);

		UpdateDocumentStatus request = new UpdateDocumentStatus();
		request.setDocumentId(139);

		request.setBaseRequest(baseRequest);

		request.setModifiedBy(1);
		request.setNewStatus("SUBMITTED");

		System.out.println("Client request....status \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/documents/status", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

}
