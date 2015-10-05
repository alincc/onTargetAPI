package com.ontarget.util;

import com.ontarget.constant.OnTargetConstant;
import com.ontarget.entities.Project;
import com.ontarget.entities.ProjectBimFile;
import com.ontarget.entities.User;
import com.ontarget.request.bean.SaveBIMRequest;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public class ProjectBimFileUtil {


    /**
     * return project bim file entity object based on the request.
     * @param request
     * @return
     */
    public static ProjectBimFile getProjectBimEnitityFromBIMRequest(SaveBIMRequest request){
        ProjectBimFile file = new ProjectBimFile();
        file.setBimPoid(new BigInteger(request.getPoid().toString()));
        file.setStatus(OnTargetConstant.GenericStatus.ACTIVE);
        Project project=new Project();
        project.setProjectId(new Integer(request.getProjectid().toString()));
        file.setProject(project);
        file.setBimThumbnailFileLocation(request.getProjectBimFileLocation());
        file.setCreatedBy(new User(request.getBaseRequest().getLoggedInUserId()));
        file.setCreatedDate(new Date());

        return file;
    }


}
