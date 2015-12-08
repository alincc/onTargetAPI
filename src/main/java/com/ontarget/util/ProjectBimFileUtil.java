package com.ontarget.util;

import com.ontarget.api.dao.TaskDAO;
import com.ontarget.bean.Contact;
import com.ontarget.bean.ProjectBIMFileCommentDTO;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.ProjectBimFileComment;
import com.ontarget.entities.User;
import com.ontarget.request.bean.ProjectBIMFileCommentRequest;
import com.ontarget.request.bean.SaveBIMRequest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectBimFileUtil {

	/**
	 * return project bim file entity object based on the request.
	 * 
	 * @param request
	 * @return
	 */
	public static ProjectBimFile getProjectBimEnitityFromBIMRequest(SaveBIMRequest request) {
		ProjectBimFile file = new ProjectBimFile();
		file.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
		Project project = new Project();
		project.setProjectId(new Integer(request.getProjectid().toString()));
		file.setProject(project);
		file.setBimThumbnailFileLocation(request.getProjectBimFileLocation());
		file.setCreatedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		file.setCreatedDate(new Date());
        file.setBimIfcFilePath(request.getProjectBimFileIFCLocation());
        file.setBimIfcJsonFilePath(request.getProjectBimFileJSONLocation());
        file.setIsBimIfcFileConverted(request.getIsIfcFileConversionComplete());

		return file;
	}

	public static ProjectBimFileComment getProjectBimFileCommentEntityFromCommentRequest(ProjectBIMFileCommentRequest request) {
		ProjectBimFileComment comment = new ProjectBimFileComment();
		comment.setProjectBimFileCommentId(request.getCommentId());
		comment.setComment(request.getComment().trim());
		comment.setCommentedBy(new User(request.getBaseRequest().getLoggedInUserId()));
		comment.setCommentedDate(new Date());
		comment.setCommentStatus(OnTargetConstant.GenericStatus.ACTIVE);
		comment.setProjectBimFile(new ProjectBimFile(request.getProjectBIMFileId()));
		return comment;
	}

	public static List<ProjectBIMFileCommentDTO> getBIMFileCommentDTOListFromEntity(List<ProjectBimFileComment> commentList, TaskDAO taskDAO) {
		List<ProjectBIMFileCommentDTO> commentDTOList = new ArrayList<>();

		Map<Integer, Contact> contactMap = new HashMap<>();
		commentList.forEach(comment -> {
			ProjectBIMFileCommentDTO commentDTO = new ProjectBIMFileCommentDTO();
			commentDTO.setProjectBIMFileCommentId(comment.getProjectBimFileCommentId());
			commentDTO.setComment(comment.getComment());
			commentDTO.setCommentedBy(comment.getCommentedBy().getUserId());
			commentDTO.setCommentedDate(new Date());
			int commentedBy = comment.getCommentedBy().getUserId();

			if (contactMap.containsKey(commentedBy)) {
				commentDTO.setCommenterContact(contactMap.get(commentedBy));
			} else {
				try {
					Contact contact = taskDAO.getContact(commentedBy);
					contactMap.put(commentedBy, contact);
					commentDTO.setCommenterContact(contact);
				} catch (Exception e) {
				}
			}
			commentDTOList.add(commentDTO);
		});
		return commentDTOList;
	}

    /**
     *
     * @param comment
     * @return
     */
    public static ProjectBIMFileCommentDTO getBIMFileCommentDTOFromEntity(ProjectBimFileComment comment) {
        ProjectBIMFileCommentDTO commentDTO = new ProjectBIMFileCommentDTO();
        commentDTO.setProjectBIMFileCommentId(comment.getProjectBimFileCommentId());
        commentDTO.setComment(comment.getComment());
        commentDTO.setCommentedBy(comment.getCommentedBy().getUserId());
        commentDTO.setCommentedDate(new Date());
        int commentedBy = comment.getCommentedBy().getUserId();
        commentDTO.setCommentedBy(commentedBy);
        return commentDTO;
    }



}
