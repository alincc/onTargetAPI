package com.ontarget.api.dao;

import java.util.List;

import com.ontarget.bean.UploadDocument;
import com.ontarget.dto.UploadedDocumentDetail;

public interface UploadDocumentDAO {
	public UploadDocument saveUploadedDocsInfo(UploadDocument documentBean)  throws Exception;
	public List<UploadedDocumentDetail> getFilesByProjectId(int projectId); 
}
