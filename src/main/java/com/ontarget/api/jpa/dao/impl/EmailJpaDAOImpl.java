package com.ontarget.api.jpa.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.EmailDAO;
import com.ontarget.api.dao.impl.BaseGenericDAOImpl;
import com.ontarget.api.repository.EmailRepository;
import com.ontarget.bean.Email;

@Repository("emailJpaDAOImpl")
public class EmailJpaDAOImpl extends BaseGenericDAOImpl<Email> implements EmailDAO {
	@Resource
	private EmailRepository emailRepository;

	@Override
	public Email insert(Email bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Email read(long id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(Email bean) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Email getByContactId(int contactId) {
		throw new UnsupportedOperationException();
	}

}
