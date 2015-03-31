package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.RegistrationRequest;

public interface RegistrationRequestRepository extends
		JpaRepository<RegistrationRequest, Long> {
	
	RegistrationRequest findById(Long id);
	
	RegistrationRequest findByEmail(String email);
	
	RegistrationRequest findByRegistrationToken(String token);
	
	RegistrationRequest findByUserId(Integer userId);
	
	List<RegistrationRequest> findByStatus(String status);
	
	@Query("select r from RegistrationRequest r where r.status = 'PENDING' and r.projectId is null")
	List<RegistrationRequest> getPendingRegistrationRequests();
	
	@Modifying
	@Query("update RegistrationRequest r set r.status = ?1 where r.userId = ?2")
	int activeUserAccount(String status,Integer userId);
	
	

}
