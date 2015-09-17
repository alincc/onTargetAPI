package com.ontarget.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProfileFeature;

public interface ProfileFeatureRepository extends JpaRepository<ProfileFeature, Integer> {

	@Query("select pf from ProfileFeature pf where pf.profile.profileId = ?1")
	List<ProfileFeature> findByProfileId(Integer profileId);
}
