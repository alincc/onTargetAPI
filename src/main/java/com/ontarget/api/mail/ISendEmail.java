package com.ontarget.api.mail;

import java.util.Map;

/**
 * Created by sanjeevghimire on 12/4/15.
 */
public interface ISendEmail {

    public void sendEmail(Map<String, Object> emailAttributes) throws Exception;

}
