package com.ontarget.response.bean;

import com.ontarget.bean.ProfileFeatureInfo;
import com.ontarget.bean.ProfileMenuInfo;
import com.ontarget.dto.OnTargetResponse;
import lombok.Data;

import java.util.List;

/**
 * Created by sanjeevghimire on 12/10/15.
 */
@Data
public class UserProjectProfileResponse extends OnTargetResponse{
    private List<ProfileMenuInfo> menuList;
    private List<ProfileFeatureInfo> featureList;
    private int projectId;
    private int userId;
}
