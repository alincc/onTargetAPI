package com.ontarget.api.filter;

<<<<<<< HEAD
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
=======
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontarget.api.repository.FeatureRequestMapperRepository;
import com.ontarget.api.service.AuthorizationService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ApplicationFeature;
import com.ontarget.entities.FeatureRequestMapper;
import org.apache.log4j.Logger;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> ontarget.phase4

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;
<<<<<<< HEAD

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.ontarget.api.repository.FeatureRequestMapperRepository;
import com.ontarget.api.service.AuthorizationService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ApplicationFeature;
import com.ontarget.entities.FeatureRequestMapper;
=======
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
>>>>>>> ontarget.phase4

@Provider
public class AuthorizationFilter implements ContainerRequestFilter {
	private Logger logger = Logger.getLogger(AuthorizationFilter.class);

	@Autowired
	private AuthorizationService authorizationService;
	@Autowired
	private FeatureRequestMapperRepository featureRequestMapperRepository;

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

			if (authorizedApiRequest.equalsIgnoreCase(OnTargetConstant.ApplicationPermission.UNAUTHORIZED)) {
				throw new WebApplicationException(unauthorizedResponse());
			}

			String authorized = authenticate(jsonPost, requestPath);
			logger.debug("authorized: " + authorized);

			if (authorized.equalsIgnoreCase(OnTargetConstant.ApplicationPermission.UNAUTHORIZED)) {
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
			Integer userId = userObjNode.intValue();

<<<<<<< HEAD
			logger.debug("Checking feature request mapping permission for path: " + requestPath);
=======
            logger.debug("Checking feature request mapping permission for path: "+ requestPath);
>>>>>>> ontarget.phase4

			List<FeatureRequestMapper> featureRequestMapperList = featureRequestMapperRepository.findByRequestPath(requestPath);

			logger.debug("feature request mapper: " + featureRequestMapperList);

			if (featureRequestMapperList != null && featureRequestMapperList.size() > 0) {
				FeatureRequestMapper featureRequestMapper = featureRequestMapperList.get(0);
				logger.debug("has feature: " + featureRequestMapper.getHasFeature());
				if (featureRequestMapper.getHasFeature().equals(new Character('N'))) {
<<<<<<< HEAD
					return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
=======
                    return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
>>>>>>> ontarget.phase4
				} else {
					ApplicationFeature applicationFeature = featureRequestMapperRepository.hasPermissionToUser(userId, featureRequestMapper
							.getApplicationFeature().getApplicationFeatureId());
					logger.debug("application feature: " + applicationFeature);
					if (applicationFeature == null) {
<<<<<<< HEAD
						return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
					}
				}
			}
			return OnTargetConstant.ApplicationPermission.AUTHORIZED;
=======
                        return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
					}
				}
			}else{
                return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
            }

            return OnTargetConstant.ApplicationPermission.AUTHORIZED;
>>>>>>> ontarget.phase4

		} catch (Exception e) {
			logger.error("System error", e);
		}
<<<<<<< HEAD
		return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
=======
        return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
>>>>>>> ontarget.phase4
	}

	private String authenticate(String jsonData, String requestPath) {
		try {

			ObjectMapper mapper = new ObjectMapper();

			JsonNode actualObj = mapper.readTree(jsonData);

			JsonNode baseRequestObj = actualObj.get("baseRequest");

			JsonNode userObjNode = baseRequestObj.get("loggedInUserId");
			Integer userId = userObjNode.intValue();

			JsonNode projectObjNode = baseRequestObj.get("loggedInUserProjectId");
<<<<<<< HEAD
			Integer projectId = projectObjNode.getIntValue();
			logger.debug("Validating user:: " + userId + " with project: " + projectId);
=======
			Integer projectId = projectObjNode.intValue();
            logger.debug("Validating user:: "+ userId+" with project: "+projectId);
>>>>>>> ontarget.phase4
			boolean authorized = authorizationService.validateUserOnProject(userId, projectId);

			if (authorized) {
				return OnTargetConstant.ApplicationPermission.AUTHORIZED;
			}

		} catch (Exception e) {
			logger.error("System error", e);
		}
		return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
	}

}