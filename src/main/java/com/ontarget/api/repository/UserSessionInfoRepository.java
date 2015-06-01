package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ontarget.entities.UserSessionInfo;

public interface UserSessionInfoRepository extends JpaRepository<UserSessionInfo, Integer> {

	@Modifying
	@Query("update UserSessionInfo u set u.isExpired = :isExpired where u.user.id = "
			+ "(select userId from User where userName = :userName) and u.isExpired ='0'")
	int updateUserSession(@Param("isExpired") String isExpired, @Param("userName") String userName);

}
