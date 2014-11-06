package com.ontarget.api.service.impl;

import com.ontarget.api.dao.AddressDAO;
import com.ontarget.api.dao.ProjectDAO;
import com.ontarget.api.service.ProjectService;
import com.ontarget.bean.Address;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.dto.ProjectRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Owner on 11/6/14.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private Logger logger = Logger.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private AddressDAO addressDAO;


    @Override
    public OnTargetResponse addProject(ProjectRequest request) throws Exception {
        logger.info("Adding new project "+ request.getProject());

        //add project address first.
        Address projectAddress=request.getProject().getProjectAddress();
        projectAddress.setAddressType(OnTargetConstant.AddressType.PROJECT_ADDR);
        int addressId = addressDAO.addAddress(projectAddress);

        projectAddress.setAddressId(addressId);

        int projectId = projectDAO.addProject(request.getProject());

        OnTargetResponse response=null;
        if(projectId > 0){
            response.setReturnMessage("Successfully created project.");
            response.setReturnVal(OnTargetConstant.SUCCESS);
        }else{
            throw new Exception("Error while creating project");
        }



        return response;
    }


}
