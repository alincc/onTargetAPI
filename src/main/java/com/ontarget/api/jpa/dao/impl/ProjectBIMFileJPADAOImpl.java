package com.ontarget.api.jpa.dao.impl;

import com.ontarget.api.dao.ProjectBIMFileDAO;
import com.ontarget.api.repository.ProjectBIMFileRepository;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Repository("projectBIMFileJPADAOImpl")
public class ProjectBIMFileJPADAOImpl implements ProjectBIMFileDAO {

    private Logger logger = Logger.getLogger(ProjectBIMFileJPADAOImpl.class);

    @Resource
    private ProjectBIMFileRepository projectBIMFileRepository;

    @Override
    public List<ProjectBimFile> getBIMPoids(Long projectId) throws Exception {
       logger.debug("Getting bim poids for project: "+projectId);
        return projectBIMFileRepository.findByProjectId(projectId.intValue());
    }



    @Override
    public boolean saveBIMPoid(ProjectBimFile projectBimFile) throws Exception {
        logger.debug("Saving bim file information: "+projectBimFile);
        ProjectBimFile file = projectBIMFileRepository.save(projectBimFile);
        return file.getProjectBimFileId() != 0;
    }

    @Override
    public boolean deleteBIMPoid(Integer projectBimFileId, Integer userId) throws Exception {
        logger.debug("Deleting bim file information: "+projectBimFileId);
        ProjectBimFile bimFile=projectBIMFileRepository.findOne(projectBimFileId);
        bimFile.setStatus(OnTargetConstant.GenericStatus.DELETED);
        bimFile.setModifiedBy(new User(userId));
        bimFile.setModifiedDate(new Date());
        ProjectBimFile file = projectBIMFileRepository.save(bimFile);
        return file.getStatus().equals(OnTargetConstant.GenericStatus.DELETED);
    }


    @Override
    public boolean updateThumbnailPath(Integer projectBimFileId, String thumbnailPath, Integer userId) throws Exception {
        logger.debug("udpating bim thumbnail file path information: "+projectBimFileId);
        ProjectBimFile bimFile=projectBIMFileRepository.findOne(projectBimFileId);
        bimFile.setBimThumbnailFileLocation(thumbnailPath);
        bimFile.setModifiedBy(new User(userId));
        bimFile.setModifiedDate(new Date());
        ProjectBimFile file = projectBIMFileRepository.save(bimFile);
        return file.getBimThumbnailFileLocation().equals(thumbnailPath);
    }


}
