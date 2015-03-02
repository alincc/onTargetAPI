package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.DocumentGridKeyValueDAO;
import com.ontarget.bean.DocumentGridKeyValueDTO;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DocumentGridKeyValueDAOImpl extends
		BaseGenericDAOImpl<DocumentGridKeyValueDTO> implements
		DocumentGridKeyValueDAO {

	@Override
	public DocumentGridKeyValueDTO insert(DocumentGridKeyValueDTO gridKeyVal) {
		jdbcTemplate.update(OnTargetQuery.documentGridKeyValue.ADD, gridKeyVal
				.getDocument().getDocumentId(), gridKeyVal.getGridId(),
				gridKeyVal.getGridRowIndex(), gridKeyVal.getKey(), gridKeyVal
						.getValue(), gridKeyVal.getCreatedBy(), gridKeyVal
						.getModifiedBy());
		return gridKeyVal;
	}

	@Override
	public DocumentGridKeyValueDTO read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(DocumentGridKeyValueDTO bean) {
		return false;
	}

	@Override
	public List<DocumentGridKeyValueDTO> getByDocumentIdAndGridId(
			int documentId, String gridId) {
		List<DocumentGridKeyValueDTO> gridKeyValues = jdbcTemplate.query(
				OnTargetQuery.documentGridKeyValue.GET_BY_DOCUMENT_GRID,
				new Object[] { documentId },
				new RowMapper<DocumentGridKeyValueDTO>() {
					@Override
					public DocumentGridKeyValueDTO mapRow(ResultSet rs,
							int rowNum) throws SQLException {
						DocumentGridKeyValueDTO keyValue = new DocumentGridKeyValueDTO();
						keyValue.setGridRowIndex(rs.getInt("grid_row_index"));
						keyValue.setKey(rs.getString("key"));
						keyValue.setValue(rs.getString("value"));
						return keyValue;
					}
				});
		return gridKeyValues;
	}

	@Override
	public boolean updateValue(int documentId, String gridId, int gridRowIndex,
			String key, String newValue, int modifiedBy) {
		int count = jdbcTemplate.update(
				OnTargetQuery.documentGridKeyValue.UPDATE_VALUE, newValue,
				modifiedBy, documentId, gridId, gridRowIndex, key);
		return (count > 0);
	}

	@Override
	public List<DocumentGridKeyValueDTO> getByDocumentId(int documentId) {
		List<DocumentGridKeyValueDTO> gridKeyValues = jdbcTemplate.query(
				OnTargetQuery.documentGridKeyValue.GET_BY_DOCUMENT,
				new Object[] { documentId },
				new RowMapper<DocumentGridKeyValueDTO>() {
					@Override
					public DocumentGridKeyValueDTO mapRow(ResultSet rs,
							int rowNum) throws SQLException {
						DocumentGridKeyValueDTO keyValue = new DocumentGridKeyValueDTO();
						keyValue.setGridId(rs.getString("grid_id"));
						keyValue.setGridRowIndex(rs.getInt("grid_row_index"));
						keyValue.setKey(rs.getString("key"));
						keyValue.setValue(rs.getString("value"));
						return keyValue;
					}
				});
		return gridKeyValues;
	}

}
