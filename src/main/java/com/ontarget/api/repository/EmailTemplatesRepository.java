package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.EmailTemplates;

public interface EmailTemplatesRepository extends JpaRepository<EmailTemplates, Integer>{

}
