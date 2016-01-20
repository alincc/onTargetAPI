package com.ontarget.util;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.*;
import com.ontarget.request.bean.ProjectBimFileElementToTaskLinkRequest;
import com.ontarget.request.bean.SaveBIMRequest;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by TRON on 1/20/2016.
 */
public class ProjectBimFileElementTaskLinkUtil {


    public static ProjectBimFileElementTaskLink getBimFileElementLinkEnitityFromBimFileElementLinkRequest(ProjectBimFileElementToTaskLinkRequest request) {
        ProjectBimFileElementTaskLink file = new ProjectBimFileElementTaskLink();
        file.setCreatedDate(new Date());

        ProjectBimFile projectBimFile = new ProjectBimFile();
        projectBimFile.setProjectBimFileId(new Integer(request.getBimFileId().toString()));
        file.setProjectBimFile(projectBimFile);
        file.setCreatedBy(new User(request.getBaseRequest().getLoggedInUserId()));

        file.setElementId(request.getBimFileElementId());
        ProjectTask projectTask = new ProjectTask();
        projectTask.setParentTaskId(new Integer(request.getTaskId().toString()));
        file.setProjectTask(projectTask);


        return file;
    }


}
