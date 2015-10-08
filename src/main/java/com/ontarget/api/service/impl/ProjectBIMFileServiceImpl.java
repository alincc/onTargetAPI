package com.ontarget.api.service.impl;

import com.ontarget.api.dao.ContactDAO;
import com.ontarget.api.dao.ProjectBIMFileDAO;
import com.ontarget.api.service.ProjectBIMFileService;
import com.ontarget.bean.Contact;
import com.ontarget.dto.ProjectBimFileDTO;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import com.ontarget.request.bean.UpdateBIMThumbnailPathRequest;
import com.ontarget.response.bean.GetBIMResponse;
import com.ontarget.util.ProjectBimFileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
@Service("projectBIMFileServiceImpl")
public class ProjectBIMFileServiceImpl implements ProjectBIMFileService {

    private Logger logger = Logger.getLogger(ProjectBIMFileServiceImpl.class);

    @Autowired
    @Qualifier("projectBIMFileJPADAOImpl")
    private ProjectBIMFileDAO projectBIMFileDAO;

    @Autowired
    @Qualifier("contactJpaDAOImpl")
    private ContactDAO contactDAO;

    @Override
    public GetBIMResponse getBIMPoids(Long projectId) throws Exception {
        logger.debug("Getting BIM poids :"+projectId);
        List<ProjectBimFile> poids = projectBIMFileDAO.getBIMPoids(projectId);
        GetBIMResponse response = new GetBIMResponse();
        response.setProjectId(projectId);
        List<ProjectBimFileDTO> poidDtos=new LinkedList<>();
        if(poids!=null && poids.size() > 0){
            for(ProjectBimFile projectBimFile : poids){
                ProjectBimFileDTO dto = new ProjectBimFileDTO();
                dto.setProjectBimFileId(projectBimFile.getProjectBimFileId());
                dto.setCreatedDate(projectBimFile.getCreatedDate());
                dto.setPoid(projectBimFile.getBimPoid().longValue());
                Contact c = contactDAO.getContact(projectBimFile.getCreatedBy().getUserId());
                dto.setCreatedByContact(c);
                poidDtos.add(dto);
            }
        }
        response.setPoids(poidDtos);
        return response;
    }

    @Override
    @Transactional
    public boolean saveProjectBIMFile(SaveBIMRequest request) throws Exception {
        logger.debug("Saving project bim file with poid: "+request.getPoid());
        return projectBIMFileDAO.saveBIMPoid(ProjectBimFileUtil.getProjectBimEnitityFromBIMRequest(request));
    }


    @Override
    @Transactional
    public boolean deleteProjectBIMFile(DeleteBIMRequest request) throws Exception {
        logger.debug("deleting project bim file with id: "+request.getProjectBimFileId());
        return projectBIMFileDAO.deleteBIMPoid(request.getProjectBimFileId(),request.getBaseRequest().getLoggedInUserId());
    }

    @Override
    @Transactional
    public boolean updateBimThumbnailPath(UpdateBIMThumbnailPathRequest request) throws Exception {
        logger.debug("updating project bim thumbnail path with id: "+request.getProjectBimFileId());
        return projectBIMFileDAO.updateThumbnailPath(request.getProjectBimFileId(),request.getBimThumbnailPath(),request.getBaseRequest().getLoggedInUserId());
    }


}
