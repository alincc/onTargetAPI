package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

    public Email getByEmailAddress(String emailAddress) throws Exception;

}
