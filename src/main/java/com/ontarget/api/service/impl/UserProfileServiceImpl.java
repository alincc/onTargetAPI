package com.ontarget.api.service.impl;

import com.ontarget.api.dao.*;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.User;
import com.ontarget.bean.User;
import com.ontarget.bean.UserRegistration;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.dto.UserProfileResponse;
import com.ontarget.util.Security;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

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

    //TODO: separate logic of user profile and company profile.
    @Override
    @Transactional(rollbackFor={Exception.class})
    public UserProfileResponse addUserProfile(UserProfileRequest request) throws Exception {
        logger.info("Request to add user profile"+ request);
        UserProfileResponse response=new UserProfileResponse();
        //add company.

            int companyId = companyDAO.addCompanyInfo(request.getCompany());

            Contact contact=request.getContact();

            Company company=request.getCompany();
            company.setCompanyId(companyId);

            contact.setCompany(company);
            contact.setUser(request.getUser());

            boolean saved=contactDAO.addContactInfo(request.getContact());
            if(!saved){
                throw new Exception("Contact not saved.");
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
    public Company getCompanyInfoByUser(int userId) throws Exception{
        return null;
    }

    public boolean saveRegistration(long projectId, String firstName, String lastName, String email, String tokenId) throws Exception {
        return userRegistrationDAO.saveRegistrationInvitation(projectId, firstName, lastName, email, tokenId) != 0;
    }

    public UserRegistration getRegistration(String token) throws Exception {
        return userRegistrationDAO.getInvitationRegistration(token);
    }

    public String getRandomSafetyUserInfo(long userId) throws Exception {
        User user = userDAO.getUser(userId);
        if(user.getDiscipline() == 0){
            return null;
        }

        return userSafetyInfoDAO.getRandomSafetyInfo(user.getDiscipline());
    }
}
