package com.ontarget.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.api.dao.UploadDocumentDAO;
import com.ontarget.api.service.UploadDocumentService;
import com.ontarget.bean.UploadDocument;
import com.ontarget.dto.UploadDocumentRequest;
import com.ontarget.dto.UploadedDocumentDetail;
@Service
public class UploadDocumentServiceImpl implements UploadDocumentService {

	private Logger logger = Logger.getLogger(UploadDocumentServiceImpl.class);
	
	@Autowired
	private UploadDocumentDAO uploadDocumentDAO;

	@Override
    @Transactional(rollbackFor = {Exception.class})
	public boolean saveUploadedDocsInfo(UploadDocumentRequest documentInfo) throws Exception {
		logger.info("service call initiated for document upload");
		UploadDocument documentBean=new UploadDocument(documentInfo);
		documentBean=uploadDocumentDAO.saveUploadedDocsInfo(documentBean);

		if(documentBean.getProjectFileId()>=1){
			logger.info("Information saved successfully");
			return Boolean.TRUE;
		}
		logger.info("failed to save information");
		return Boolean.FALSE;
		
		//return ((documentBean.getFileAttachmentId()>=1)?(Boolean.TRUE):(Boolean.FALSE));
	}
	 
	@Override
    @Transactional(rollbackFor = {Exception.class})
	public List<UploadedDocumentDetail> getUploadedFile(int projectId) throws Exception{
		logger.info("service call initiated to fetch uploaded file for project id"+ projectId);
		List<UploadedDocumentDetail> resultList=uploadDocumentDAO.getFilesByProjectId(projectId);
		return resultList;
	}
	 
}
