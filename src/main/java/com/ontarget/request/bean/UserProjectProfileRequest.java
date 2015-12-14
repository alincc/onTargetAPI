package com.ontarget.request.bean;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 12/10/15.
 */
@Data
public class UserProjectProfileRequest {
    @NotNull
    private BaseRequest baseRequest;
}
