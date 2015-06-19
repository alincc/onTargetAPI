package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProfileMenu;
import com.ontarget.entities.ProfilePermission;

public interface PermissionProfileRepository extends JpaRepository<ProfilePermission, Integer> {
	ProfileMenu findByProfilePermissionId(Integer profilePermissionId);

	@Query("select c from ProfilePermission c where c.applicationPermission.applicationPermissionId = ?1 and c.profile.profileId = ?2")
	ProfileMenu findByPermissionIdAndProfileId(Integer applicationPermissionId, Integer profileId);
}
