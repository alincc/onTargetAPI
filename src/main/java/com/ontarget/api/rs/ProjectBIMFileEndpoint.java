package com.ontarget.api.rs;

import com.ontarget.request.bean.DeleteBIMRequest;
import com.ontarget.request.bean.GetBIMRequest;
import com.ontarget.request.bean.SaveBIMRequest;
import com.ontarget.request.bean.UpdateBIMThumbnailPathRequest;
import com.ontarget.response.bean.GetBIMResponse;
import com.ontarget.response.bean.SaveBIMResponse;

/**
 * Created by sanjeevghimire on 10/2/15.
 */
public interface ProjectBIMFileEndpoint {


    public GetBIMResponse getBIMPoids(GetBIMRequest request);

    public SaveBIMResponse saveProjectBIMPoids(SaveBIMRequest request);


    SaveBIMResponse deleteProjectBIMPoids(DeleteBIMRequest request);

    SaveBIMResponse updateProjectBIMThumbnailPath(UpdateBIMThumbnailPathRequest request);
}
