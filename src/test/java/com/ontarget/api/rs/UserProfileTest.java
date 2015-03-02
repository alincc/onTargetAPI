package com.ontarget.api.rs;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.bean.AddressDTO;
import com.ontarget.bean.Company;
import com.ontarget.bean.Contact;
import com.ontarget.bean.UserDTO;
import com.ontarget.dto.UserProfileRequest;

/**
 * Created by Owner on 11/5/14.
 */

public class UserProfileTest extends BaseTest {

	@Test
	public void testAddUserProfile() {

		Contact contact = new Contact();
		contact.setTitle("Project Manager");
		contact.setFirstName("firstname");
		contact.setLastName("lastname");

		Company comp = new Company();
		comp.setCompanyName("The TTG Inc.");
		comp.setCompanyTypeId(1);
		comp.setEmail("company@company.com");
		comp.setWebsite("http://www.comp.com");

		AddressDTO address = new AddressDTO();
		address.setAddress1("4750 59th street");
		address.setAddress2("Apt #9C");
		address.setCity("Woodside");
		address.setState("NY");
		address.setZip("11377");
		address.setCountry("USA");
		address.setAddressType("COMPANY");
		comp.setAddress(address);

		UserDTO user = new UserDTO();
		user.setUserId(1);

		UserProfileRequest req = new UserProfileRequest();
		req.setCompany(comp);
		req.setUser(user);
		req.setContact(contact);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(req, true));
		Response response = sendRequest("/profile/addUserProfile", req);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void forgotPasswordRequestTest() throws IOException {

		String emailAddress = "sanjeev@ontargetcloud.com";

		System.out.println("Client request .... \n");
		System.out.println(emailAddress);
		Response response = sendRequest("/profile/forgotPasswordRequest",
				emailAddress);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
