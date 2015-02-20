package com.ontarget.api.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.bean.DocumentGridKeyValueDTO;
import com.ontarget.bean.DocumentKeyValueDTO;
import com.ontarget.bean.DocumentTemplateDTO;
import com.ontarget.constant.OnTargetConstant;

/**
 * Created by Owner on 11/5/14.
 */

public class DocumentDAOTest extends BaseTest {

    private Logger logger = Logger.getLogger(DocumentDAOTest.class);

    @Autowired
    private DocumentDAO documentDAO;
    
    @Autowired
    private DocumentTemplateDAO documentTemplateDAO;
    
    @Test
    public void testInsert() {
    	DocumentTemplateDTO documentTemplate = new DocumentTemplateDTO();
    	documentTemplate.setName("RFI Template");
    	documentTemplate.setCreatedBy(null);
    	documentTemplate.setModifiedBy(null);
    	documentTemplateDAO.insert(documentTemplate);
    	
    	DocumentDTO document = new DocumentDTO();
    	document.setDocumentTemplate(documentTemplate);
    	document.setName("RFI Document");
    	document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
    	document.setCreatedBy(1);
    	document.setModifiedBy(1);
    	
    	List<DocumentKeyValueDTO> keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValueDTO(document, "name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValueDTO(document, "company_name", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValueDTO(document, "attention", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValueDTO(document, "RFI#", "RFI001"));
    	keyValues.add(new DocumentKeyValueDTO(document, "subject", "Test Subject"));
    	keyValues.add(new DocumentKeyValueDTO(document, "priority", "HIGH"));
    	keyValues.add(new DocumentKeyValueDTO(document, "question_or_concern", "A sample concern."));
    	keyValues.add(new DocumentKeyValueDTO(document, "suggestion", "Suggestion for sample concern."));
    	keyValues.add(new DocumentKeyValueDTO(document, "rfi_is_a_change", "YES"));
    	keyValues.add(new DocumentKeyValueDTO(document, "response", "Sample response to the RFI."));
    	keyValues.add(new DocumentKeyValueDTO(document, "accepted", "YES"));
    	keyValues.add(new DocumentKeyValueDTO(document, "rejected", "NO"));
    	
    	document.setKeyValues(keyValues);
    	documentDAO.insert(document);
    	
    	logger.info("Document ID: " + document.getDocumentId());
    	Assert.assertTrue(document.getDocumentId() > 0);
    	
    	documentTemplate = new DocumentTemplateDTO();
    	documentTemplate.setName("PO Template");
    	documentTemplate.setCreatedBy(null);
    	documentTemplate.setModifiedBy(null);
    	documentTemplateDAO.insert(documentTemplate);
    	
    	document = new DocumentDTO();
    	document.setDocumentTemplate(documentTemplate);
    	document.setName("PO Document");
    	document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
    	document.setCreatedBy(1);
    	document.setModifiedBy(1);
    	
    	keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValueDTO(document, "name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValueDTO(document, "company_name", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValueDTO(document, "attention", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValueDTO(document, "PO#", "PO001"));
    	keyValues.add(new DocumentKeyValueDTO(document, "address", "111 Street City ST 99999"));
    	keyValues.add(new DocumentKeyValueDTO(document, "subject", "Test Subject"));
    	keyValues.add(new DocumentKeyValueDTO(document, "priority", "HIGH"));
    	keyValues.add(new DocumentKeyValueDTO(document, "shipping_method", "WATER"));
    	keyValues.add(new DocumentKeyValueDTO(document, "shipping_terms", "SHIPPING TERM"));
    	keyValues.add(new DocumentKeyValueDTO(document, "ship_to_name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValueDTO(document, "ship_to_company", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValueDTO(document, "ship_to_address", "111 street city st 99999"));
    	keyValues.add(new DocumentKeyValueDTO(document, "total_po_amount", "6500.00"));
    	keyValues.add(new DocumentKeyValueDTO(document, "notes", "Test PO"));
    	
    	document.setKeyValues(keyValues);
    	
    	List<DocumentGridKeyValueDTO> gridKeyValues = new ArrayList<>();
    	
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 1, "product_code", "PC1"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 1, "product_name", "PN1"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 1, "quantity", "5"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 1, "unit_price", "1000.00"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 1, "total", "5000.00"));
    	
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 2, "product_code", "PC2"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 2, "product_name", "PN1"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 2, "quantity", "3"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 2, "unit_price", "500.00"));
    	gridKeyValues.add(new DocumentGridKeyValueDTO(document, "po_grid", 2, "total", "1500.00"));
    	
    	document.setGridKeyValues(gridKeyValues);
    	
    	documentDAO.insert(document);
    	
    	logger.info("Document ID: " + document.getDocumentId());
    	Assert.assertTrue(document.getDocumentId() > 0);
    }

    @Test
    public void testUpdateStatus() {
    	DocumentTemplateDTO documentTemplate = new DocumentTemplateDTO();
    	documentTemplate.setName("RFI Template");
    	documentTemplate.setCreatedBy(null);
    	documentTemplate.setModifiedBy(null);
    	documentTemplateDAO.insert(documentTemplate);
    	
    	DocumentDTO document = new DocumentDTO();
    	document.setDocumentTemplate(documentTemplate);
    	document.setName("RFI Document");
    	document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
    	document.setCreatedBy(1);
    	document.setModifiedBy(1);
    	documentDAO.insert(document);
    	document = documentDAO.read(document.getDocumentId());
    	
    	Assert.assertTrue(document.getDocumentId() > 0);
    	Assert.assertEquals(OnTargetConstant.DocumentStatus.SUBMITTED, document.getStatus());
    	
    	documentDAO.updateStatus(document.getDocumentId(), OnTargetConstant.DocumentStatus.APPROVED, 1);
    	document = documentDAO.read(document.getDocumentId());
    	Assert.assertEquals(OnTargetConstant.DocumentStatus.APPROVED, document.getStatus());
    	
    	documentDAO.updateStatus(document.getDocumentId(), OnTargetConstant.DocumentStatus.REJECTED, 1);
    	document = documentDAO.read(document.getDocumentId());
    	Assert.assertEquals(OnTargetConstant.DocumentStatus.REJECTED, document.getStatus());
    	
    	documentDAO.updateStatus(document.getDocumentId(), OnTargetConstant.DocumentStatus.SUBMITTED, 1);
    	document = documentDAO.read(document.getDocumentId());
    	Assert.assertEquals(OnTargetConstant.DocumentStatus.SUBMITTED, document.getStatus());
    }
    
    @Test
    public void testGetByCreatedBy() {
    	
    }
    
    @Test
    public void testGetByAssigneeUserId() {
    	
    }
}
