package com.ontarget.request.bean;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 12/23/15.
 */
@Data
public class ProjectArnRequest {

    @NotNull
    @Valid
    private BaseRequest baseRequest;
    @NotNull
    private String projectArn;
}
