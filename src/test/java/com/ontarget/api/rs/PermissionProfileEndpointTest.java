package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.bean.ProfileInfoRequest;
import com.ontarget.request.bean.AddPermissionProfileRequest;
import com.ontarget.request.bean.EditPermissionProfileRequest;

public class PermissionProfileEndpointTest extends BaseTest {

	@Test
	public void add() {
		AddPermissionProfileRequest request = new AddPermissionProfileRequest();
		request.setName("profile1");
		request.setDescription("profile1 desc");
		request.setUserId(1);

		List<Integer> assignedPermissionList = new ArrayList<>();
		assignedPermissionList.add(1);
		assignedPermissionList.add(2);

		request.setAssignedPermissionList(assignedPermissionList);

		System.out.println("Client request ...(/permissionProfile/add) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/permissionProfile/add", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/permissionProfile/add) \n");
		System.out.println(output);
	}

	@Test
	public void edit() {
		EditPermissionProfileRequest request = new EditPermissionProfileRequest();
		request.setName("profile1");
		request.setDescription("profile1 desc");
		request.setUserId(1);
		request.setActive("Y");
		request.setProfileId(1);

		List<Integer> assignedPermissionList = new ArrayList<>();
		assignedPermissionList.add(1);
		assignedPermissionList.add(2);

		request.setAssignedPermissionList(assignedPermissionList);

		System.out.println("Client request ...(/permissionProfile/edit) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/permissionProfile/edit", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/permissionProfile/edit) \n");
		System.out.println(output);
	}

	@Test
	public void getApplicationPermissionList() {

		System.out.println("Client request ....(/permissionProfile/getApplicationPermissionList) \n");
		Response response = getRequest("/permissionProfile/getApplicationPermissionList");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/permissionProfile/getApplicationPermissionList) \n");
		System.out.println(output);
	}

	@Test
	public void getPermissionProfileList() {

		System.out.println("Client request ....(/permissionProfile/getPermissionProfileList) \n");
		Response response = getRequest("/permissionProfile/getPermissionProfileList");
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/permissionProfile/getPermissionProfileList) \n");
		System.out.println(output);
	}

	@Test
	public void getPermissionProfileInfo() {
		ProfileInfoRequest request = new ProfileInfoRequest();
		request.setProfileId(1);

		System.out.println("Client request ...(/permissionProfile/getPermissionProfileInfo) \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/permissionProfile/getPermissionProfileInfo", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response ....(/permissionProfile/getPermissionProfileInfo) \n");
		System.out.println(output);
	}
}
