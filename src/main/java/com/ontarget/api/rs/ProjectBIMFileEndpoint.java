package com.ontarget.api.rs;

import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.*;
import com.ontarget.response.bean.*;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileEndpoint {

	GetBIMResponse getBIMProject(@Valid GetBIMRequest request);

    @POST
    @Path("/get")
    GetBimProjectResponse getBIMProject(GetBimProjectRequest request);

    SaveBIMResponse saveBIMProject(@Valid SaveBIMRequest request);

	SaveBIMResponse deleteBIMProject(@Valid DeleteBIMRequest request);

	SaveBIMResponse updateProjectBIMThumbnailPath(@Valid UpdateBIMThumbnailPathRequest request);

    ProjectBimFileCommentResponse addUpdateComment(@Valid ProjectBIMFileCommentRequest request);

	OnTargetResponse deleteComment(@Valid ProjectFileCommentDeleteRequest request);

	ProjectBIMFileCommentListResponse commentList(ProjectBIMFileCommentListRequest request);
}
