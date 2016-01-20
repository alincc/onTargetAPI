package com.ontarget.api.rs;

import com.ontarget.entities.ProjectBimFileElementTaskLink;


import javax.validation.Valid;

/**
 * Created by TRON on 1/19/2016.
 */
public interface ProjectBimFileElementTaskLinkEndpoint {

    ProjectBimFileElementTaskLink linkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementTaskLink request);

    ProjectBimFileElementTaskLink unlinkProjectBinFileElementTaskLink(@Valid ProjectBimFileElementTaskLink request);

}
