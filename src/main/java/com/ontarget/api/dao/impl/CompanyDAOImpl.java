package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.bean.Company;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
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
public class CompanyDAOImpl implements CompanyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addCompanyInfo(Company company) throws Exception {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                        PreparedStatement ps =
                                connection.prepareStatement(OnTargetQuery.CREATE_COMPANY, new String[] {"id"});
                        ps.setString(1, company.getCompanyName());
                        ps.setInt(2, company.getCompanyTypeId());
                        ps.setString(3, company.getAddress().getAddress1());
                        ps.setString(4, company.getAddress().getAddress2());
                        ps.setString(5, company.getAddress().getCity());
                        ps.setString(6, company.getAddress().getState());
                        ps.setString(7, company.getAddress().getZipcode());
                        ps.setString(8, company.getAddress().getCountry());
                        ps.setString(9, company.getWebsite());
                        ps.setString(10, OnTargetConstant.CompanyStatus.STATUS);

                        return ps;
                    }
                },
                keyHolder);



        return keyHolder.getKey().intValue();
    }

    @Override
    public Company getCompany(int companyId) throws Exception {
        return null;
    }
}