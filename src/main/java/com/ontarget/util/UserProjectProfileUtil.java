package com.ontarget.util;

import com.ontarget.entities.Profile;
import com.ontarget.entities.Project;
import com.ontarget.entities.User;
import com.ontarget.entities.UserProjectProfile;
import com.ontarget.request.bean.UserProjectProfileRequest;

/**
 * Created by TRON on 1/26/2016.
 */
public class UserProjectProfileUtil {

    public static UserProjectProfile getUserProjectProfileFromUserProfileRequest(UserProjectProfileRequest request){
        UserProjectProfile userProjectProfile = new UserProjectProfile();

        User user = new User();
        user.setUserId(request.getBaseRequest().getLoggedInUserId());
        userProjectProfile.setUser(user);

        Project project = new Project();
        project.setProjectId(request.getBaseRequest().getLoggedInUserProjectId());
        userProjectProfile.setProject(project);

        Profile profile = new Profile();
        profile.setProfileId(request.getProfileid());

        return userProjectProfile;
    }


}
