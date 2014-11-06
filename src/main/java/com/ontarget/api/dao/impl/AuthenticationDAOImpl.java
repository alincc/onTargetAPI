package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        if(row ==0){
            throw new Exception("Error while inserting registration request.");
        }

        return true;
    }

    @Override
    public boolean logout(String username) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.EXPIRE_TOKEN,new Object[]{username});
        if(row ==0){
            throw new Exception("Error while inserting registration request.");
        }
        return true;
    }

    @Override
    public UserRegistrationRequest getUserRegistrationRequestInfo(int userRequestId) throws Exception {
        return jdbcTemplate.queryForObject(OnTargetQuery.GET_USER_REQUEST_INFO, new Object[]{userRequestId}, new BeanPropertyRowMapper<UserRegistrationRequest>(UserRegistrationRequest.class));
    }

    @Override
    public List<UserRegistrationRequest> getUserRegistrationPendingRequests() throws Exception {
        return jdbcTemplate.queryForList(OnTargetQuery.GET_USER_REGISTRATION_PENDING_REQUEST, UserRegistrationRequest.class);
    }

    @Override
    public boolean approvePendingRegistrationRequest(List<UserRegistrationRequest> requests) throws Exception{
        // approve the user request.
        for(UserRegistrationRequest req : requests){
            boolean approved = this.approveUserRequest(req.getRegistrationReqId());
            if(!approved){
                throw new Exception("User cannot be approved for request id: "+ req.getRegistrationReqId());
            }

            boolean created = this.createUser(req);
            if(!created){
                throw new Exception("User cannot be created for request id: "+  req.getRegistrationReqId());
            }

        }

        return true;
    }


    @Override
    public boolean approveUserRequest(int userRequestId) throws Exception{
        int row = jdbcTemplate.update(OnTargetQuery.APPROVE_PENDING_USER_REQUEST, new Object[]{userRequestId});
        if(row > 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean createUser(UserRegistrationRequest request) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.CREATE_NEW_USER,new Object[]{request.getEmail(), 1 , OnTargetConstant.USER_STATUS.ACTIVE, 1 , OnTargetConstant.AccountStatus.ACTIVE});
        if(row > 0){
            return true;
        }

        return false;
    }

}
