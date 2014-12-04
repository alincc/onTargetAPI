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
import com.ontarget.bean.DocumentTemplate;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentTemplateDAOImpl 
		extends BaseGenericDAOImpl<DocumentTemplate> 
		implements DocumentTemplateDAO {

	@Override
	public DocumentTemplate insert(final DocumentTemplate documentTemplate) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(OnTargetQuery.documentTemplate.ADD, 
						new String[] { "document_template_id" });
		            ps.setString(1, documentTemplate.getName());
		            ps.setString(2, documentTemplate.getCreatedBy());
		            ps.setString(3, documentTemplate.getModifiedBy());
		            return ps;
			}
			
		}, kh);
		documentTemplate.setDocumentTemplateId(kh.getKey().longValue());
		return documentTemplate;
	}

	@Override
	public DocumentTemplate read(long id) {
		DocumentTemplate documentTemplate = jdbcTemplate.queryForObject(OnTargetQuery.documentTemplate.GET_BY_ID, 
				new Object[] { id }, 
				new RowMapper<DocumentTemplate>() {
					@Override
					public DocumentTemplate mapRow(ResultSet rs, int arg1)
							throws SQLException {
						DocumentTemplate dt = new DocumentTemplate();
						dt.setDocumentTemplateId(rs.getLong("document_template_id"));
						dt.setName(rs.getString("name"));
						return dt;
					}
			
		});
		return documentTemplate;
	}

	@Override
	public boolean update(DocumentTemplate bean) {
		throw new UnsupportedOperationException();
	}

}
