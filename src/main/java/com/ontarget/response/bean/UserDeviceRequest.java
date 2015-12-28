package com.ontarget.response.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ontarget.entities.UserDevice;
import lombok.Data;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class UserDeviceRequest {

    @JsonProperty("userDevice")
    @NotNull
    private UserDevice userDevice;

}
