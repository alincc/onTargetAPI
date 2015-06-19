package com.ontarget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ontarget.entities.ProfileMenu;

public interface ProfileMenuRepository extends JpaRepository<ProfileMenu, Integer> {
	ProfileMenu findByProfileMenuId(Integer profileMenuId);

	@Query("select c from ProfileMenu c where c.applicationMenu.applicationMenuId = ?1 and c.profile.profileId = ?2")
	ProfileMenu findByMenuIdAndProfileId(Integer applicationMenuId, Integer profileId);
}
