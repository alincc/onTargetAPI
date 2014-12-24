package com.ontarget.api.dao;

import com.ontarget.bean.Contact;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Owner on 11/4/14.
 */
public interface ContactDAO {

    public boolean addContactInfo(Contact contact) throws Exception;

    public Map<String, Object> getContactDetail(int userId) throws Exception;

    public boolean updateContactInfo(Contact contact) throws Exception;

    public Contact getContact(long userId) throws Exception;

    public boolean saveUserImagePath(int userId, String path, long modifier) throws Exception;
}
