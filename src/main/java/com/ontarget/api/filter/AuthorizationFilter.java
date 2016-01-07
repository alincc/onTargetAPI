package com.ontarget.api.filter;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ontarget.api.repository.FeatureRequestMapperRepository;
import com.ontarget.api.service.AuthorizationService;
import com.ontarget.api.service.UserProfileService;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ApplicationFeature;
import com.ontarget.entities.FeatureRequestMapper;
import org.apache.log4j.Logger;
import org.glassfish.jersey.message.internal.ReaderWriter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.Provider;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@Provider
public class AuthorizationFilter implements ContainerRequestFilter {
    private static final String ADD_PROJECT_PATH = "/project/addProject";
    private static final String DELETE_PROJECT_PATH = "/project/deleteProject";
    private Logger logger = Logger.getLogger(AuthorizationFilter.class);

	@Autowired
	private AuthorizationService authorizationService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    private FeatureRequestMapperRepository featureRequestMapperRepository;


    @Override
	public void filter(ContainerRequestContext request) {
		logger.info("base URI:: " + request.getUriInfo().getBaseUri() + ", path:: " + request.getUriInfo().getPath() + ", http method:: "
				+ request.getMethod());

		String requestPath = new StringBuilder("/").append(request.getUriInfo().getPath()).toString();

		String openEndpointArr[] = OnTargetConstant.OPEN_RS_ENDPOINT.split(",");
		logger.info("open end points: " + OnTargetConstant.OPEN_RS_ENDPOINT);
		for (String openEndpoint : openEndpointArr) {
			if (requestPath.startsWith(openEndpoint)) {
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

            ObjectMapper mapper = new ObjectMapper();

            JsonNode actualObj = mapper.readTree(jsonPost);

            JsonNode baseRequestObj = actualObj.get("baseRequest");

            JsonNode userObjNode = baseRequestObj.get("loggedInUserId");
            Integer userId = userObjNode.intValue();

            JsonNode projectObjNode = baseRequestObj.get("loggedInUserProjectId");
            Integer projectId = projectObjNode.intValue();

            /**
             * check to see if its a add project and check if this user is super user.
             * we can return from this point if its a add or delete project path.
             */
            try {

                if(requestPath.equals(ADD_PROJECT_PATH) || requestPath.equals(DELETE_PROJECT_PATH)) {
                    boolean allowedToCreateProject = userProfileService.isAllowedToCreateProject(userId);
                    if(!allowedToCreateProject){
                        logger.error("User doesn't have access to request path: "+ requestPath);
                        throw new WebApplicationException(unauthorizedResponse());
                    }
                    logger.debug("Authorized to create project:: user :: "+ userId);
                    request.setEntityStream(new ByteArrayInputStream(requestEntity));
                    return;
                }
            }catch(Exception e){
                logger.error("Error while auth",e);
                throw new WebApplicationException(unauthorizedResponse());
            }

            /**
             * check if this user has access to project
             */
			String authorized = authenticate(userId, projectId);
			logger.debug("authorized: " + authorized);

			if (authorized.equalsIgnoreCase(OnTargetConstant.ApplicationPermission.UNAUTHORIZED)) {
				throw new WebApplicationException(unauthorizedResponse());
			}

            /**
             * check if the request path operation is allowed
             */

            String authorizedApiRequest = requestApiAuthorized(userId, projectId, requestPath);
            logger.debug("authorizedApiRequest: " + authorizedApiRequest);

            if (authorizedApiRequest.equalsIgnoreCase(OnTargetConstant.ApplicationPermission.UNAUTHORIZED)) {
                throw new WebApplicationException(unauthorizedResponse());
            }



			request.setEntityStream(new ByteArrayInputStream(requestEntity));
			return;

		} catch (IOException ex) {
			logger.error("Error while auth: ",ex);
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

	private String requestApiAuthorized(int userId, int projectId, String requestPath) {
		try {
            logger.debug("Checking feature request mapping permission for path: "+ requestPath);

			List<FeatureRequestMapper> featureRequestMapperList = featureRequestMapperRepository.findByRequestPath(requestPath);

			logger.debug("feature request mapper: " + featureRequestMapperList);

			if (featureRequestMapperList != null && featureRequestMapperList.size() > 0) {
				FeatureRequestMapper featureRequestMapper = featureRequestMapperList.get(0);
				logger.debug("has feature: " + featureRequestMapper.getHasFeature());
				if (featureRequestMapper.getHasFeature().equals(new Character('N'))) {
					return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
				} else {
					ApplicationFeature applicationFeature = featureRequestMapperRepository.hasPermissionToUser(userId,featureRequestMapper
							.getApplicationFeature().getApplicationFeatureId(),projectId);
					logger.debug("application feature: " + applicationFeature);
					if (applicationFeature == null) {
						return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
					}
				}
			}
			return OnTargetConstant.ApplicationPermission.AUTHORIZED;


		} catch (Exception e) {
			logger.error("System error", e);
		}
        return OnTargetConstant.ApplicationPermission.UNAUTHORIZED;
	}

	private String authenticate(int userId, int projectId) {
		try {
            logger.debug("Validating user:: "+ userId+" with project: "+projectId);
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