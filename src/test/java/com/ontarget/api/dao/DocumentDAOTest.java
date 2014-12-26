package com.ontarget.api.dao;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.Document;
import com.ontarget.bean.DocumentGridKeyValue;
import com.ontarget.bean.DocumentKeyValue;
import com.ontarget.bean.DocumentTemplate;
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
    	DocumentTemplate documentTemplate = new DocumentTemplate();
    	documentTemplate.setName("RFI Template");
    	documentTemplate.setCreatedBy(0);
    	documentTemplate.setModifiedBy(0);
    	documentTemplateDAO.insert(documentTemplate);
    	
    	Document document = new Document();
    	document.setDocumentTemplate(documentTemplate);
    	document.setName("RFI Document");
    	document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
    	document.setCreatedBy(0);
    	document.setModifiedBy(0);
    	
    	List<DocumentKeyValue> keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValue(document, "name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue(document, "company_name", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue(document, "attention", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue(document, "RFI#", "RFI001"));
    	keyValues.add(new DocumentKeyValue(document, "subject", "Test Subject"));
    	keyValues.add(new DocumentKeyValue(document, "priority", "HIGH"));
    	keyValues.add(new DocumentKeyValue(document, "question_or_concern", "A sample concern."));
    	keyValues.add(new DocumentKeyValue(document, "suggestion", "Suggestion for sample concern."));
    	keyValues.add(new DocumentKeyValue(document, "rfi_is_a_change", "YES"));
    	keyValues.add(new DocumentKeyValue(document, "response", "Sample response to the RFI."));
    	keyValues.add(new DocumentKeyValue(document, "accepted", "YES"));
    	keyValues.add(new DocumentKeyValue(document, "rejected", "NO"));
    	
    	document.setKeyValues(keyValues);
    	documentDAO.insert(document);
    	
    	logger.info("Document ID: " + document.getDocumentId());
    	Assert.assertTrue(document.getDocumentId() > 0);
    	
    	documentTemplate = new DocumentTemplate();
    	documentTemplate.setName("PO Template");
    	documentTemplate.setCreatedBy(0);
    	documentTemplate.setModifiedBy(0);
    	documentTemplateDAO.insert(documentTemplate);
    	
    	document = new Document();
    	document.setDocumentTemplate(documentTemplate);
    	document.setName("PO Document");
    	document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
    	document.setCreatedBy(0);
    	document.setModifiedBy(0);
    	
    	keyValues = new ArrayList<>();
    	keyValues.add(new DocumentKeyValue(document, "name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue(document, "company_name", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue(document, "attention", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue(document, "PO#", "PO001"));
    	keyValues.add(new DocumentKeyValue(document, "address", "111 Street City ST 99999"));
    	keyValues.add(new DocumentKeyValue(document, "subject", "Test Subject"));
    	keyValues.add(new DocumentKeyValue(document, "priority", "HIGH"));
    	keyValues.add(new DocumentKeyValue(document, "shipping_method", "WATER"));
    	keyValues.add(new DocumentKeyValue(document, "shipping_terms", "SHIPPING TERM"));
    	keyValues.add(new DocumentKeyValue(document, "ship_to_name", "Sebastian Praysis"));
    	keyValues.add(new DocumentKeyValue(document, "ship_to_company", "VOREA MGMT"));
    	keyValues.add(new DocumentKeyValue(document, "ship_to_address", "111 street city st 99999"));
    	keyValues.add(new DocumentKeyValue(document, "total_po_amount", "6500.00"));
    	keyValues.add(new DocumentKeyValue(document, "notes", "Test PO"));
    	
    	document.setKeyValues(keyValues);
    	
    	List<DocumentGridKeyValue> gridKeyValues = new ArrayList<>();
    	
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 1, "product_code", "PC1"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 1, "product_name", "PN1"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 1, "quantity", "5"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 1, "unit_price", "1000.00"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 1, "total", "5000.00"));
    	
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 2, "product_code", "PC2"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 2, "product_name", "PN1"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 2, "quantity", "3"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 2, "unit_price", "500.00"));
    	gridKeyValues.add(new DocumentGridKeyValue(document, "po_grid", 2, "total", "1500.00"));
    	
    	document.setGridKeyValues(gridKeyValues);
    	
    	documentDAO.insert(document);
    	
    	logger.info("Document ID: " + document.getDocumentId());
    	Assert.assertTrue(document.getDocumentId() > 0);
    }

    @Test
    public void testUpdateStatus() {
    	DocumentTemplate documentTemplate = new DocumentTemplate();
    	documentTemplate.setName("RFI Template");
    	documentTemplate.setCreatedBy(0);
    	documentTemplate.setModifiedBy(0);
    	documentTemplateDAO.insert(documentTemplate);
    	
    	Document document = new Document();
    	document.setDocumentTemplate(documentTemplate);
    	document.setName("RFI Document");
    	document.setStatus(OnTargetConstant.DocumentStatus.SUBMITTED);
    	document.setCreatedBy(0);
    	document.setModifiedBy(0);
    	documentDAO.insert(document);
    	document = documentDAO.read(document.getDocumentId());
    	
    	Assert.assertTrue(document.getDocumentId() > 0);
    	Assert.assertEquals(OnTargetConstant.DocumentStatus.SUBMITTED, document.getStatus());
    	
    	documentDAO.updateStatus(document.getDocumentId(), OnTargetConstant.DocumentStatus.APPROVED, 0);
    	document = documentDAO.read(document.getDocumentId());
    	Assert.assertEquals(OnTargetConstant.DocumentStatus.APPROVED, document.getStatus());
    	
    	documentDAO.updateStatus(document.getDocumentId(), OnTargetConstant.DocumentStatus.REJECTED, 0);
    	document = documentDAO.read(document.getDocumentId());
    	Assert.assertEquals(OnTargetConstant.DocumentStatus.REJECTED, document.getStatus());
    	
    	documentDAO.updateStatus(document.getDocumentId(), OnTargetConstant.DocumentStatus.SUBMITTED, 0);
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
