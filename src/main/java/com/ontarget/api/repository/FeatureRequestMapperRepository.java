package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import com.ontarget.entities.ApplicationFeature;
import com.ontarget.entities.FeatureRequestMapper;

public interface FeatureRequestMapperRepository extends JpaRepository<FeatureRequestMapper, Integer> {

	@Query("select pmr from FeatureRequestMapper pmr where pmr.requestPath =?1")
	FeatureRequestMapper findByRequestPath(String requestPath);

	@Transactional
	@Query("select af from UserProfile up JOIN up.user u JOIN up.profile p JOIN p.profileFeatureList pfl"
			+ " JOIN pfl.applicationFeature af WHERE u.userId =?1 and af.applicationFeatureId =?2 and af.active = 'Y' and pfl.active ='Y'")
	ApplicationFeature hasPermissionToUser(Integer userId, Integer applicationFeatureId);
}
