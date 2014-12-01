package com.ontarget.api.dao;

/**
 * Created by sumit on 11/26/14.
 */
public interface UserRegistrationDAO {
    int saveRegistrationInvitation(long projectId, String firstName, String lastName, String email, String tokenId) throws Exception;
}
