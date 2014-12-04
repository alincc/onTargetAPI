package com.ontarget.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Owner on 10/29/14.
 */
public class OnTargetResponse implements Serializable {


    private String returnVal;
    private String returnMessage;
    private String responseCode;

    private List<ResponseError> errors;

    private boolean isAuthenticated;

    public OnTargetResponse() {
    }
    
    public OnTargetResponse(String returnMessage){
    	this.returnMessage=returnMessage;
    }
    
    public OnTargetResponse(String responseCode,String returnMessage){
    	this.responseCode=responseCode;
    	this.returnMessage=returnMessage;
    }
    
    public OnTargetResponse(String responseCode,String returnVal,String returnMessage){
    	this.responseCode=responseCode;
    	this.returnVal=returnVal;
    	this.returnMessage=returnMessage;
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

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}


}
