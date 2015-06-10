package com.ontarget.api.jpa.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.PhoneDAO;
import com.ontarget.api.repository.PhoneRepository;
import com.ontarget.bean.ContactPhone;
import com.ontarget.entities.Contact;
import com.ontarget.entities.Phone;

@Repository("phoneJpaDAOImpl")
public class PhoneJpaDAOImpl implements PhoneDAO {
	@Resource
	private PhoneRepository phoneRepository;

	private Logger logger = Logger.getLogger(PhoneJpaDAOImpl.class);

	@Override
	public int addContactPhone(int contactId, ContactPhone contactPhone) throws Exception {
		List<Phone> phoneList = phoneRepository.findByContactId(contactId);
		Phone phone;
		if(phoneList == null || phoneList.isEmpty()){
			phone = new Phone();
			phone.setContact(new Contact(contactId));
		}else{
			phone = phoneList.get(0);
		}
		phone.setAreaCode(contactPhone.getAreaCode());
		phone.setPhoneNumber(contactPhone.getPhoneNumber());
		phone.setPhoneType(contactPhone.getPhoneType());
		phone.setStatus(contactPhone.getStatus());
		phoneRepository.save(phone);

		return phone.getPhoneId();
	}

}
