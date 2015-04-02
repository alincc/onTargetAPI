package com.ontarget.api.dao;

import com.ontarget.bean.UserRegistration;
import com.ontarget.request.bean.UserRegistrationInfo;

/**
 * Created by sumit on 11/26/14.
 */
public interface UserRegistrationDAO {

	int saveRegistrationInvitation(int projectId, String firstName,
			String lastName, String email, String tokenId, String accountStatus)
			throws Exception;

	public UserRegistration getInvitationRegistration(String tokenId)
			throws Exception;

	public void createNewuser(UserRegistrationInfo registration, String status,
			int userId) throws Exception;

	public int updateRegistrationRequestUserId(int userId, String tokenId)
			throws Exception;

	public int activateAccount(int userId) throws Exception;

	public UserRegistration getInvitationRegistrationByUser(int userId)
			throws Exception;
}
