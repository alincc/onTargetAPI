package com.ontarget.api.dao.impl;

import com.ontarget.api.dao.AuthenticationDAO;
import com.ontarget.bean.Project;
import com.ontarget.bean.User;
import com.ontarget.dto.UserRegistrationRequest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.constant.OnTargetQuery;

import com.ontarget.util.TokenUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Owner on 10/30/14.
 */
@Repository
public class AuthenticationDAOImpl implements AuthenticationDAO {

	private Logger logger = Logger.getLogger(AuthenticationDAO.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean saveRegistrationRequest(UserRegistrationRequest request) throws Exception {

        int row = jdbcTemplate.update(OnTargetQuery.REGISTRATION_REQUEST,new Object[]{request.getProjectId(),request.getName(),request.getEmail(),request.getCompanyName(),request.getPhoneNumber(),request.getMsg(), OnTargetConstant.REGISTRATION_PENDING});
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
    public boolean approvePendingRegistrationRequest(UserRegistrationRequest req) throws Exception{
        // approve the user request.

            boolean approved = this.approveUserRequest(req.getRegistrationReqId());
            if(!approved){
                throw new Exception("User cannot be approved for request id: "+ req.getRegistrationReqId());
            }

            boolean created = this.createUser(req);
            if(!created){
                throw new Exception("User cannot be created for request id: "+  req.getRegistrationReqId());
            }



        return true;
    }


    @Override
    public boolean approveUserRequest(int userRequestId) throws Exception{
        int row = jdbcTemplate.update(OnTargetQuery.APPROVE_PENDING_USER_REQUEST, new Object[]{OnTargetConstant.REGSITRATION_REQUEST_APPROVED,userRequestId});
        if(row > 0){
            return true;
        }

        return false;
    }

    @Override
    public boolean createUser(UserRegistrationRequest request) throws Exception {
        int row = jdbcTemplate.update(OnTargetQuery.CREATE_NEW_USER,new Object[]{request.getEmail(), 1 ,TokenUtil.getPasswordToken(), OnTargetConstant.USER_STATUS.PENDING, 1 , OnTargetConstant.AccountStatus.ACCT_NEW});
        if(row > 0){
            return true;
        }

        return false;
    }
    
    @Override
    public User getUserSignInInfo(User user) throws Exception {
    	logger.info("Authenticating user: "+ user);

       final User returnUser = new User();
       jdbcTemplate.query(OnTargetQuery.USER_LOGIN, new Object[]{user.getUsername(), user.getPassword()}, new RowMapper<User>() {
           @Override
           public User mapRow(ResultSet resultSet, int i) throws SQLException {
               returnUser.setUsername(user.getUsername());
               returnUser.setUserId(resultSet.getInt("user_id"));
               returnUser.setAccountStatus(resultSet.getString("account_status"));
               returnUser.setUserStatus(resultSet.getString("user_status"));
               returnUser.setUserTypeId(resultSet.getInt("user_type_id"));
               return returnUser;
           }
       });
        return returnUser;

    }

    @Override
    public boolean changePassword(long userId, String password, String salt) throws Exception {
        System.out.println("user "+userId+" password "+password+" salt "+salt);
        int row = jdbcTemplate.update(OnTargetQuery.CHANGE_USER_PASSWORD, new Object[]{password, salt, userId});
        return row > 0;
    }
}
