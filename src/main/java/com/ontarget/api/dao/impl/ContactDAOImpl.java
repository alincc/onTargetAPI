package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.bean.Contact;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Owner on 11/4/14.
 */
@Repository
public class ContactDAOImpl implements ContactDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean addContactInfo(Contact contact) throws Exception{

        int row = jdbcTemplate.update(OnTargetQuery.CREATE_CONTACT, new Object[]{contact.getUser().getUserId(),contact.getCompany().getCompanyId(),contact.getFirstName(),contact.getLastName(), contact.getTitle()});

        if(row <= 0){
            throw new Exception("Contact was not created");
        }

        return true;
    }

    @Override
    public Map<String, Object> getContactDetail(int userId) throws Exception{
        return jdbcTemplate.queryForMap(OnTargetQuery.GET_COMPANY_BY_USER, new Object[]{userId});
    }



}
