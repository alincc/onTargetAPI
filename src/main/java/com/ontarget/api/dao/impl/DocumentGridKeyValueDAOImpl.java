package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.DocumentGridKeyValueDAO;
import com.ontarget.bean.DocumentGridKeyValue;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DocumentGridKeyValueDAOImpl
        extends BaseGenericDAOImpl<DocumentGridKeyValue>
        implements DocumentGridKeyValueDAO {

    @Override
    public DocumentGridKeyValue insert(DocumentGridKeyValue gridKeyVal) {
        jdbcTemplate.update(OnTargetQuery.documentGridKeyValue.ADD,
                gridKeyVal.getDocument().getDocumentId(),
                gridKeyVal.getGridId(),
                gridKeyVal.getGridRowIndex(),
                gridKeyVal.getKey(),
                gridKeyVal.getValue(),
                gridKeyVal.getCreatedBy(),
                gridKeyVal.getModifiedBy());
        return gridKeyVal;
    }

    @Override
    public DocumentGridKeyValue read(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean update(DocumentGridKeyValue bean) {
        return false;
    }

    @Override
    public List<DocumentGridKeyValue> getByDocumentIdAndGridId(long documentId,
                                                               String gridId) {
        List<DocumentGridKeyValue> gridKeyValues = jdbcTemplate.query(OnTargetQuery.documentGridKeyValue.GET_BY_DOCUMENT_GRID,
                new Object[]{documentId},
                new RowMapper<DocumentGridKeyValue>() {
                    @Override
                    public DocumentGridKeyValue mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        DocumentGridKeyValue keyValue = new DocumentGridKeyValue();
                        keyValue.setGridRowIndex(rs.getInt("grid_row_index"));
                        keyValue.setKey(rs.getString("key"));
                        keyValue.setValue(rs.getString("value"));
                        return keyValue;
                    }
                });
        return gridKeyValues;
    }

    @Override
    public boolean updateValue(long documentId, String gridId,
                               int gridRowIndex, String key, String newValue, String modifiedBy) {
        int count = jdbcTemplate.update(OnTargetQuery.documentGridKeyValue.UPDATE_VALUE,
                newValue, modifiedBy, documentId, gridId, gridRowIndex, key);
        return (count > 0);
    }

    @Override
    public List<DocumentGridKeyValue> getByDocumentId(long documentId) {
        List<DocumentGridKeyValue> gridKeyValues = jdbcTemplate.query(OnTargetQuery.documentGridKeyValue.GET_BY_DOCUMENT,
                new Object[]{documentId},
                new RowMapper<DocumentGridKeyValue>() {
                    @Override
                    public DocumentGridKeyValue mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        DocumentGridKeyValue keyValue = new DocumentGridKeyValue();
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
