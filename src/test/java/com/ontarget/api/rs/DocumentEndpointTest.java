package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ontarget.bean.DocumentGridKeyValueDTO;
import com.ontarget.bean.DocumentKeyValueDTO;
import com.ontarget.bean.UserDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentAttachmentRequest;
import com.ontarget.dto.AddDocumentRequestDTO;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;
import com.ontarget.request.bean.Assignee;
import com.ontarget.request.bean.DocumentGridKeyValue;
import com.ontarget.request.bean.DocumentKeyValue;
import com.ontarget.request.bean.AddDocumentRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class DocumentEndpointTest extends BaseTest {

	public DocumentEndpointTest() throws TestContainerException {
		super("com.ontarget.api.rs");
	}

	@Test
	public void addDocument() {
		AddDocumentRequest documentRequest = new AddDocumentRequest();
		documentRequest.setDocumentTemplateId(20);
		documentRequest.setDocumentName("test doc");
		documentRequest.setDueDate(new Date());

		List<Assignee> assignees = new ArrayList<>();
		Assignee assignee = new Assignee();
		assignee.setUserId(1);
		assignee.setUsername("sanjeev@ontargetcloud.com");
		assignees.add(assignee);

		List<DocumentKeyValue> keyValues = new ArrayList<>();
		DocumentKeyValue documentKeyValue = new DocumentKeyValue();
		documentKeyValue.setKey("name");
		documentKeyValue.setValue("Santosh Pun");
		keyValues.add(documentKeyValue);

		List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();

		gridKeyValues.add(new DocumentGridKeyValue());

		documentRequest.setSubmittedBy(1);
		documentRequest.setAssignees(assignees);
		documentRequest.setKeyValues(keyValues);
		documentRequest.setGridKeyValues(gridKeyValues);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(documentRequest, true));
		// ClientResponse response = sendPutRequest("/documents",
		// documentRequest);
		// if (response.getStatus() != 200) {
		// throw new RuntimeException("Failed : HTTP error code : "
		// + response.getStatus());
		// }
		// String output = response.getEntity(String.class);
		// System.out.println("Server response .... \n");
		// System.out.println(output);
	}

	@Test
	public void testAddDocument() {

		AddDocumentRequestDTO request = new AddDocumentRequestDTO();
		request.setDocumentTemplateId(20);
		request.setDocumentName("RFI Document");
		request.setDueDate(new Date());

		UserDTO submitter = new UserDTO();

		submitter.setUserId(1);
		submitter.setUsername("DocEPTest");
		request.setSubmitter(submitter);

		List<UserDTO> assignees = new ArrayList<>();

		UserDTO assignee = new UserDTO();
		assignee.setUserId(1);
		assignee.setUsername("Assignee1");
		assignees.add(assignee);

		request.setAssignees(assignees);

		List<DocumentKeyValueDTO> keyValues = new ArrayList<>();
		keyValues.add(new DocumentKeyValueDTO("name", "Sebastian Praysis"));
		keyValues.add(new DocumentKeyValueDTO("company_name", "VOREA MGMT"));
		keyValues
				.add(new DocumentKeyValueDTO("attention", "Sebastian Praysis"));
		keyValues.add(new DocumentKeyValueDTO("RFI#", "RFI001"));
		keyValues.add(new DocumentKeyValueDTO("subject", "Test Subject"));
		keyValues.add(new DocumentKeyValueDTO("priority", "HIGH"));
		keyValues.add(new DocumentKeyValueDTO("question_or_concern",
				"A sample concern."));
		keyValues.add(new DocumentKeyValueDTO("suggestion",
				"Suggestion for sample concern."));
		keyValues.add(new DocumentKeyValueDTO("rfi_is_a_change", "YES"));
		keyValues.add(new DocumentKeyValueDTO("response",
				"Sample response to the RFI."));
		keyValues.add(new DocumentKeyValueDTO("accepted", "YES"));
		keyValues.add(new DocumentKeyValueDTO("rejected", "NO"));

		request.setKeyValues(keyValues);

		System.out.println("Client request.... \n");
		System.out.println(toJsonString(request, true));
		ClientResponse response = sendPutRequest("/documents", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.getEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);

	}

	// @Test
	// public void testUpdateDocument() {
	// UpdateDocumentDataRequest request = new UpdateDocumentDataRequest();
	// request.setDocumentId(31);
	//
	// UserDTO user = new UserDTO();
	// user.setUserId(1);
	// user.setUsername("DocUpdateTest");
	// request.setUser(user);
	//
	// List<DocumentKeyValue> keyValues = new ArrayList<>();
	// keyValues.add(new DocumentKeyValue("name", "** Sebastian Praysis"));
	// keyValues.add(new DocumentKeyValue("company_name", "** VOREA MGMT"));
	// keyValues
	// .add(new DocumentKeyValue("attention", "** Sebastian Praysis"));
	// keyValues.add(new DocumentKeyValue("RFI#", "** RFI001"));
	// keyValues.add(new DocumentKeyValue("subject", "** Test Subject"));
	// keyValues.add(new DocumentKeyValue("priority", "** HIGH"));
	// keyValues.add(new DocumentKeyValue("question_or_concern",
	// "** A sample concern."));
	// keyValues.add(new DocumentKeyValue("suggestion",
	// "** Suggestion for sample concern."));
	// keyValues.add(new DocumentKeyValue("rfi_is_a_change", "** YES"));
	// keyValues.add(new DocumentKeyValue("response",
	// "** Sample response to the RFI."));
	// keyValues.add(new DocumentKeyValue("accepted", "** YES"));
	// keyValues.add(new DocumentKeyValue("rejected", "** NO"));
	//
	// request.setKeyValues(keyValues);
	//
	// sendUpdateRequest(request);
	//
	// System.out
	// .println("***********************************************************************");
	// System.out
	// .println("***********************************************************************");
	//
	// request.setDocumentId(33);
	//
	// keyValues = new ArrayList<>();
	// keyValues.add(new DocumentKeyValue("name", "** Sebastian Praysis"));
	// keyValues.add(new DocumentKeyValue("company_name", "** VOREA MGMT"));
	// keyValues
	// .add(new DocumentKeyValue("attention", "** Sebastian Praysis"));
	// keyValues.add(new DocumentKeyValue("PO#", "** PO001"));
	// keyValues.add(new DocumentKeyValue("address",
	// "** 111 Street City ST 99999"));
	// keyValues.add(new DocumentKeyValue("subject", "** Test Subject"));
	// keyValues.add(new DocumentKeyValue("priority", "** HIGH"));
	// keyValues.add(new DocumentKeyValue("shipping_method", "** WATER"));
	// keyValues
	// .add(new DocumentKeyValue("shipping_terms", "** SHIPPING TERM"));
	// keyValues.add(new DocumentKeyValue("ship_to_name",
	// "** Sebastian Praysis"));
	// keyValues.add(new DocumentKeyValue("ship_to_company", "** VOREA MGMT"));
	// keyValues.add(new DocumentKeyValue("ship_to_address",
	// "** 111 street city st 99999"));
	// keyValues.add(new DocumentKeyValue("total_po_amount", "** 6500.00"));
	// keyValues.add(new DocumentKeyValue("notes", "** Test PO"));
	//
	// request.setKeyValues(keyValues);
	//
	// List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();
	//
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1,
	// "product_code", "** PC1"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1,
	// "product_name", "** PN1"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "quantity",
	// "** 5"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "unit_price",
	// "** 1000.00"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "total",
	// "** 5000.00"));
	//
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2,
	// "product_code", "** PC2"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2,
	// "product_name", "** PN1"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "quantity",
	// "** 3"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "unit_price",
	// "** 500.00"));
	// gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "total",
	// "** 1500.00"));
	//
	// request.setGridKeyValues(gridKeyValues);
	//
	// sendUpdateRequest(request);
	// }
	//
	//
	//
	// @Test
	// public void testUpdateDocumentStatus() {
	// UpdateDocumentStatusRequest request = new UpdateDocumentStatusRequest();
	// request.setDocumentId(31);
	// request.setNewStatus(OnTargetConstant.DocumentStatus.APPROVED);
	// UserDTO user = new UserDTO();
	// user.setUserId(6);
	// user.setUsername("Assignee3");
	// request.setUpdater(user);
	// sendUpdateStatusRequest(request);
	//
	// }
	//
	//
	// @Test
	// public void testAddDocumentAttachment() {
	// AddDocumentAttachmentRequest request = new
	// AddDocumentAttachmentRequest();
	// request.setDocumentId(31L);
	// request.setFilePath("/path/to/file/file.txt");
	// UserDTO user = new UserDTO();
	// user.setUserId(6);
	// user.setUsername("Assignee3");
	// request.setUser(user);
	// try {
	// ObjectMapper mapper = new ObjectMapper();
	// mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
	// String payLoad = mapper.writeValueAsString(request);
	// System.out.println(payLoad);
	// } catch (Exception ex) {
	// System.out.println(ex);
	// }
	// }
}
