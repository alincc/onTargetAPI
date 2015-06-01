package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

	@Query("select c from Contact c where c.user.id = ?1")
	List<Contact> findByUserId(Integer userId);
	
	

}
