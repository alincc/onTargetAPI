package com.ontarget.api.repository;

import com.ontarget.entities.UserProjectProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/9/15.
 */
public interface UserProjectProfileRepository extends JpaRepository<UserProjectProfile, Integer> {

    public UserProjectProfile findByUserProjectProfileId(Integer userProjectProfileId);

    @Query("select upp from UserProjectProfile upp where upp.project.projectId=?1 and upp.user.userId=?2 and upp.status='Y'")
    public UserProjectProfile getProfileByUserAndProject(Integer projectId, Integer userId);

    @Query("select upp from UserProjectProfile upp where upp.user.userId=?2")
    public List<UserProjectProfile> findByUserId(Integer userId);
}
