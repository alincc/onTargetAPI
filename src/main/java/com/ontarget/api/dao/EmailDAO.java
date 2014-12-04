package com.ontarget.api.dao;

import com.ontarget.api.dao.GenericDAO;
import com.ontarget.bean.Email;

public interface EmailDAO extends GenericDAO<Email> {
	Email getByContactId(int contactId);
}
