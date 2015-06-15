package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer>{
	@Query("select p from Phone p where p.contact.id = ?1")
	List<Phone> findByContactId(Integer contactId);
}
