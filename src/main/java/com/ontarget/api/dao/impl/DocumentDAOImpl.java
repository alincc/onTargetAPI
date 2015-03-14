package com.ontarget.api.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.DocumentDAO;
import com.ontarget.bean.Contact;
import com.ontarget.bean.DocumentDTO;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentDAOImpl extends BaseGenericDAOImpl<DocumentDTO> implements
		DocumentDAO {
	private static final Logger logger = Logger
			.getLogger(BaseGenericDAOImpl.class);

	@Autowired
	private ContactDAO contactDAO;

	@Override
	public DocumentDTO insert(final DocumentDTO document) {
		KeyHolder kh = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement ps = conn.prepareStatement(
						OnTargetQuery.document.ADD,
						new String[] { "document_id" });
				ps.setLong(1, document.getDocumentTemplate()
						.getDocumentTemplateId());
				ps.setString(2, document.getName());
				ps.setString(3, document.getStatus());
				ps.setInt(4, document.getCreatedBy());
				ps.setInt(5, document.getModifiedBy());
				ps.setLong(6, document.getProjectId());
				ps.setDate(7,
						new java.sql.Date(document.getDueDate().getTime()));
				return ps;
			}

		}, kh);
		document.setDocumentId(kh.getKey().intValue());
		return document;
	}

	@Override
	public DocumentDTO read(long id) {
		DocumentDTO document = jdbcTemplate.queryForObject(
				OnTargetQuery.document.GET_BY_ID, new Object[] { id },
				new DocumentRowMapper());
		return document;
	}

	@Override
	public boolean update(DocumentDTO document) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean updateStatus(int documentId, String newStatus, int modifiedBy) {
		int count = jdbcTemplate.update(OnTargetQuery.document.UPDATE_STATUS,
				new Object[] { newStatus, modifiedBy, documentId });
		return (count > 0);
	}

	@Override
	public List<DocumentDTO> getByCreatedBy(Integer createdBy, int projectId) {
		List<DocumentDTO> documents = jdbcTemplate.query(
				OnTargetQuery.document.GET_BY_CREATED_BY, new Object[] {
						createdBy, projectId }, new DocumentRowMapper());
		return documents;
	}

	@Override
	public List<DocumentDTO> getByAssigneeUsername(Integer userId, int projectId) {
		List<DocumentDTO> documents = jdbcTemplate.query(
				OnTargetQuery.document.GET_BY_ASSIGNEE_USERNAME, new Object[] {
						userId, projectId }, new DocumentRowMapper());
		return documents;
	}

	@Override
	public List<DocumentDTO> getDocumentsByProject(int projectId,
			String approved) throws Exception {
		List<DocumentDTO> documents = jdbcTemplate.query(
				OnTargetQuery.document.GET_DOCUMENTS_BY_PROJECT, new Object[] {
						projectId, approved }, new DocumentRowMapper());
		return documents;
	}

	@Override
	public boolean updateDueDate(int documentId, Date dueDate, String modifiedBy)
			throws Exception {
		int count = jdbcTemplate.update(OnTargetQuery.document.UPDATE_DUE_DATE,
				new Object[] { dueDate, modifiedBy, documentId });
		return (count > 0);
	}

	class DocumentRowMapper implements RowMapper<DocumentDTO> {

		@Override
		public DocumentDTO mapRow(ResultSet rs, int index) throws SQLException {
			DocumentDTO doc = new DocumentDTO();
			doc.setDocumentId(rs.getInt("document_id"));
			// doc.setDocumentTemplate(rs.getLong("document_template_id"));
			doc.setName(rs.getString("name"));
			doc.setStatus(rs.getString("status"));

			Contact contact = null;
			try {
				contact = contactDAO.getContact(rs.getInt("created_by"));
			} catch (Exception e) {
				logger.error("Error while getting contact info", e);
				throw new SQLException();
			}
			// UserDTO createdBy = new UserDTO();
			// createdBy.setContact(contact);
			// doc.setCreatedBy(createdBy);
			doc.setCreatedBy(rs.getInt("created_by"));
			doc.setDueDate(rs.getDate("due_date"));
			return doc;
		}

	}
}
