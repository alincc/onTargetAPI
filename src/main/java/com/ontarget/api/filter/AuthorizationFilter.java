package com.ontarget.api.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.repository.PermissionMappedRequestRepository;
import com.ontarget.api.service.AuthorizationService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ApplicationPermission;
import com.ontarget.entities.PermissionMappedRequest;

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {
	private Logger logger = Logger.getLogger(AuthorizationFilter.class);

	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private PermissionMappedRequestRepository permissionMappedRequestRepository;

	@Override
	public void filter(ContainerRequestContext request) {
		logger.info("base URI:: " + request.getUriInfo().getBaseUri() + ", path:: " + request.getUriInfo().getPath() + ", http method:: "
				+ request.getMethod());

		String requestPath = request.getUriInfo().getPath();

		String openEndpointArr[] = OnTargetConstant.OPEN_RS_ENDPOINT.split(",");
		logger.info("open end points: " + OnTargetConstant.OPEN_RS_ENDPOINT);
		for (String openEndpoint : openEndpointArr) {
			if (request.getUriInfo().getPath().startsWith(openEndpoint)) {
				return;
			}
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		InputStream in = request.getEntityStream();
		final StringBuilder b = new StringBuilder();
		try {
			ReaderWriter.writeTo(in, out);

			byte[] requestEntity = out.toByteArray();
			String jsonPost = getJsonPostObj(b, requestEntity);

			logger.info("request parameters:: " + jsonPost);

			if (jsonPost == null || jsonPost.trim().length() == 0) {
				logger.error("Empty json request");
				throw new WebApplicationException(unauthorizedResponse());
			}

			String authorizedApiRequest = requestApiAuthorized(jsonPost, requestPath);
			logger.debug("authorizedApiRequest: " + authorizedApiRequest);

			if (authorizedApiRequest.equalsIgnoreCase("UNAUTHORIZED")) {

				throw new WebApplicationException(unauthorizedResponse());

			}

			String authorized = authenticate(jsonPost, requestPath);
			logger.debug("authorized: " + authorized);

			if (authorized.equalsIgnoreCase("UNAUTHORIZED")) {
				throw new WebApplicationException(unauthorizedResponse());
			}

			request.setEntityStream(new ByteArrayInputStream(requestEntity));
			return;

		} catch (IOException ex) {
			ex.printStackTrace();
			throw new WebApplicationException(unauthorizedResponse());
		}
	}

	private Response unauthorizedResponse() {
		ResponseBuilder builder = Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access the resource.");
		return builder.build();
	}

	private String getJsonPostObj(StringBuilder b, byte[] entity) throws IOException {
		if (entity.length == 0)
			return "";
		b.append(new String(entity)).append("\n");
		return b.toString();
	}

	private String requestApiAuthorized(String jsonData, String requestPath) {
		try {

			ObjectMapper mapper = new ObjectMapper();

			JsonNode actualObj = mapper.readTree(jsonData);

			JsonNode baseRequestObj = actualObj.get("baseRequest");

			JsonNode userObjNode = baseRequestObj.get("loggedInUserId");
			Integer userId = userObjNode.getIntValue();

			PermissionMappedRequest permissionMappedRequest = permissionMappedRequestRepository
					.findPermissionMappedByRequestPath(requestPath);

			logger.debug("permission mapped request: " + permissionMappedRequest);

			if (permissionMappedRequest != null) {
				logger.debug("has permission: " + permissionMappedRequest.getHasPermission());
				if (permissionMappedRequest.getHasPermission().equals(new Character('N'))) {

					return "UNAUTHORIZED";
				} else {
					ApplicationPermission applicationPermission = permissionMappedRequestRepository.hasPermissionToUser(userId,
							permissionMappedRequest.getApplicationPermission().getApplicationPermissionId());
					logger.debug("application permission: " + applicationPermission);
					if (applicationPermission == null) {
						return "UNAUTHORIZED";
					}
				}
			}

			return "AUTHORIZED";

		} catch (Exception e) {
			logger.error("System error", e);
		}
		return "UNAUTHORIZED";
	}

	private String authenticate(String jsonData, String requestPath) {
		try {

			ObjectMapper mapper = new ObjectMapper();

			JsonNode actualObj = mapper.readTree(jsonData);

			JsonNode baseRequestObj = actualObj.get("baseRequest");

			JsonNode userObjNode = baseRequestObj.get("loggedInUserId");
			Integer userId = userObjNode.getIntValue();

			JsonNode projectObjNode = baseRequestObj.get("loggedInUserProjectId");
			Integer projectId = projectObjNode.getIntValue();

			boolean authorized = authorizationService.validateUserOnProject(userId, projectId);

			if (authorized) {
				return "AUTHORIZED";
			}

		} catch (Exception e) {
			logger.error("System error", e);
		}
		return "UNAUTHORIZED";
	}

}