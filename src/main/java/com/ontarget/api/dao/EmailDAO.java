package com.ontarget.api.dao;


import com.ontarget.bean.Email;

public interface EmailDAO extends GenericDAO<Email> {
	Email getByContactId(int contactId);

    com.ontarget.entities.Email getByEmailAddress(String emailAddress) throws Exception;
}
