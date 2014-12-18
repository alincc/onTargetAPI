package com.ontarget.api.service.impl;

import com.ontarget.api.dao.*;
import com.ontarget.api.service.UserProfileService;

import com.ontarget.bean.*;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.util.Security;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Owner on 11/4/14.
 */
@Service
public class UserProfileServiceImpl implements UserProfileService {

    private Logger logger = Logger.getLogger(UserProfileServiceImpl.class);

    @Autowired
    private CompanyDAO companyDAO;


    @Autowired
    private ContactDAO contactDAO;

    @Autowired
    private AuthenticationDAO authenticationDAO;

    @Autowired
    private UserRegistrationDAO userRegistrationDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserSafetyInfoDAO userSafetyInfoDAO;

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private PhoneDAO phoneDAO;

    //TODO: separate logic of user profile and company profile.
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception {
        logger.info("Request to add user profile" + request);
        UserProfileResponse response = new UserProfileResponse();
        //add company.

        int companyId = companyDAO.addCompanyInfo(request.getCompany());

        Contact contact = request.getContact();

        Company company = request.getCompany();
        company.setCompanyId(companyId);

        contact.setCompany(company);
        contact.setUser(request.getUser());

        boolean saved = contactDAO.addContactInfo(request.getContact());
        if (!saved) {
            throw new Exception("Contact not saved.");
        }

        Contact contactForPhone = contactDAO.getContact(request.getUser().getUserId());
        int contactId = contactForPhone.getContactId();

        //phone type should be CELL. THIS NEEDS TO BE COLLECTED FROM UI.
        ContactPhone phone = request.getContactPhone();
        phone.setPhoneType(OnTargetConstant.PhoneType.CELL);
        phone.setStatus(OnTargetConstant.PhoneStatus.ACTIVE);

        int phoneId = phoneDAO.addContactPhone(contactId, request.getContactPhone());

        if (phoneId <= 0) {
            throw new Exception("Error while adding phone");
        }

        //activate the account.
        String accountStatus = request.getUser().getAccountStatus();
        if(OnTargetConstant.AccountStatus.ACCOUNT_INVITATION.equals(accountStatus)) {
            boolean updated = this.activateAccount(request.getUser().getUserId());
            if(!updated){
                throw new Exception("Error while activating account");
            }
        }


        response.setReturnMessage("Successfully created company and user profile");
        response.setReturnVal(OnTargetConstant.SUCCESS);

        response.setCompany(company);

        return response;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public OnTargetResponse updateUserProfileAndContactInfo(UserProfileRequest request) throws Exception {
        logger.info("Request to add user profile" + request);
        OnTargetResponse response = new OnTargetResponse();
        Contact contact = request.getContact();
        contact.setUser(request.getUser());

        boolean saved = contactDAO.updateContactInfo(request.getContact());
        if (saved) {
            response.setReturnMessage("Successfully created company and user profile");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        } else {
            response.setReturnMessage("No Rows were updated. Seems User does not exists or may not have any contact info");
            response.setReturnVal(OnTargetConstant.ERROR);
        }

        return response;
    }

    public Contact getContact(long userId) throws Exception {
        return contactDAO.getContact(userId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean changeUserPassword(long userId, String password) throws Exception {
        String salt = Security.generateSecureSalt();
        String hashedPassword = Security.encodePassword(password, salt);
        return authenticationDAO.changePassword(userId, hashedPassword, salt);
    }

    @Override
    public Company getCompanyInfoByUser(int userId) throws Exception {
        return null;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean saveRegistration(long projectId, String firstName, String lastName, String email, String tokenId, String accountStatus) throws Exception {
        return userRegistrationDAO.saveRegistrationInvitation(projectId, firstName, lastName, email, tokenId, accountStatus) != 0;
    }

    public UserRegistration getRegistration(String token) throws Exception {
        return userRegistrationDAO.getInvitationRegistration(token);
    }

    @Override
    public String getRandomSafetyUserInfo(long userId) throws Exception {
        User user = userDAO.getUser(userId);
        if (user.getDiscipline() == 0) {
            return null;
        }

        return userSafetyInfoDAO.getRandomSafetyInfo(user.getDiscipline());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public boolean createNewUserFromInvitation(UserRegistration registration) throws Exception {
        //get token info and create user based on the status: ACCT_NEW or ACCT_INVITE
        UserRegistration registrationFromDB = userRegistrationDAO.getInvitationRegistration(registration.getRegistrationToken());
        registration.setStatus(registrationFromDB.getStatus());
        int userId = userRegistrationDAO.createNewuser(registration);
        if (userId <= 0) {
            throw new Exception("Error while adding user.");
        }

        // update registration request user id by token.
        int updated = userRegistrationDAO.updateRegistrationRequestUserId(userId, registration.getRegistrationToken());
        if (updated <= 0)
            throw new Exception("Error while updating registration request user id");

        return true;
    }

    @Override
    public boolean activateAccount(int userId) throws Exception {
        int updated = userRegistrationDAO.activateAccount(userId);
        if (updated <= 0) {
            throw new Exception("Error while activating account");
        }

        // update project member
        UserRegistration userRegistration = userRegistrationDAO.getInvitationRegistrationByUser(userId);
        int added = projectDAO.addProjectMember((int) userRegistration.getProjectId(), userId);
        if (added <= 0) {
            throw new Exception("Error while adding project member");
        }

        return true;
    }

    @Override
    public boolean saveUserImage(UserImageRequest userImageRequest) throws Exception{
        return contactDAO.saveUserImagePath(userImageRequest.getUserId(), userImageRequest.getImagePath(), userImageRequest.getModifyingUser());
    }
}
