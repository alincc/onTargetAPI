package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.UploadDocumentDAO;
import com.ontarget.bean.UploadDocument;
import com.ontarget.constant.OnTargetQuery;
import com.ontarget.dto.UploadedDocumentDetail;
import com.ontarget.entities.ProjectFileComment;
import com.ontarget.request.bean.ProjectFileCommentRequest;

@Repository("uploadDocumentDAOImpl")
public class UploadDocumentDAOImpl implements UploadDocumentDAO {
	private Logger logger = Logger.getLogger(UploadDocumentDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UploadedDocumentDetail saveUploadedDocsInfo(UploadDocument documentBean) throws Exception {
		logger.info("Saving uploaded document information" + documentBean);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(OnTargetQuery.SAVE_UPLOADED_DOCUMENT, new String[] { "id" });
				ps.setString(1, documentBean.getName());
				ps.setString(2, documentBean.getFileType());
				ps.setInt(3, documentBean.getProjectId());
				ps.setInt(4, documentBean.getCreatedBy());
				return ps;
			}
		}, keyHolder);
		logger.debug("Added document path  with id: " + keyHolder.getKey().intValue());
		documentBean.setProjectFileId(keyHolder.getKey().intValue());

		return null;

	}

	@Override
	public List<UploadedDocumentDetail> getFilesByProjectId(int projectId) {

		List<UploadedDocumentDetail> resultList = new ArrayList<UploadedDocumentDetail>();

		List<Map<String, Object>> documentList = jdbcTemplate.queryForList(OnTargetQuery.GET_PROJECT_FILE, new Object[] { projectId });
		if (documentList != null && documentList.size() > 0) {
			for (Map<String, Object> taskMap : documentList) {
				UploadedDocumentDetail documentDetail = new UploadedDocumentDetail();
				documentDetail.setFileId((Integer) taskMap.get("project_file_id"));
				documentDetail.setName((String) taskMap.get("file_name"));
				documentDetail.setFileType((String) taskMap.get("file_type"));
				documentDetail.setCreatedBy((Integer) taskMap.get("created_by"));
				documentDetail.setCreatedDate((Date) taskMap.get("created_date"));

				resultList.add(documentDetail);
			}
		}

		return resultList;

	}

    @Override
    public UploadedDocumentDetail updateProjectFile(UploadDocument documentBean) throws Exception {
        return null;
    }

    @Override
	public boolean addComment(ProjectFileCommentRequest request) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteComment(Integer commentId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ProjectFileComment> getCommentsByFileId(int projectFileId) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public UploadedDocumentDetail getFilesByProjectAndFileId(Integer projectId, Integer projectFileId) throws Exception {
        return null;
    }

    @Override
	public boolean deleteProjectFile(Integer projectFileId,int userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
