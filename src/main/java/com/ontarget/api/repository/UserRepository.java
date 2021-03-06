package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

	@Query("select u from User u where u.userId = ?1")
	User findByUserId(Integer userId);

	@Query("select u from User u where u.userName = ?1 and u.accountStatus !='LOCKED'")
	User findUserLogin(String username);

	@Query("select u from User u where u.userName = ?1")
	List<User> findUserByUsername(String username);

	@Query("select u from User u join u.emailList e where e.emailAddress = ?1")
	User findUserByEmail(String email);

	@Modifying
	@Query("update User u set u.accountStatus = ?1 where u.userId = ?2")
	int activeUserAccount(String status, Integer userId);
}
