package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ontarget.entities.UserSessionInfo;

public interface UserSessionRepository extends JpaRepository<UserSessionInfo, Integer> {

}
