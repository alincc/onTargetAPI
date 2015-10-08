package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

<<<<<<< HEAD
	@Query(value = "select up from UserProfile up where up.user.userId=?1")
=======
    @Query(value = "select up from UserProfile up where up.user.userId=?1")
>>>>>>> ontarget.phase4
	UserProfile getUserProfielbyUserId(Integer userId);

}
