package com.ontarget.api.service.impl;

import com.ontarget.api.dao.CompanyDAO;
import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.UserProfileRequest;
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


    //TODO: separate logic of user profile and company profile.
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public OnTargetResponse addUserProfile(UserProfileRequest request) throws Exception {
        logger.info("Request to add user profile" + request);
        OnTargetResponse response = new OnTargetResponse();
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
        response.setReturnMessage("Successfully created company and user profile");
        response.setReturnVal(OnTargetConstant.SUCCESS);

        return response;

    }


}
