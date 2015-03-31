package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Integer>{

	@Query("select e from Email e where e.contact.id = ?1")
	Email findByContactId(Integer contactId);
}
