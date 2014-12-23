package com.ontarget.api.service;

import com.ontarget.api.BaseTest;
import com.ontarget.bean.ProjectEarnedValueAnalysisReport;
import com.ontarget.bean.TaskInterval;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static junit.framework.Assert.fail;

/**
 * Created by Owner on 12/23/14.
 */
public class ProjectReportServiceTest extends BaseTest {

    private Logger logger = Logger.getLogger(ProjectReportServiceTest.class);

    @Autowired
    private ProjectReportService projectReportService;


    @Test
    public void getEarnedValueAnalysisReportTest(){

        try {
            Map<TaskInterval, ProjectEarnedValueAnalysisReport> earnedValueReport = projectReportService.getEarnedValueAnalysisReport(1);

            Assert.assertTrue(earnedValueReport.size() > 0);


        } catch (Exception e) {
            logger.error("Error while getting project report info: ",e);
            fail();
        }


    }


}
