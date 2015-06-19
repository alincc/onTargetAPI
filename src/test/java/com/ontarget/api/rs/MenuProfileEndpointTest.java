package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.bean.ProfileInfoRequest;
import com.ontarget.request.bean.AddMenuProfileRequest;
import com.ontarget.request.bean.EditMenuProfileRequest;

public class MenuProfileEndpointTest extends BaseTest {

	@Test
	public void add() {
		AddMenuProfileRequest request = new AddMenuProfileRequest();
		request.setName("profile1");
		request.setDescription("profile1 desc");
		request.setUserId(1);	

		List<Integer> assignedMenuList = new ArrayList<>();
		assignedMenuList.add(1);
		assignedMenuList.add(2);

		request.setAssignedMenuList(assignedMenuList);

		System.out.println("Client request ...(/menuProfile/add) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/menuProfile/add", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/menuProfile/add) \n");
		System.out.println(output);
	}

	@Test
	public void edit() {
		EditMenuProfileRequest request = new EditMenuProfileRequest();
		request.setName("profile1");
		request.setDescription("profile1 desc");
		request.setUserId(1);
		request.setActive("N");
		request.setProfileId(1);

		List<Integer> assignedMenuList = new ArrayList<>();
		assignedMenuList.add(1);
		assignedMenuList.add(2);

		request.setAssignedMenuList(assignedMenuList);

		System.out.println("Client request ...(/menuProfile/edit) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/menuProfile/edit", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/menuProfile/edit) \n");
		System.out.println(output);
	}

	@Test
	public void getApplicationMenuList() {

		System.out.println("Client request ....(/menuProfile/getApplicationMenuList) \n");
		Response response = getRequest("/menuProfile/getApplicationMenuList");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/menuProfile/getApplicationMenuList) \n");
		System.out.println(output);
	}

	@Test
	public void getMenuProfileList() {

		System.out.println("Client request ....(/menuProfile/getMenuProfileList) \n");
		Response response = getRequest("/menuProfile/getMenuProfileList");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/menuProfile/getMenuProfileList) \n");
		System.out.println(output);
	}

	@Test
	public void getMenuProfileInfo() {
		ProfileInfoRequest request = new ProfileInfoRequest();
		request.setProfileId(3);

		System.out.println("Client request ...(/menuProfile/getMenuProfileInfo) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/menuProfile/getMenuProfileInfo", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/menuProfile/getMenuProfileInfo) \n");
		System.out.println(output);
	}

}
