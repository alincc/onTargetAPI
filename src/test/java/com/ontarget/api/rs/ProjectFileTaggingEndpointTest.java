package com.ontarget.api.rs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.junit.Test;

import com.ontarget.bean.ProjectFileTagAttributeBean;
import com.ontarget.bean.ProjectFileTagBean;
import com.ontarget.request.bean.AddProjectFileTagRequest;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.GetProjectFileTagRequest;

public class ProjectFileTaggingEndpointTest extends BaseTest {

	@Test
	public void addTag() {
		AddProjectFileTagRequest request = new AddProjectFileTagRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(44);

		request.setBaseRequest(baseRequestBean);

		List<ProjectFileTagBean> tags = new ArrayList<ProjectFileTagBean>();
		ProjectFileTagBean tagBean = new ProjectFileTagBean();
		tagBean.setTag("BIM not correct");
		tagBean.setTitle("BIM not correct");
		tagBean.setTagType("BIM not correct");
		tagBean.setLattitude(10.01f);
		tagBean.setLongitude(10.00f);
		tagBean.setProjectFileId(13);

		List<ProjectFileTagAttributeBean> attributes = new ArrayList<ProjectFileTagAttributeBean>();
		ProjectFileTagAttributeBean attribute = new ProjectFileTagAttributeBean();
		attribute.setKey("key1");
		attribute.setValue("value1");
		attributes.add(attribute);

		tagBean.setAttributes(attributes);
		tags.add(tagBean);

		request.setTags(tags);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/projectFile/addTag", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

	@Test
	public void getProjectFileTags() {
		GetProjectFileTagRequest request = new GetProjectFileTagRequest();

		BaseRequest baseRequestBean = new BaseRequest();
		baseRequestBean.setLoggedInUserId(11);
		baseRequestBean.setLoggedInUserProjectId(44);

		request.setBaseRequest(baseRequestBean);
		request.setProjectFileId(13);

		System.out.println("Client request .... \n");
		System.out.println(toJsonString(request, true));
		Response response = sendRequest("/projectFile/getProjectFileTags", request);
		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.readEntity(String.class);
		System.out.println("Server response .... \n");
		System.out.println(output);
	}

}
