package com.ontarget.api.dao;

import com.ontarget.bean.Contact;
import org.springframework.stereotype.Repository;

/**
 * Created by Owner on 11/4/14.
 */
public interface ContactDAO {

    public boolean addContactInfo(Contact contact) throws Exception;

}
