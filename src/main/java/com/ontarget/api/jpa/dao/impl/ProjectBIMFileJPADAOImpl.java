package com.ontarget.api.jpa.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ontarget.api.dao.ProjectBIMFileDAO;
import com.ontarget.api.repository.ProjectBIMFileRepository;
import com.ontarget.api.repository.ProjectBimFileCommentRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.ProjectBimFileComment;
import com.ontarget.entities.ProjectFileComment;
import com.ontarget.entities.User;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Repository("projectBIMFileJPADAOImpl")
public class ProjectBIMFileJPADAOImpl implements ProjectBIMFileDAO {

	private Logger logger = Logger.getLogger(ProjectBIMFileJPADAOImpl.class);

	@Resource
	private ProjectBIMFileRepository projectBIMFileRepository;
	@Resource
	private ProjectBimFileCommentRepository projectBimFileCommentRepository;

	@Override
	public List<ProjectBimFile> getBIMProjects(Long projectId) throws Exception {
		logger.debug("Getting bim projectes for project: " + projectId);
		return projectBIMFileRepository.findByProjectId(projectId.intValue());
	}

    @Override
    public ProjectBimFile getBIMProject(int projectBimFileId) throws Exception {
        logger.debug("Getting bim project: " + projectBimFileId);
        return projectBIMFileRepository.findOne(projectBimFileId);
    }

	@Override
	public ProjectBimFile saveBIMProject(ProjectBimFile projectBimFile) throws Exception {
		logger.debug("Saving bim file information: " + projectBimFile);
		ProjectBimFile file = projectBIMFileRepository.save(projectBimFile);
		return file;
	}

	@Override
	public boolean deleteBIMProject(Integer projectBimFileId, Integer userId) throws Exception {
		logger.debug("Deleting bim file information: " + projectBimFileId);
		ProjectBimFile bimFile = projectBIMFileRepository.findOne(projectBimFileId);
		bimFile.setStatus(OnTargetConstant.GenericStatus.DELETED);
		bimFile.setModifiedBy(new User(userId));
		bimFile.setModifiedDate(new Date());
		ProjectBimFile file = projectBIMFileRepository.save(bimFile);
		return file.getStatus().equals(OnTargetConstant.GenericStatus.DELETED);
	}

	@Override
	public boolean updateThumbnailPath(Integer projectBimFileId, String thumbnailPath, Integer userId) throws Exception {
		logger.debug("updating bim thumbnail file path information: " + projectBimFileId);
		ProjectBimFile bimFile = projectBIMFileRepository.findOne(projectBimFileId);
		bimFile.setBimThumbnailFileLocation(thumbnailPath);
		bimFile.setModifiedBy(new User(userId));
		bimFile.setModifiedDate(new Date());
		ProjectBimFile file = projectBIMFileRepository.save(bimFile);
		return file.getBimThumbnailFileLocation().equals(thumbnailPath);
	}

	@Override
	public ProjectBimFileComment saveComment(ProjectBimFileComment comment) throws Exception {
		logger.debug("Saving bim file comment information: " + comment);
		ProjectBimFileComment file = projectBimFileCommentRepository.save(comment);
		return file;
	}

	@Override
	public boolean deleteComment(Integer commentId) throws Exception {
		ProjectBimFileComment projectFileComment = projectBimFileCommentRepository.findOne(commentId);
		projectFileComment.setCommentStatus(OnTargetConstant.ProjectFileCommentStatus.DELETED);
		projectBimFileCommentRepository.save(projectFileComment);
		return true;
	}
	
	@Override
	public List<ProjectBimFileComment> getCommentsByFileId(int projectBimFileId) {
		return projectBimFileCommentRepository.findCommentsByFileId(projectBimFileId);
	}

}
