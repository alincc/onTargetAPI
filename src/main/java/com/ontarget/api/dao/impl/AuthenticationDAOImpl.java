package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.bean.UserRegistrationRequest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Owner on 10/30/14.
 */
@Repository
public class AuthenticationDAOImpl implements AuthenticationDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception {

        int row = jdbcTemplate.update(OnTargetQuery.REGISTRATION_REQUEST,new Object[]{request.getName(),request.getEmail(),request.getCompanyName(),request.getPhoneNumber(),request.getMsg(), OnTargetConstant.REGISTRATIOIN_PENDING});
        if(row <=0){
            throw new Exception("Error while inserting registration request.");
        }

        return true;
    }


}
