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
import com.ontarget.bean.DocumentAttachmentDTO;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentAttachmentDAOImpl extends
		BaseGenericDAOImpl<DocumentAttachmentDTO> implements
		DocumentAttachmentDAO {

	@Override
	public DocumentAttachmentDTO insert(DocumentAttachmentDTO documentAttachment) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(
						OnTargetQuery.documentAttachment.ADD,
						new String[] { "document_attachment_id" });
				ps.setLong(1, documentAttachment.getDocument().getDocumentId());
				ps.setString(2, documentAttachment.getFilePath());
				ps.setInt(3, documentAttachment.getAddedBy());
				ps.setInt(4, documentAttachment.getAddedBy());
				return ps;
			}

		}, kh);
		documentAttachment.setDocumentAttachmentId(kh.getKey().intValue());
		return documentAttachment;
	}

	@Override
	public DocumentAttachmentDTO read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(DocumentAttachmentDTO bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<DocumentAttachmentDTO> getByDocumentId(long documentId) {
		List<DocumentAttachmentDTO> documentAttachments = jdbcTemplate.query(
				OnTargetQuery.documentAttachment.GET_BY_DOCUMENT_ID,
				new Object[] { documentId },
				new RowMapper<DocumentAttachmentDTO>() {
					@Override
					public DocumentAttachmentDTO mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						DocumentAttachmentDTO documentAttachment = new DocumentAttachmentDTO();
						documentAttachment.setDocumentAttachmentId(rs
								.getInt("document_attachment_id"));
						documentAttachment.setFilePath(rs
								.getString("file_path"));
						return documentAttachment;
					}

				});
		return documentAttachments;
	}

}
