package com.ontarget.api.rs.impl;

import com.ontarget.api.rs.ProjectBIMFileEndpoint;
import com.ontarget.api.service.ProjectBIMFileService;
import com.ontarget.bean.ProjectBIMFileCommentDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.dto.OnTargetResponse;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.GetBIMResponse;
import com.ontarget.response.bean.ProjectBIMFileCommentListResponse;
import com.ontarget.response.bean.ProjectBimFileCommentResponse;
import com.ontarget.response.bean.SaveBIMResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Component
@Path("/bim")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProjectBIMFileEndpointImpl implements ProjectBIMFileEndpoint {

	private Logger logger = Logger.getLogger(ProjectBIMFileEndpointImpl.class);

	@Autowired
	private ProjectBIMFileService projectBIMFileService;

	@Override
	@POST
	@Path("/getAll")
	public GetBIMResponse getBIMProject(GetBIMRequest request) {
		logger.debug("Getting BIM projects for project: " + request.getProjectId());
		GetBIMResponse response = null;
		try {
			response = projectBIMFileService.getBIMProjects(request.getProjectId());
		} catch (Exception e) {
			logger.error("Error while getting poids: ", e);
			response = new GetBIMResponse();
			response.setReturnVal("false");
			response.setReturnMessage("Error while fetching BIM files.");
		}
		return response;
	}

	@Override
	@POST
	@Path("/save")
	public SaveBIMResponse saveBIMProject(SaveBIMRequest request) {
		logger.debug("Saving BIM projects for project: " + request.getProjectid());
		SaveBIMResponse response = new SaveBIMResponse();
		try {
			ProjectBimFile projectBimFile = projectBIMFileService.saveProjectBIMFile(request);
			if (projectBimFile.getProjectBimFileId() > 0) {
				response.setReturnVal("true");
				response.setReturnMessage("Successfully saved bim poid.");
                response.setProjectBimFile(projectBimFile);
			}
		} catch (Exception e) {
			logger.error("Error while saving bim poid: ", e);
			response.setReturnVal("false");
			response.setReturnMessage("Error while saving BIM files.");

		}
		return response;
	}

	@Override
	@POST
	@Path("/delete")
	public SaveBIMResponse deleteBIMProject(DeleteBIMRequest request) {
		logger.debug("Saving BIM projects for project bim file id: " + request.getProjectBimFileId());
		SaveBIMResponse response = new SaveBIMResponse();
		try {
			Boolean saved = projectBIMFileService.deleteProjectBIMFile(request);
			if (saved) {
				response.setReturnVal("true");
				response.setReturnMessage("Successfully deleted bim poid.");
			}
		} catch (Exception e) {
			logger.error("Error while deleted bim poid: ", e);
			response.setReturnVal("false");
			response.setReturnMessage("Error while deleted BIM files.");

		}
		return response;
	}

	@Override
	@POST
	@Path("/updateThumbnailPath")
	public SaveBIMResponse updateProjectBIMThumbnailPath(UpdateBIMThumbnailPathRequest request) {
		logger.debug("updating thumbnail path for  project bim file id: " + request.getProjectBimFileId());
		SaveBIMResponse response = new SaveBIMResponse();
		try {
			Boolean saved = projectBIMFileService.updateBimThumbnailPath(request);
			if (saved) {
				response.setReturnVal("true");
				response.setReturnMessage("Successfully updated thumbnail");
			}
		} catch (Exception e) {
			logger.error("Error while updating thumbnail path for  bim : ", e);
			response.setReturnVal("false");
			response.setReturnMessage("Error while updating thumbnail path for BIM");

		}
		return response;
	}

	@Override
	@POST
	@Path("/comment/save")
	public ProjectBimFileCommentResponse addUpdateComment(ProjectBIMFileCommentRequest request) {
        ProjectBimFileCommentResponse response = new ProjectBimFileCommentResponse();
		try {
			ProjectBIMFileCommentDTO projectBIMFileCommentDTO = projectBIMFileService.addUpdateComment(request);
			if (projectBIMFileCommentDTO.getProjectBIMFileCommentId() > 0) {
                response.setProjectBIMFileComment(projectBIMFileCommentDTO);
				response.setReturnVal(OnTargetConstant.SUCCESS);
				if (request.getCommentId() != null) {
					response.setReturnMessage("Comment updated successfully");
				} else {
					response.setReturnMessage("Comment added successfully");
				}
			} else {
				response.setReturnVal(OnTargetConstant.ERROR);
				if (request.getCommentId() != null) {
					response.setReturnMessage("Add comment request failed");
				} else {
					response.setReturnMessage("Update comment request failed");
				}
			}
		} catch (Exception e) {
			logger.error("Add/Update BIM file comment failed." + e);
			response.setReturnMessage("Add/Update BIM file comment failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/comment/delete")
	public OnTargetResponse deleteComment(ProjectFileCommentDeleteRequest request) {
		OnTargetResponse response = new OnTargetResponse();
		try {
			if (projectBIMFileService.deleteComment(request.getCommentId())) {
				response.setReturnMessage("Comment deleted successfully");
				response.setReturnVal(OnTargetConstant.SUCCESS);
			} else {
				response.setReturnMessage("Delete comment failed");
				response.setReturnVal(OnTargetConstant.ERROR);
			}
		} catch (Exception e) {
			logger.error("Delete comment failed." + e);
			response.setReturnMessage("Delete comment failed");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

	@Override
	@POST
	@Path("/comment/list")
	public ProjectBIMFileCommentListResponse commentList(ProjectBIMFileCommentListRequest request) {
		ProjectBIMFileCommentListResponse response = new ProjectBIMFileCommentListResponse();
		try {
			List<ProjectBIMFileCommentDTO> commentList = projectBIMFileService.getCommentList(request.getProjectBIMFileId());
			response.setComments(commentList);
			response.setReturnVal(OnTargetConstant.SUCCESS);
			response.setReturnMessage("Successfully retrieved comments for project bim file.");
		} catch (Exception e) {
			logger.error("Error while retrieving project bim file comment list." + e);
			response.setReturnMessage("Error while retrieving project bim file comment list.");
			response.setReturnVal(OnTargetConstant.ERROR);
		}
		return response;
	}

}
