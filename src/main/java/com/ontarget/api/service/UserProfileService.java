package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfileService {

    public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception;


    public Company getCompanyInfoByUser(int userId) throws Exception;
}
