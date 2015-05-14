package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.TimeCard;

public interface TimeCardRepository extends JpaRepository<TimeCard, Integer> {

	TimeCard findById(Integer id);
}
