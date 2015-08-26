package com.ontarget.api.rs.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.BodyPartEntity;
import org.glassfish.jersey.media.multipart.MultiPart;

import com.ontarget.request.bean.UploadData;

@Path("/mixFile")
public class UploadMixDataImpl {

	@POST
	@Consumes("multipart/mixed")
	public Response post(MultiPart multiPart) {
		// First part contains a Project object
		UploadData project = multiPart.getBodyParts().get(0).getEntityAs(UploadData.class);
		System.out.println("name : " + project.getName());
		System.out.println("description : " + project.getDescription());
		System.out.println("license : " + project.getLicense());
		System.out.println("SVN URL : " + project.getSvnURL());
		System.out.println("homepage : " + project.getHomepage());

		// get the second part which is the project logo
		BodyPartEntity bpe = (BodyPartEntity) multiPart.getBodyParts().get(1).getEntity();
		String id = UUID.randomUUID().toString();
		boolean isProcessed = false;
		String message = null;
		try {
			InputStream source = bpe.getInputStream();
			BufferedImage bi = ImageIO.read(source);

			File file = new File("/home/santosh/filetest/sa.png");

			// storing the image to file system.
			if (file.isDirectory()) {
				ImageIO.write(bi, "png", file);
			} else {
				file.mkdirs();
				ImageIO.write(bi, "png", file);
			}
			isProcessed = true;

		} catch (Exception e) {
			message = e.getMessage();
		}
		if (isProcessed) {
			return Response.status(Response.Status.ACCEPTED).entity("Attachements processed successfully.").type(MediaType.TEXT_PLAIN)
					.build();
		}

		return Response.status(Response.Status.BAD_REQUEST).entity("Failed to process attachments. Reason : " + message)
				.type(MediaType.TEXT_PLAIN).build();
	}
}