package com.ontarget.api.rs;

import javax.validation.Valid;

import com.ontarget.dto.OnTargetResponse;
import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.GetBIMRequest;
import com.ontarget.request.bean.ProjectBIMFileCommentListRequest;
import com.ontarget.request.bean.ProjectBIMFileCommentRequest;
import com.ontarget.request.bean.ProjectFileCommentDeleteRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import com.ontarget.request.bean.UpdateBIMThumbnailPathRequest;
import com.ontarget.response.bean.GetBIMResponse;
import com.ontarget.response.bean.ProjectBIMFileCommentListResponse;
import com.ontarget.response.bean.SaveBIMResponse;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileEndpoint {

	GetBIMResponse getBIMPoids(@Valid GetBIMRequest request);

	SaveBIMResponse saveProjectBIMPoids(@Valid SaveBIMRequest request);

	SaveBIMResponse deleteProjectBIMPoids(@Valid DeleteBIMRequest request);

	SaveBIMResponse updateProjectBIMThumbnailPath(@Valid UpdateBIMThumbnailPathRequest request);

	OnTargetResponse addUpdateComment(@Valid ProjectBIMFileCommentRequest request);

	OnTargetResponse deleteComment(@Valid ProjectFileCommentDeleteRequest request);

	ProjectBIMFileCommentListResponse commentList(ProjectBIMFileCommentListRequest request);
}
