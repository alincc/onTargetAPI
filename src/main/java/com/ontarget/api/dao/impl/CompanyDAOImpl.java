package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.bean.Address;
import com.ontarget.bean.Company;
import com.ontarget.bean.Project;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                                connection.prepareStatement(OnTargetQuery.CREATE_COMPANY, new String[]{"id"});
                        ps.setString(1, company.getCompanyName());
                        ps.setInt(2, company.getCompanyTypeId());
                        ps.setString(3, company.getAddress().getAddress1());
                        ps.setString(4, company.getAddress().getAddress2());
                        ps.setString(5, company.getAddress().getCity());
                        ps.setString(6, company.getAddress().getState());
                        ps.setString(7, company.getAddress().getZip());
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
//        Map<String, Object> map = jdbcTemplate.queryForMap(OnTargetQuery.GET_COMPANY, companyId);
//        Company company = new Company();
//        company.setCompanyName((String) map.get("company_name"));
//        return company;

//        return jdbcTemplate.queryForObject(OnTargetQuery.GET_COMPANY,
//                new Object[]{companyId},
//                new RowMapper<Company>() {
//                    @Override
//                    public Company mapRow(ResultSet rs, int index)
//                            throws SQLException {
//                        Company company = new Company();
//                        company.setCompanyName(rs.getString("company_name"));
//                        return company;
//
//                    }
//                });

        Company company = new Company();
        jdbcTemplate.query(OnTargetQuery.GET_PROJECT, new Object[]{companyId}, new RowMapper<Company>() {
            @Override
            public Company mapRow(ResultSet resultSet, int i) throws SQLException {
                company.setCompanyName(resultSet.getString("company_name"));
                return company;
            }
        });

        return company;
    }

    @Override
    public Map<String, Object> getCompanyByUser(int userId) throws Exception {
        return jdbcTemplate.queryForMap(OnTargetQuery.GET_CONTACT_BY_USER, new Object[]{userId});
    }

    public List<Company> getCompanyList() throws Exception {
        List<Map<String, Object>> rs = jdbcTemplate.queryForList(OnTargetQuery.GET_ALL_COMPANY, new Object[]{});
        List<Company> companies = new ArrayList<>();
        if (rs != null && rs.size() > 0) {
            for (Map<String, Object> map : rs) {
                Company company = new Company();
                company.setCompanyId((int) map.get("company_id"));
                company.setCompanyName((String) map.get("company_name"));
                company.setWebsite((String) map.get("website"));
                company.setCompanyTypeId((int) map.get("company_type_id"));

                Address address = new Address();
                address.setAddress1((String) map.get("address1"));
                address.setAddress2((String) map.get("address2"));
                address.setCity((String) map.get("city"));
                address.setCountry((String) map.get("country"));
                address.setState((String) map.get("state"));
                address.setZip((String) map.get("zipcode"));

                company.setAddress(address);
                companies.add(company);
            }
        }

        return companies;
    }
}
