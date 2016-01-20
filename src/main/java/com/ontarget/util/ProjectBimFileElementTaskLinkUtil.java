package com.ontarget.util;

import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.ProjectBimFileElementTaskLink;
import com.ontarget.entities.ProjectTask;
import com.ontarget.entities.User;
import com.ontarget.request.bean.ProjectBimFileElementToTaskLinkRequest;

import java.util.Date;

/**
 * Created by TRON on 1/20/2016.
 */
public class ProjectBimFileElementTaskLinkUtil {


    public static ProjectBimFileElementTaskLink getBimFileElementLinkEnitityFromBimFileElementLinkRequest(ProjectBimFileElementToTaskLinkRequest request) {
        ProjectBimFileElementTaskLink file = new ProjectBimFileElementTaskLink();
        file.setCreatedDate(new Date());

        ProjectBimFile projectBimFile = new ProjectBimFile();
        projectBimFile.setProjectBimFileId(request.getBimFileId().intValue());
        file.setProjectBimFile(projectBimFile);
        file.setCreatedBy(new User(request.getBaseRequest().getLoggedInUserId()));

        file.setElementId(request.getBimFileElementId());
        ProjectTask projectTask = new ProjectTask();
        projectTask.setProjectTaskId(request.getTaskId().intValue());
        file.setProjectTask(projectTask);


        return file;
    }


}
