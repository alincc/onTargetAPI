package com.ontarget.api.rs;

import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.UserProjectProfileRequest;
import org.junit.Test;

import javax.ws.rs.core.Response;

/**
 * Created by TRON on 1/28/2016.
 */
public class UserProjectProfileEndpointTest extends BaseTest {


    @Test
    public void saveUpdateUserProfile(){


        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setLoggedInUserId(11);
        baseRequest.setLoggedInUserProjectId(45);

        UserProjectProfileRequest request = new UserProjectProfileRequest();
        request.setBaseRequest(baseRequest);
        request.setProfileCode("PM");

        System.out.println("Client request ....getProjectMembers \n");
        System.out.println(toJsonString(request, true));
        Response response = sendRequest("/project/profile/save", request);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.readEntity(String.class);
        System.out.println("Server response .... \n");
        System.out.println(output);

    }
}
