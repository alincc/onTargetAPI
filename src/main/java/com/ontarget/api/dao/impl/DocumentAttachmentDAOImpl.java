package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentAttachmentDAO;
import com.ontarget.bean.DocumentAttachment;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentAttachmentDAOImpl 
		extends BaseGenericDAOImpl<DocumentAttachment> 
		implements DocumentAttachmentDAO {

	@Override
	public DocumentAttachment insert(DocumentAttachment documentAttachment) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(OnTargetQuery.documentAttachment.ADD, 
						new String[] { "document_attachment_id" });
		            ps.setLong(1, documentAttachment.getDocument().getDocumentId());
		            ps.setString(2, documentAttachment.getFilePath());
		            ps.setString(3, documentAttachment.getCreatedBy());
		            ps.setString(4, documentAttachment.getModifiedBy());
		            return ps;
			}
			
		}, kh);
		documentAttachment.setDocumentAttachmentId(kh.getKey().longValue());
		return documentAttachment;
	}

	@Override
	public DocumentAttachment read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(DocumentAttachment bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<DocumentAttachment> getByDocumentId(long documentId) {
		List<DocumentAttachment> documentAttachments = jdbcTemplate.query(OnTargetQuery.documentAttachment.GET_BY_DOCUMENT_ID, 
				new Object[] { documentId }, 
				new RowMapper<DocumentAttachment>() {
					@Override
					public DocumentAttachment mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						DocumentAttachment documentAttachment = new DocumentAttachment();
						documentAttachment.setDocumentAttachmentId(rs.getLong("document_attachment_id"));
						documentAttachment.setFilePath(rs.getString("file_path"));
						return documentAttachment;
					}
			
		});
		return documentAttachments;
	}

}
