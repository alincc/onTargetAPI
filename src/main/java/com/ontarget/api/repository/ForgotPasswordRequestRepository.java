package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ForgotPasswordRequest;

public interface ForgotPasswordRequestRepository extends JpaRepository<ForgotPasswordRequest, Long> {

	@Query("select f from ForgotPasswordRequest f where f.forgotPasswordToken= ?1 and f.status='ACTIVE' and f.tsExpiry > now()")
	ForgotPasswordRequest findExpiredRequestByToken(String token);

	@Query("select count(f) from ForgotPasswordRequest f where f.forgotPasswordToken= ?1 and f.status='ACTIVE' and f.tsExpiry > now()")
	Long countExpiredRequestByToken(String token);
}
