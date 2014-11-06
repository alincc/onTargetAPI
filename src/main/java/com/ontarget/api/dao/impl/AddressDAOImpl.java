package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.AddressDAO;
import com.ontarget.bean.Address;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Owner on 11/5/14.
 */
@Repository
public class AddressDAOImpl implements AddressDAO {

    private Logger logger = Logger.getLogger(AddressDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addAddress(Address address) throws Exception {
        logger.info("Adding address: "+address);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.ADD_ADDRESS, new String[] {"id"});
                        ps.setString(1, address.getAddress1());
                        ps.setString(2, address.getAddress2());
                        ps.setString(3, address.getCity());
                        ps.setString(4, address.getState());
                        ps.setString(5, address.getZipcode());
                        ps.setString(6, address.getCountry());
                        ps.setString(7, address.getAddressType());
                        return ps;
                    }
                },
                keyHolder);
        logger.debug("Added address with id: "+keyHolder.getKey().intValue());
        return keyHolder.getKey().intValue();
    }
}
