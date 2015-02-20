package com.ontarget.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentKeyValueDAO;
import com.ontarget.bean.DocumentKeyValueDTO;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentKeyValueDAOImpl extends
		BaseGenericDAOImpl<DocumentKeyValueDTO> implements DocumentKeyValueDAO {

	@Override
	public DocumentKeyValueDTO insert(DocumentKeyValueDTO docKeyVal) {
		jdbcTemplate.update(OnTargetQuery.documentKeyValue.ADD, docKeyVal
				.getDocument().getDocumentId(), docKeyVal.getKey(), docKeyVal
				.getValue(), docKeyVal.getCreatedBy(), docKeyVal
				.getModifiedBy());
		return docKeyVal;
	}

	@Override
	public DocumentKeyValueDTO read(long id) {

		return null;
	}

	@Override
	public boolean update(DocumentKeyValueDTO docKeyVal) {

		return false;
	}

	@Override
	public List<DocumentKeyValueDTO> getByDocumentId(long documentId) {
		List<DocumentKeyValueDTO> keyValues = jdbcTemplate.query(
				OnTargetQuery.documentKeyValue.GET_BY_DOCUMENT,
				new Object[] { documentId },
				new RowMapper<DocumentKeyValueDTO>() {

					@Override
					public DocumentKeyValueDTO mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						DocumentKeyValueDTO keyValue = new DocumentKeyValueDTO();
						keyValue.setKey(rs.getString("key"));
						keyValue.setValue(rs.getString("value"));
						return keyValue;
					}

				});
		return keyValues;
	}

	@Override
	public boolean updateValue(long documentId, String key, String newValue,
			int modifiedBy) {
		int count = jdbcTemplate.update(
				OnTargetQuery.documentKeyValue.UPDATE_VALUE, newValue,
				modifiedBy, documentId, key);
		return (count > 0);
	}

}
