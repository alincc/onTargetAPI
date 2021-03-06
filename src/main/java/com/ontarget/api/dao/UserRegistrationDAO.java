package com.ontarget.api.dao;

import com.ontarget.bean.UserRegistration;
import com.ontarget.dto.UserInvitationRequestDTO;
import com.ontarget.entities.User;
import com.ontarget.entities.UserProfile;
import com.ontarget.request.bean.UserSignupRequest;

/**
 * Created by sumit on 11/26/14.
 */
public interface UserRegistrationDAO {

	public boolean saveRegistrationInvitation(UserInvitationRequestDTO userInvitationRequestDTO,String status) throws Exception;

	public UserRegistration getInvitationRegistration(String tokenId) throws Exception;

	public User createNewuser(UserSignupRequest request, String status) throws Exception;

	public int updateRegistrationRequestUserId(int userId, String tokenId) throws Exception;
	
	public int updateRegistrationRequestCompanyId(int companyId, String tokenId) throws Exception;

	public int activateAccount(int userId) throws Exception;

	public UserRegistration getInvitationRegistrationByUser(int userId) throws Exception;
	
	public UserProfile assignProfilesToUser(String userType,int userId);
}
