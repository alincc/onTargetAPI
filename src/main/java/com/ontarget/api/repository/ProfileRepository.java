package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	Profile findByProfileId(Integer profileId);

	@Query("select p from Profile p where UPPER(p.name) = ?1 and p.active !='D'")
	Profile findMenuProfileByName(String name);

	@Query("select p from Profile p where p.profileId != ?1 and UPPER(p.name) = ?2 and p.active !='D'")
	Profile findMenuProfileByIdAndName(Integer profileId, String name);

	@Query("select p from Profile p where p.active !='D' order by p.name asc")
	List<Profile> findAllMenuProfile();

	@Query("select p from Profile p where p.profileCode = ?1 and p.active !='D'")
	Profile findProfileByCode(String code);
}
