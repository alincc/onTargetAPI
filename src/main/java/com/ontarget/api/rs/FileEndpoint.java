package com.ontarget.api.rs;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import com.ontarget.dto.OnTargetResponse;

public interface FileEndpoint {
	Response downloadExcelFile();

	OnTargetResponse uploadExcelFile(InputStream fileInputStream, FormDataContentDisposition fileFormDataContentDisposition);

	Response getFile();
}
