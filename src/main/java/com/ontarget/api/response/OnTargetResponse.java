package com.ontarget.api.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Owner on 10/29/14.
 */
public class OnTargetResponse implements Serializable {

    private String returnVal;
    private String returnMessage;

    private List<ResponseError> errors;

    private boolean isAuthenticated;
    private boolean tokenString;

    public OnTargetResponse() {
    }

    public String getReturnVal() {
        return returnVal;
    }

    public void setReturnVal(String returnVal) {
        this.returnVal = returnVal;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public List<ResponseError> getErrors() {
        return errors;
    }

    public void setErrors(List<ResponseError> errors) {
        this.errors = errors;
    }

    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public boolean isTokenString() {
        return tokenString;
    }

    public void setTokenString(boolean tokenString) {
        this.tokenString = tokenString;
    }
}
