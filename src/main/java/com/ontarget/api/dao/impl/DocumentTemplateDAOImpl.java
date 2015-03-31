package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentTemplateDAO;
import com.ontarget.bean.DocumentTemplateDTO;
import com.ontarget.constant.OnTargetQuery;

@Repository("documentTemplateDAOImpl")
public class DocumentTemplateDAOImpl extends BaseGenericDAOImpl<DocumentTemplateDTO> implements DocumentTemplateDAO {

	@Override
	public DocumentTemplateDTO insert(final DocumentTemplateDTO documentTemplate) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(OnTargetQuery.documentTemplate.ADD,
						new String[] { "document_template_id" });
				ps.setString(1, documentTemplate.getName());
				ps.setInt(2, documentTemplate.getCreatedBy().getUserId());
				ps.setInt(3, documentTemplate.getModifiedBy().getUserId());
				return ps;
			}

		}, kh);
		documentTemplate.setDocumentTemplateId(kh.getKey().longValue());
		return documentTemplate;
	}

	@Override
	public DocumentTemplateDTO read(long id) {
		DocumentTemplateDTO documentTemplate = jdbcTemplate.queryForObject(OnTargetQuery.documentTemplate.GET_BY_ID,
				new Object[] { id }, new RowMapper<DocumentTemplateDTO>() {
					@Override
					public DocumentTemplateDTO mapRow(ResultSet rs, int arg1) throws SQLException {
						DocumentTemplateDTO dt = new DocumentTemplateDTO();
						dt.setDocumentTemplateId(rs.getLong("document_template_id"));
						dt.setName(rs.getString("name"));
						return dt;
					}

				});

		return documentTemplate;
	}

	@Override
	public DocumentTemplateDTO getByDocumentId(long documentId) {
		DocumentTemplateDTO documentTemplate = jdbcTemplate.queryForObject(OnTargetQuery.documentTemplate.GET_BY_DOCUMENT_ID,
				new Object[] { documentId }, new RowMapper<DocumentTemplateDTO>() {
					@Override
					public DocumentTemplateDTO mapRow(ResultSet rs, int arg1) throws SQLException {
						DocumentTemplateDTO dt = new DocumentTemplateDTO();
						dt.setDocumentTemplateId(rs.getLong("document_template_id"));
						dt.setName(rs.getString("name"));
						return dt;
					}

				});

		return documentTemplate;
	}

	@Override
	public boolean update(DocumentTemplateDTO bean) {
		throw new UnsupportedOperationException();
	}

}
