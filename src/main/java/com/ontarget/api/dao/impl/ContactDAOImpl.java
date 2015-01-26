package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.bean.Contact;
import com.ontarget.bean.User;
import com.ontarget.constant.OnTargetQuery;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 11/4/14.
 */
@Repository
public class ContactDAOImpl implements ContactDAO {

    private Logger logger = Logger.getLogger(ContactDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean addContactInfo(Contact contact) throws Exception {

        int row = jdbcTemplate.update(OnTargetQuery.CREATE_CONTACT, new Object[]{contact.getUser().getUserId(), contact.getCompany().getCompanyId(), contact.getFirstName(), contact.getLastName(), contact.getTitle(), contact.getUserImagePath()});

        if (row <= 0) {
            throw new Exception("Contact was not created");
        }

        return true;
    }

    @Override
    public boolean updateContactInfo(Contact contact) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_CONTACT, new Object[]{contact.getFirstName(), contact.getLastName(), contact.getTitle(), contact.getUserImagePath(), contact.getUser().getUserId()});
        return row > 0;
    }

    @Override
    public Map<String, Object> getContactDetail(int userId) throws Exception {
        List<Map<String, Object>> results = jdbcTemplate.queryForList(OnTargetQuery.GET_CONTACT_BY_USER, new Object[]{userId});
        if(results == null || results.isEmpty()){
            throw new Exception("User does not exists");
        }

        return results.get(0);
    }

    @Override
    public Contact getContact(long userId) throws Exception {
        logger.info("getting contact for user "+ userId);
        List<Map<String, Object>> results = jdbcTemplate.queryForList(OnTargetQuery.GET_CONTACT_BY_USER, new Object[]{userId});
        if(results == null || results.isEmpty()){
            throw new Exception("User "+userId+" does not exists");
        }
        Map<String, Object> rs = results.get(0);
        Contact contact = new Contact();
        contact.setContactId((Integer) rs.get("contact_id"));
        User user = new User();
        user.setUserId((int)userId);
        contact.setUser(user);
        contact.setFirstName((String) rs.get("first_name"));
        contact.setLastName((String) rs.get("last_name"));
        contact.setTitle((String) rs.get("title"));
        contact.setUserImagePath((String) rs.get("contact_image"));
        return contact;
    }

    public boolean saveUserImagePath(int userId, String path, long modifier) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.UPDATE_USER_IMAGE, new Timestamp(System.currentTimeMillis()), modifier, path, userId);
        return row > 0;
    }
}
