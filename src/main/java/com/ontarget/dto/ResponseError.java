package com.ontarget.dto;

/**
 * Created by Owner on 10/29/14.
 */
public class ResponseError {

    private String errorCode;
    private String errorMessage;

    public ResponseError() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
