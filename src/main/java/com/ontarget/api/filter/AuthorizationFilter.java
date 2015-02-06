package com.ontarget.api.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.ontarget.api.service.AuthorizationService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.BaseRequest;
import com.sun.jersey.core.util.ReaderWriter;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Component
public class AuthorizationFilter implements ContainerRequestFilter {
	private Logger logger = Logger.getLogger(AuthorizationFilter.class);

	@Autowired
	private AuthorizationService authorizationService;

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		logger.info("Container request filter called:::");
		logger.info("base URI:: " + request.getBaseUri());
		logger.info(request.getMethod());

		System.out.println("base URI:: " + request.getBaseUri());
		System.out.println("Method:: " + request.getMethod());
		System.out.println("Path:: " + request.getPath());
		System.out.println("Absolute path:: " + request.getAbsolutePath());

		String path = request.getPath();

		logger.info("path:: " + path);
		if (openRestEndPointList().contains(path)) {
			return request;
		}
		System.out.println("Here");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = request.getEntityInputStream();
		final StringBuilder b = new StringBuilder();
		try {
			if (in.available() > 0) {
				ReaderWriter.writeTo(in, out);

				byte[] requestEntity = out.toByteArray();
				String jsonPost = getJsonPostObj(b, requestEntity);

				if (jsonPost == null || jsonPost.trim().length() == 0) {
					logger.error("Empty json request");
					throw new WebApplicationException(unauthorizedResponse());
				}

				if (authenticate(jsonPost)) {
					request.setEntityInputStream(new ByteArrayInputStream(
							requestEntity));
					return request;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new WebApplicationException(unauthorizedResponse());
		}

		throw new WebApplicationException(unauthorizedResponse());

	}

	private List<String> openRestEndPointList() {
		String endpointArr[] = OnTargetConstant.OPEN_RS_ENDPOINT.split(",");

		List<String> opendEndPoints = new ArrayList<String>();
		for (String endpoint : endpointArr) {
			opendEndPoints.add(endpoint);
		}
		System.out.println("open end points:: " + opendEndPoints);
		return opendEndPoints;
	}

	private Response unauthorizedResponse() {
		ResponseBuilder builder = null;
		// http response code: 401(Unauthorized)
		builder = Response.status(Response.Status.UNAUTHORIZED).entity(
				"User is not authorized!");
		return builder.build();
	}

	private String getJsonPostObj(StringBuilder b, byte[] entity)
			throws IOException {
		if (entity.length == 0)
			return "";
		b.append(new String(entity)).append("\n");
		System.out.println("#### Intercepted Entity ####");
		return b.toString();
	}

	private boolean authenticate(String jsonPost) {
		try {
			logger.info("json post:: " + jsonPost);
			System.out.println("json post string:: " + jsonPost);

			Gson gson = new Gson();
			BaseRequest baseRequest = gson
					.fromJson(jsonPost, BaseRequest.class);

			Integer userId = baseRequest.getUser().getUserId();
			System.out.println("User ID:: " + userId);
			Integer projectId = baseRequest.getParentProjectId();
			System.out.println("Project id:: " + projectId);

			boolean authorized = authorizationService.validateUserOnProject(
					userId, projectId);
			logger.info("Authorized:: " + authorized);
			System.out.println("Authorized:: " + authorized);
			if (authorized) {
				return true;
			}
		} catch (JSONException e) {
			e.printStackTrace();
			logger.error("Json data invalid");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("System error");
		}
		return false;
	}
}