package com.ontarget.api.dao;

import com.ontarget.bean.UserRegistration;

/**
 * Created by sumit on 11/26/14.
 */
public interface UserRegistrationDAO {

    int saveRegistrationInvitation(long projectId, String firstName, String lastName, String email, String tokenId, String accountStatus) throws Exception;

    public UserRegistration getInvitationRegistration(String tokenId) throws Exception;

    public void createNewuser(UserRegistration registration) throws Exception;

    public int updateRegistrationRequestUserId(int userId, String tokenId) throws Exception;

    public int activateAccount(int userId) throws Exception;

    public UserRegistration getInvitationRegistrationByUser(int userId) throws Exception;
}
