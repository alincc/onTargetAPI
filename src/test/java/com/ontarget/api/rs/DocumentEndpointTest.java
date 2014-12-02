package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.bean.DocumentGridKeyValue;
import com.ontarget.bean.DocumentKeyValue;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.AddDocumentRequest;
import com.ontarget.dto.UpdateDocumentDataRequest;
import com.ontarget.dto.UpdateDocumentStatusRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional
public class DocumentEndpointTest extends JerseyTest {
	
	public DocumentEndpointTest() throws TestContainerException {
		super("com.ontarget.api.rs");
	}
	
	@Test
	public void testAddDocument() {
		AddDocumentRequest request = new AddDocumentRequest();
		request.setDocumentTemplateId(16);
    	request.setDocumentName("RFI Document");
    	
    	User submitter = new User();
    	submitter.setUserId(1);
    	submitter.setUsername("DocEPTest");
    	request.setSubmitter(submitter);
    	
    	List<User> assignees = new ArrayList<>();
    	
    	User assignee = new User();
    	assignee.setUserId(3);
    	assignee.setUsername("Assignee1");
    	assignees.add(assignee);
    	
    	assignee = new User();
    	assignee.setUserId(5);
    	assignee.setUsername("Assignee2");
    	assignees.add(assignee);
    	
    	assignee = new User();
    	assignee.setUserId(6);
    	assignee.setUsername("Assignee3");
    	assignees.add(assignee);
    	
    	request.setAssignees(assignees);
    	
    	List<DocumentKeyValue> keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValue("name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("company_name", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue("attention", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("RFI#", "RFI001"));
    	keyValues.add(new DocumentKeyValue("subject", "Test Subject"));
    	keyValues.add(new DocumentKeyValue("priority", "HIGH"));
    	keyValues.add(new DocumentKeyValue("question_or_concern", "A sample concern."));
    	keyValues.add(new DocumentKeyValue("suggestion", "Suggestion for sample concern."));
    	keyValues.add(new DocumentKeyValue("rfi_is_a_change", "YES"));
    	keyValues.add(new DocumentKeyValue("response", "Sample response to the RFI."));
    	keyValues.add(new DocumentKeyValue("accepted", "YES"));
    	keyValues.add(new DocumentKeyValue("rejected", "NO"));
    	
    	request.setKeyValues(keyValues);
    	
    	sendRequest(request);
    	
    	request.setDocumentTemplateId(18);
    	request.setDocumentName("PO Document");
    	
    	keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValue("name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("company_name", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue("attention", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("PO#", "PO001"));
    	keyValues.add(new DocumentKeyValue("address", "111 Street City ST 99999"));
    	keyValues.add(new DocumentKeyValue("subject", "Test Subject"));
    	keyValues.add(new DocumentKeyValue("priority", "HIGH"));
    	keyValues.add(new DocumentKeyValue("shipping_method", "WATER"));
    	keyValues.add(new DocumentKeyValue("shipping_terms", "SHIPPING TERM"));
    	keyValues.add(new DocumentKeyValue("ship_to_name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("ship_to_company", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue("ship_to_address", "111 street city st 99999"));
    	keyValues.add(new DocumentKeyValue("total_po_amount", "6500.00"));
    	keyValues.add(new DocumentKeyValue("notes", "Test PO"));
    	
    	request.setKeyValues(keyValues);
    	
    	List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();
    	
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "product_code", "PC1"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "product_name", "PN1"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "quantity", "5"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "unit_price", "1000.00"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "total", "5000.00"));
    	
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "product_code", "PC2"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "product_name", "PN1"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "quantity", "3"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "unit_price", "500.00"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "total", "1500.00"));
    	
    	request.setGridKeyValues(gridKeyValues);
    	
    	sendRequest(request);
	}
	
	private ClientResponse sendRequest(AddDocumentRequest request) {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
    		String payLoad = mapper.writeValueAsString(request);
        	WebResource resource = resource();
        	System.out.println(payLoad);
//        	ClientResponse response = resource.path("/documents")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .type(MediaType.APPLICATION_JSON)
//                    .put(ClientResponse.class, payLoad);
//            String output = response.getEntity(String.class);
//            System.out.println("Server response .... \n");
//            System.out.println(output);
//            if (response.getStatus() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//            }
//            return response;
        	return null;
        } catch(Throwable t) {
        	throw new RuntimeException(t);
        }
	}
	
	@Test
	public void testUpdateDocument() {
		UpdateDocumentDataRequest request = new UpdateDocumentDataRequest();
		request.setDocumentId(31);
		
    	User user = new User();
    	user.setUserId(1);
    	user.setUsername("DocUpdateTest");
    	request.setUser(user);
    	
    	List<DocumentKeyValue> keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValue("name", "** Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("company_name", "** VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue("attention", "** Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("RFI#", "** RFI001"));
    	keyValues.add(new DocumentKeyValue("subject", "** Test Subject"));
    	keyValues.add(new DocumentKeyValue("priority", "** HIGH"));
    	keyValues.add(new DocumentKeyValue("question_or_concern", "** A sample concern."));
    	keyValues.add(new DocumentKeyValue("suggestion", "** Suggestion for sample concern."));
    	keyValues.add(new DocumentKeyValue("rfi_is_a_change", "** YES"));
    	keyValues.add(new DocumentKeyValue("response", "** Sample response to the RFI."));
    	keyValues.add(new DocumentKeyValue("accepted", "** YES"));
    	keyValues.add(new DocumentKeyValue("rejected", "** NO"));
    	
    	request.setKeyValues(keyValues);
    	
    	sendUpdateRequest(request);
    	
    	System.out.println("***********************************************************************");
    	System.out.println("***********************************************************************");
    	
    	request.setDocumentId(33);
    	
    	keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValue("name", "** Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("company_name", "** VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue("attention", "** Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("PO#", "** PO001"));
    	keyValues.add(new DocumentKeyValue("address", "** 111 Street City ST 99999"));
    	keyValues.add(new DocumentKeyValue("subject", "** Test Subject"));
    	keyValues.add(new DocumentKeyValue("priority", "** HIGH"));
    	keyValues.add(new DocumentKeyValue("shipping_method", "** WATER"));
    	keyValues.add(new DocumentKeyValue("shipping_terms", "** SHIPPING TERM"));
    	keyValues.add(new DocumentKeyValue("ship_to_name", "** Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue("ship_to_company", "** VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue("ship_to_address", "** 111 street city st 99999"));
    	keyValues.add(new DocumentKeyValue("total_po_amount", "** 6500.00"));
    	keyValues.add(new DocumentKeyValue("notes", "** Test PO"));
    	
    	request.setKeyValues(keyValues);
    	
    	List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();
    	
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "product_code", "** PC1"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "product_name", "** PN1"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "quantity", "** 5"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "unit_price", "** 1000.00"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 1, "total", "** 5000.00"));
    	
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "product_code", "** PC2"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "product_name", "** PN1"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "quantity", "** 3"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "unit_price", "** 500.00"));
    	gridKeyValues.add(new DocumentGridKeyValue("po_grid", 2, "total", "** 1500.00"));
    	
    	request.setGridKeyValues(gridKeyValues);
    	
    	sendUpdateRequest(request);
	}
	
	private ClientResponse sendUpdateRequest(UpdateDocumentDataRequest request) {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
    		String payLoad = mapper.writeValueAsString(request);
        	WebResource resource = resource();
        	System.out.println(payLoad);
//        	ClientResponse response = resource.path("/documents")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .type(MediaType.APPLICATION_JSON)
//                    .put(ClientResponse.class, payLoad);
//            String output = response.getEntity(String.class);
//            System.out.println("Server response .... \n");
//            System.out.println(output);
//            if (response.getStatus() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//            }
//            return response;
        	return null;
        } catch(Throwable t) {
        	throw new RuntimeException(t);
        }
	}
	
	@Test
	public void testUpdateDocumentStatus() {
		UpdateDocumentStatusRequest request = new UpdateDocumentStatusRequest();
		request.setDocumentId(31);
		request.setNewStatus(OnTargetConstant.DocumentStatus.APPROVED);
		User user = new User();
		user.setUserId(6);
		user.setUsername("Assignee3");
		request.setUpdater(user);
		sendUpdateStatusRequest(request);
		
	}
	
	private ClientResponse sendUpdateStatusRequest(UpdateDocumentStatusRequest request) {
        try {
        	ObjectMapper mapper = new ObjectMapper();
        	mapper.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
    		String payLoad = mapper.writeValueAsString(request);
        	WebResource resource = resource();
        	System.out.println(payLoad);
//        	ClientResponse response = resource.path("/documents")
//                    .accept(MediaType.APPLICATION_JSON)
//                    .type(MediaType.APPLICATION_JSON)
//                    .put(ClientResponse.class, payLoad);
//            String output = response.getEntity(String.class);
//            System.out.println("Server response .... \n");
//            System.out.println(output);
//            if (response.getStatus() != 200) {
//                throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
//            }
//            return response;
        	return null;
        } catch(Throwable t) {
        	throw new RuntimeException(t);
        }
	}
}
