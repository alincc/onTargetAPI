package com.ontarget.api.rs;

import com.ontarget.bean.Address;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.User;
import com.ontarget.dto.UserProfileRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by Owner on 11/5/14.
 */
public class UserProfileTest extends JerseyTest{

    public UserProfileTest() throws TestContainerException {
        super("com.ontarget.api.rs");
    }

    @Test
    public void testAddUserProfile(){

        WebResource resource = resource();

        Contact contact = new Contact();
        contact.setTitle("Project Manager");
        contact.setFirstName("firstname");
        contact.setLastName("lastname");

        Company comp = new Company();
        comp.setCompanyName("The TTG Inc.");
        comp.setCompanyTypeId(1);
        comp.setEmail("company@company.com");
        comp.setWebsite("http://www.comp.com");

        Address address=new Address();
        address.setAddress1("4750 59th street");
        address.setAddress2("Apt #9C");
        address.setCity("Woodside");
        address.setState("NY");
        address.setZipcode("11377");
        address.setCountry("USA");
        address.setAddressType("COMPANY");
        comp.setAddress(address);

        User user=new User();
        user.setUserId(1);

        UserProfileRequest req = new UserProfileRequest();
        req.setCompany(comp);
        req.setUser(user);
        req.setContact(contact);

        ObjectMapper mapper=new ObjectMapper();

        ClientResponse response = null;
        try {
        System.out.println(mapper.writeValueAsString(req));
            response = resource.path("/profile/addUserProfile")
                    //.accept(MediaType.APPLICATION_JSON)
                    .type(MediaType.APPLICATION_JSON)
                    .post(ClientResponse.class, mapper.writeValueAsString(req));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        System.out.println("Server response .... \n");
        System.out.println(output);
    }


}