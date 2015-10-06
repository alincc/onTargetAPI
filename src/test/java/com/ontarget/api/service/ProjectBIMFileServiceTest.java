package com.ontarget.api.service;

import com.ontarget.api.rs.BaseTest;
import com.ontarget.dto.ProjectBimFileDTO;
import com.ontarget.request.bean.BaseRequest;
import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import com.ontarget.request.bean.UpdateBIMThumbnailPathRequest;
import com.ontarget.response.bean.GetBIMResponse;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectBIMFileServiceTest extends BaseTest {

    private Logger logger = Logger.getLogger(ProjectBIMFileServiceTest.class);

    @Autowired
    private ProjectBIMFileService projectBIMFileService;


    @Test
    public void getBIMPoidsTest(){
        try {
            GetBIMResponse response = projectBIMFileService.getBIMPoids(1L);
            Assert.assertTrue(response.getPoids().size() >= 0);
        } catch (Exception e) {
            logger.error("Error while getting BIM poids.",e);
            fail();
        }

    }


    @Test
    public void saveBIMPoidTest(){
        try {
            SaveBIMRequest request = new SaveBIMRequest();
            request.setPoid(1234567L);
            request.setProjectBimFileLocation("/project/abc.jpg");
            request.setProjectid(42L);

            BaseRequest baseRequest=new BaseRequest();
            baseRequest.setLoggedInUserId(10);
            baseRequest.setLoggedInUserProjectId(42);
            request.setBaseRequest(baseRequest);

            boolean saved = projectBIMFileService.saveProjectBIMFile(request);
            Assert.assertTrue(saved);
        } catch (Exception e) {
            logger.error("Error while saving bim poid",e);
            fail();
        }


    }


    @Test
    public void deleteBIMPoidTest() {
        try {

            SaveBIMRequest request = new SaveBIMRequest();
            request.setPoid(1234567L);
            request.setProjectBimFileLocation("/project/abc.jpg");
            request.setProjectid(42L);
            BaseRequest baseRequest=new BaseRequest();
            baseRequest.setLoggedInUserId(10);
            baseRequest.setLoggedInUserProjectId(42);
            request.setBaseRequest(baseRequest);
            boolean saved = projectBIMFileService.saveProjectBIMFile(request);
            Assert.assertTrue(saved);

            //get

            GetBIMResponse response = projectBIMFileService.getBIMPoids(42L);
            ProjectBimFileDTO poid = response.getPoids().get(0);

            //delete
            DeleteBIMRequest requestDel= new DeleteBIMRequest();
            requestDel.setProjectBimFileId(poid.getProjectBimFileId());
            boolean deleted = projectBIMFileService.deleteProjectBIMFile(requestDel);
            Assert.assertTrue(deleted);

        } catch (Exception e) {
            logger.error("Error while deleting bim poid", e);
            fail();
        }
    }


    @Test
    public void updateBIMThumbPath(){
        try {

            SaveBIMRequest request = new SaveBIMRequest();
            request.setPoid(1234567L);
            request.setProjectBimFileLocation("/project/abc.jpg");
            request.setProjectid(42L);
            BaseRequest baseRequest=new BaseRequest();
            baseRequest.setLoggedInUserId(10);
            baseRequest.setLoggedInUserProjectId(42);
            request.setBaseRequest(baseRequest);
            boolean saved = projectBIMFileService.saveProjectBIMFile(request);
            Assert.assertTrue(saved);

            //get

            GetBIMResponse response = projectBIMFileService.getBIMPoids(42L);
            ProjectBimFileDTO poid = response.getPoids().get(0);


            //delete
            UpdateBIMThumbnailPathRequest updateBIMThumbPathrequest=new UpdateBIMThumbnailPathRequest();
            updateBIMThumbPathrequest.setProjectBimFileId(poid.getProjectBimFileId());
            updateBIMThumbPathrequest.setBimThumbnailPath("/project/def.jpg");
            updateBIMThumbPathrequest.setBaseRequest(baseRequest);
            boolean deleted = projectBIMFileService.updateBimThumbnailPath(updateBIMThumbPathrequest);
            Assert.assertTrue(deleted);

        } catch (Exception e) {
            logger.error("Error while saving bim thumb path",e);
            fail();
        }


    }


}
