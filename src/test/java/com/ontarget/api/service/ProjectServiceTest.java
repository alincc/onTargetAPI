package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.Project;
import com.ontarget.dto.ProjectListResponse;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 11/13/14.
 */
public class ProjectServiceTest extends BaseTest{

    private Logger logger = Logger.getLogger(AuthenticationServiceTest.class);

    @Autowired
    private ProjectService projectService;


    @Test
    public void testGetProjectsByCompany(){


        try {
            ProjectListResponse response = projectService.getProjectsByCompany(1,1);
            Assert.assertTrue(response.getProjects().size() > 0);

            Project project = response.getProjects().get(0);

            Assert.assertTrue(project!=null && project.getProjects().size() > 0);

        } catch (Exception e) {
            logger.error("Error while getting project by company",e);
            fail();
        }

    }


}
