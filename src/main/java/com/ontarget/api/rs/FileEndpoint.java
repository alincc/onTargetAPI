package com.ontarget.api.rs;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public interface FileEndpoint {
	Response downloadExcelFile();

	Response uploadExcelFile(InputStream fileInputStream, FormDataContentDisposition fileFormDataContentDisposition);

	Response getFile();
}
