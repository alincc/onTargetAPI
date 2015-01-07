package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentDAO;
import com.ontarget.bean.Document;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentDAOImpl extends BaseGenericDAOImpl<Document> implements DocumentDAO {
	private static final Logger logger = Logger.getLogger(BaseGenericDAOImpl.class);

	@Override
	public Document insert(final Document document) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator(){
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(OnTargetQuery.document.ADD, 
						new String[] { "document_id" });
		            ps.setLong(1, document.getDocumentTemplate().getDocumentTemplateId());
		            ps.setString(2, document.getName());
		            ps.setString(3, document.getStatus());
		            ps.setInt(4, document.getCreatedBy());
		            ps.setInt(5, document.getModifiedBy());
		            return ps;
			}
			
		}, kh);
		document.setDocumentId(kh.getKey().longValue());
		return document;
	}

	@Override
	public Document read(long id) {
		Document document = jdbcTemplate.queryForObject(OnTargetQuery.document.GET_BY_ID, 
				new Object[] { id }, 
				new DocumentRowMapper());
		return document;
	}

	@Override
	public boolean update(Document document) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean updateStatus(long documentId, String newStatus, String modifiedBy) {
		int count = jdbcTemplate.update(OnTargetQuery.document.UPDATE_STATUS,
				new Object[] {newStatus, modifiedBy, documentId});
		return (count > 0);
	}

	@Override
	public List<Document> getByCreatedBy(String createdBy) {
		List<Document> documents = jdbcTemplate.query(OnTargetQuery.document.GET_BY_CREATED_BY, 
				new Object[] { createdBy }, 
				new DocumentRowMapper());
		return documents;
	}

	@Override
	public List<Document> getByAssigneeUsername(String username) {
		List<Document> documents = jdbcTemplate.query(OnTargetQuery.document.GET_BY_ASSIGNEE_USERNAME, 
				new Object[] { username }, 
				new DocumentRowMapper());
		return documents;
	}

	static class DocumentRowMapper implements RowMapper<Document> {

		@Override
		public Document mapRow(ResultSet rs, int index) throws SQLException {
			Document doc = new Document();
			doc.setDocumentId(rs.getLong("document_id"));
			//doc.setDocumentTemplate(rs.getLong("document_template_id"));
			doc.setName(rs.getString("name"));
			doc.setStatus(rs.getString("status"));
			return doc;
		}
		
	}
}
