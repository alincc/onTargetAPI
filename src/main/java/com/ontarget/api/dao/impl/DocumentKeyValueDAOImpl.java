package com.ontarget.api.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.DocumentKeyValueDAO;
import com.ontarget.bean.DocumentKeyValue;
import com.ontarget.constant.OnTargetQuery;

@Repository
public class DocumentKeyValueDAOImpl 
		extends BaseGenericDAOImpl<DocumentKeyValue> 
		implements DocumentKeyValueDAO {

	@Override
	public DocumentKeyValue insert(DocumentKeyValue docKeyVal) {
		jdbcTemplate.update(OnTargetQuery.documentKeyValue.ADD, 
					docKeyVal.getDocument().getDocumentId(),
					docKeyVal.getKey(),
					docKeyVal.getValue(),
					docKeyVal.getCreatedBy().getUserId(),
					docKeyVal.getModifiedBy().getUserId());
		return docKeyVal;
	}

	@Override
	public DocumentKeyValue read(long id) {
		
		return null;
	}

	@Override
	public boolean update(DocumentKeyValue docKeyVal) {
		
		return false;
	}

	@Override
	public List<DocumentKeyValue> getByDocumentId(long documentId) {
		List<DocumentKeyValue> keyValues = jdbcTemplate.query(OnTargetQuery.documentKeyValue.GET_BY_DOCUMENT, 
					new Object[] { documentId }, 
					new RowMapper<DocumentKeyValue>() {

						@Override
						public DocumentKeyValue mapRow(ResultSet rs, int rowNum)
								throws SQLException {
							DocumentKeyValue keyValue = new DocumentKeyValue();
							keyValue.setKey(rs.getString("key"));
							keyValue.setValue(rs.getString("value"));
							return keyValue;
						}
			
		});
		return keyValues;
	}

	@Override
	public boolean updateValue(long documentId, String key, String newValue, String modifiedBy) {
		int count = jdbcTemplate.update(OnTargetQuery.documentKeyValue.UPDATE_VALUE, 
				newValue, modifiedBy, documentId, key);
		return (count > 0);
	}

}
