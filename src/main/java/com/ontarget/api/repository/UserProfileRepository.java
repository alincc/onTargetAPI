package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
	@Query("select up from UserProfile up JOIN up.user u where u.userId = ?1")
	UserProfile findByUserId(Integer userId);

}
