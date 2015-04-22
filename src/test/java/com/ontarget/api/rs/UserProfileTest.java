package com.ontarget.api.rs;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.bean.UserAddressInfo;
import com.ontarget.dto.ChangeUserPasswordRequest;
import com.ontarget.dto.ForgotPasswordRequest;
import com.ontarget.dto.UserImageRequest;
import com.ontarget.dto.UserProfileRequest;
import com.ontarget.request.bean.CompanyEditInfo;
import com.ontarget.request.bean.CompanyInfoEditRequest;
import com.ontarget.request.bean.UpdateUserProfileRequest;
import com.ontarget.request.bean.UserCompanyInfo;
import com.ontarget.request.bean.UserContactInfo;
import com.ontarget.request.bean.UserInfo;

/**
 * Created by Owner on 11/5/14.
 */

public class UserProfileTest extends BaseTest {

	@Test
	public void testAddUserProfile() {

		UserContactInfo contact = new UserContactInfo();
		contact.setTitle("Project Manager");
		contact.setFirstName("firstname");
		contact.setLastName("lastname");
		contact.setUserImagePath("");

		UserCompanyInfo comp = new UserCompanyInfo();
		comp.setCompanyName("The TTG Inc.");
		comp.setCompanyTypeId(1);
		comp.setWebsite("http://www.comp.com");

		UserAddressInfo address = new UserAddressInfo();
		address.setAddress1("4750 59th street");
		address.setAddress2("Apt #9C");
		address.setCity("Woodside");
		address.setState("NY");
		address.setZip("11377");
		address.setCountry("USA");
		address.setAddressType("COMPANY");
		comp.setAddress(address);

		UserInfo user = new UserInfo();
		user.setUserId(9);
		user.setAccountStatus("NEW");

		UserProfileRequest request = new UserProfileRequest();
		request.setCompany(comp);
		request.setUser(user);
		request.setContact(contact);

		System.out.println("Client request ...(/profile/addUserProfile) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/profile/addUserProfile", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/addUserProfile) \n");
		System.out.println(output);
	}

	@Test
	public void updateUserProfile() {

		UserContactInfo contact = new UserContactInfo();
		contact.setTitle("Project Manager");
		contact.setFirstName("firstname");
		contact.setLastName("lastname");
		contact.setUserImagePath("");

		UserInfo user = new UserInfo();
		user.setUserId(1);

		UpdateUserProfileRequest request = new UpdateUserProfileRequest();
		request.setUser(user);
		request.setContact(contact);

		System.out.println("Client request ....(/profile/updateUserProfile) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/profile/updateUserProfile", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/updateUserProfile) \n");
		System.out.println(output);
	}

	@Test
	public void updateCompanyInfo() {

		CompanyInfoEditRequest request = new CompanyInfoEditRequest();

		CompanyEditInfo company = new CompanyEditInfo();
		company.setCompanyId(1);
		company.setCompanyName("SIMON AND BARRON WEA RESIDENTIAL");
		company.setCompanyTypeId(1);

		UserAddressInfo address = new UserAddressInfo();
		address.setAddress1("363 23rd st");
		address.setAddress2("Suite 2098");
		address.setCity("New York");
		address.setCountry("USA");
		address.setState("NY");
		address.setZip("10001");

		company.setAddress(address);

		request.setCompany(company);

		System.out.println("Client request ....(/profile/updateCompanyInfo) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/profile/updateCompanyInfo", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/updateUserProfile) \n");
		System.out.println(output);
	}

	@Test
	public void forgotPasswordRequest() {

		ForgotPasswordRequest request = new ForgotPasswordRequest();
		request.setEmailAddress("sanjeev@ontargetcloud.com");

		System.out.println("Client request ....(/profile/forgotPasswordRequest) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/profile/forgotPasswordRequest", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ...(/profile/forgotPasswordRequest) \n");
		System.out.println(output);
	}

	@Test
	public void changeForgotPassword() {

		ForgotPasswordRequest request = new ForgotPasswordRequest();
		request.setEmailAddress("sanjeev@ontargetcloud.com");
		request.setForgotPasswordToken("token");
		request.setNewPassword("123456");

		System.out.println("Client request ....(/profile/changeForgotPassword) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/profile/changeForgotPassword", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/changeForgotPassword) \n");
		System.out.println(output);
	}

	@Test
	public void changeUserPassword() {

		ChangeUserPasswordRequest request = new ChangeUserPasswordRequest();
		request.setUserId(1);
		request.setCurrentPassword("123456");
		request.setNewPassword("123456");

		System.out.println("Client request ....(/profile/changeUserPassword) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/profile/changeUserPassword", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/changeUserPassword) \n");
		System.out.println(output);
	}

	@Test
	public void getSafetyInfoForUser() {

		System.out.println("Client request ....(/profile/getSafetyInfoForUser?userId=1) \n");
		Response response = getRequest("/profile/getSafetyInfoForUser?userId=1");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/getSafetyInfoForUser?userId=1) \n");
		System.out.println(output);
	}

	@Test
	public void saveUserProfileImage() {

		UserImageRequest request = new UserImageRequest();
		request.setImagePath("");
		request.setModifyingUser(1);
		request.setUserId(1);

		System.out.println("Client request ....(/profile/saveUserProfileImage) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/profile/saveUserProfileImage", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/saveUserProfileImage) \n");
		System.out.println(output);
	}

	@Test
	public void validateForgotPasswordToken() {

		System.out.println("Client request ....(/profile/validateForgotPassword/token) \n");
		Response response = getRequest("/profile/validateForgotPassword/token");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/profile/validateForgotPassword/token) \n");
		System.out.println(output);
	}

}
