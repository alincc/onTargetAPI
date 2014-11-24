package com.ontarget.api.dao;

import com.ontarget.bean.Contact;

import java.util.Map;

/**
 * Created by Owner on 11/4/14.
 */
public interface ContactDAO {

    public boolean addContactInfo(Contact contact) throws Exception;

    public Map<String, Object> getContactDetail(int userId) throws Exception;

}
