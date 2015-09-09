package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.ontarget.entities.ApplicationPermission;
import com.ontarget.entities.PermissionMappedRequest;

public interface PermissionMappedRequestRepository extends JpaRepository<PermissionMappedRequest, Integer> {

	@Query("select pmr from PermissionMappedRequest pmr where pmr.requestPath =?1")
	PermissionMappedRequest findPermissionMappedByRequestPath(String requestPath);

	@Transactional
	@Query("select ap from UserProfile up JOIN up.user u JOIN up.permissionProfile pp JOIN pp.profilePermissionList ppl"
			+ " JOIN ppl.applicationPermission ap WHERE u.userId =?1 and ap.applicationPermissionId =?2 and ap.active = 'Y' and ppl.active ='Y' and pp.profileType='PERMISSION'")
	ApplicationPermission hasPermissionToUser(Integer userId, Integer applicationPermissionId);
}
