package com.ontarget.api.dao;

import com.ontarget.bean.ContactPhone;

/**
 * Created by Owner on 12/9/14.
 */
public interface PhoneDAO {

    public int addContactPhone(int contactId, ContactPhone phone) throws  Exception;

}
