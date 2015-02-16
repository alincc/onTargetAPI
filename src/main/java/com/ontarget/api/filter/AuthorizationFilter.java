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
import com.ontarget.api.service.AuthorizationService;
import com.ontarget.constant.OnTargetConstant;
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
		logger.info("base URI:: " + request.getBaseUri());
		logger.info(request.getMethod());

		String path = request.getPath();

		logger.info("path:: " + path);

		String openEndpointArr[] = OnTargetConstant.OPEN_RS_ENDPOINT.split(",");
		for (String openEndpoint : openEndpointArr) {
			if (path.startsWith(openEndpoint)) {
				return request;
			}
		}

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
		return b.toString();
	}

	private boolean authenticate(String jsonData) {
		try {
			logger.info("json post:: " + jsonData);

			JSONObject jsonObject = new JSONObject(jsonData);
			JSONObject baseRequestObj = (JSONObject) jsonObject
					.get("baseRequest");

			Integer userId = baseRequestObj.getInt("loggedInUserId");
			logger.info("userId:: " + userId);
			Integer projectId = baseRequestObj.getInt("loggedInUserProjectId");
			logger.info("project id:: " + projectId);

			boolean authorized = authorizationService.validateUserOnProject(
					userId, projectId);
			logger.info("Authorized:: " + authorized);
			if (authorized) {
				return true;
			}
			return false;
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