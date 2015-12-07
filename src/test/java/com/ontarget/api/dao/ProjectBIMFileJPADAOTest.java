package com.ontarget.api.dao;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.User;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectBIMFileJPADAOTest extends BaseTest{

    private Logger logger = Logger.getLogger(ProjectBIMFileJPADAOTest.class);

    @Autowired
    @Qualifier("projectBIMFileJPADAOImpl")
    private ProjectBIMFileDAO projectBIMFileDAO;


    @Test
    public void getBIMPoidsTest(){
        try {
            List<ProjectBimFile> poids = projectBIMFileDAO.getBIMProjects(1L);
            Assert.assertTrue(poids.size() >= 0);
        } catch (Exception e) {
            logger.error("Error while fetching bim poids",e);
            fail();
        }


    }

    @Test
    public void saveBIMPoidTest(){
        try {
            ProjectBimFile projectBimFile = new ProjectBimFile();
            Project p =new Project();
            p.setProjectId(42);
            projectBimFile.setProject(p);
            projectBimFile.setBimThumbnailFileLocation("/project/abc.jpg");
            projectBimFile.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
            projectBimFile.setCreatedDate(new Date());
            projectBimFile.setCreatedBy(new User(10));
            projectBimFile.setBimIfcJsonFilePath("/project/bimfile.json");
            projectBimFile.setBimIfcFilePath("/project/bimfile.ifc");


            projectBimFile = projectBIMFileDAO.saveBIMPoid(projectBimFile);
            Assert.assertTrue(projectBimFile.getProjectBimFileId() > 0);
        } catch (Exception e) {
            logger.error("Error while saving bim poid",e);
            fail();
        }


    }


    @Test
    public void deleteBIMPoidTest() {
        try {

            //save
            ProjectBimFile projectBimFile = new ProjectBimFile();
            Project p = new Project();
            p.setProjectId(42);
            projectBimFile.setProject(p);
            projectBimFile.setBimThumbnailFileLocation("/project/abc.jpg");
            projectBimFile.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
            projectBimFile.setCreatedDate(new Date());
            projectBimFile.setCreatedBy(new User(10));
            projectBimFile.setBimPoid(new BigInteger("1234567"));
            projectBimFile.setBimIfcJsonFilePath("/project/bimfile.json");
            projectBimFile.setBimIfcFilePath("/project/bimfile.ifc");


            projectBimFile = projectBIMFileDAO.saveBIMPoid(projectBimFile);
            Assert.assertTrue(projectBimFile.getProjectBimFileId() > 0);

            //get

            List<ProjectBimFile> poids = projectBIMFileDAO.getBIMProjects(42L);
            ProjectBimFile poid = poids.get(0);

            //delete
            boolean deleted = projectBIMFileDAO.deleteBIMPoid(poid.getProjectBimFileId(),10);
            Assert.assertTrue(deleted);

        } catch (Exception e) {
            logger.error("Error while deleting bim poid", e);
            fail();
        }
    }


        @Test
        public void updateBIMThumbPath(){
            try {

                //save
                ProjectBimFile projectBimFile = new ProjectBimFile();
                Project p =new Project();
                p.setProjectId(42);
                projectBimFile.setProject(p);
                projectBimFile.setBimThumbnailFileLocation("/project/abc.jpg");
                projectBimFile.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
                projectBimFile.setCreatedDate(new Date());
                projectBimFile.setCreatedBy(new User(10));
                projectBimFile.setBimPoid(new BigInteger("1234567"));
                projectBimFile.setBimIfcJsonFilePath("/project/bimfile.json");
                projectBimFile.setBimIfcFilePath("/project/bimfile.ifc");



                projectBimFile = projectBIMFileDAO.saveBIMPoid(projectBimFile);
                Assert.assertTrue(projectBimFile.getProjectBimFileId() > 0);

                //get

                List<ProjectBimFile> poids = projectBIMFileDAO.getBIMProjects(42L);
                ProjectBimFile  poid = poids.get(0);
                poid.setBimThumbnailFileLocation("/project/def.jpg");

                //delete
                boolean deleted = projectBIMFileDAO.updateThumbnailPath(poid.getProjectBimFileId(),poid.getBimThumbnailFileLocation(),10);
                Assert.assertTrue(deleted);

            } catch (Exception e) {
                logger.error("Error while saving bim thumb path",e);
                fail();
            }


    }






}
