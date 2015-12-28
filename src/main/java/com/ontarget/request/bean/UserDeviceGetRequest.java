package com.ontarget.request.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.annotation.Generated;

/**
 * Created by sanjeevghimire on 12/24/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
public class UserDeviceGetRequest {

    @JsonProperty("userId")
    private Integer userId;

}
