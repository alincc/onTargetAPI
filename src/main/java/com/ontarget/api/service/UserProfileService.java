package com.ontarget.api.service;

import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UserRegistration;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;

/**
 * Created by Owner on 11/4/14.
 */
public interface UserProfileService {

    public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception;

    public OnTargetResponse updateUserProfileAndContactInfo(UserProfileRequest request) throws Exception;

    public boolean changeUserPassword(long userId, String newPassword, String currentPassword) throws Exception;

    public boolean saveRegistration(long projectId, String firstName, String lastName, String email, String tokenId, String accountStatus) throws Exception;

    public Contact getContact(long userId) throws Exception;

    public UserRegistration getRegistration(String token) throws Exception;

    public Company getCompanyInfoByUser(int userId) throws Exception;

    public String getRandomSafetyUserInfo(long userId) throws Exception;

    boolean createNewUserFromInvitation(UserRegistration registration) throws Exception;

    boolean activateAccount(int userId) throws Exception;

    public boolean saveUserImage(UserImageRequest userImageRequest) throws Exception;

    int generateUserId();
}
