package com.ontarget.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.UserSafetyInfo;

public interface UserSafetyInfoRepository extends JpaRepository<UserSafetyInfo, Long> {

	@Query("select u.name from UserSafetyInfo u where u.disciplineId = ?1 ORDER BY RAND()")
	Page<String> getUserSafetyInfo(Long disciplineId, Pageable pageable);

}
