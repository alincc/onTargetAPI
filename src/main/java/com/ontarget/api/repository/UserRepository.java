package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

	User findByUserId(Integer userId);

	@Query("select u from User u where u.userName = ?1 and u.accountStatus !='LOCKED'")
	User findUserLogin(String username);
}
