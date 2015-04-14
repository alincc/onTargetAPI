package com.ontarget.api.rs.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ontarget.api.rs.FileEndpoint;
import com.ontarget.dto.UserData;

@Component
@Path("/file")
public class FileEndpointImpl implements FileEndpoint {

	@Value("${file.upload.path}")
	public String UPLOAD_FILE_SERVER;

	private Logger logger = Logger.getLogger(FileEndpointImpl.class);

	@GET
	@Path("/download/excel")
	@Produces("application/vnd.ms-excel")
	public Response downloadExcelFile() {
		File file = new File("/home/santosh/excel/download/sample.xlsx");

		ResponseBuilder responseBuilder = Response.ok((Object) file);
		responseBuilder.header("Content-Disposition", "attachment; filename=\"MyJerseyExcelFile.xlsx\"");
		return responseBuilder.build();
	}

	@POST
	@Path("/upload/excel")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadExcelFile(@FormDataParam("uploadFile") InputStream fileInputStream,
			@FormDataParam("uploadFile") FormDataContentDisposition fileFormDataContentDisposition) {
		logger.info("file path: " + UPLOAD_FILE_SERVER);
		// local variables
		String fileName = null;
		String uploadFilePath = null;

		try {
			fileName = fileFormDataContentDisposition.getFileName();
			uploadFilePath = writeToFileServer(fileInputStream, fileName);
		} catch (IOException ioe) {
			logger.info(ioe);
			ioe.printStackTrace();
		} finally {
			// release resources, if any
		}

		List<UserData> userList = new ArrayList<UserData>();
		logger.info("uploaded file path: " + uploadFilePath);
		try {
			// Create the input stream from the xlsx/xls file
			FileInputStream fis = new FileInputStream(new File(uploadFilePath));

			// Create Workbook instance for xlsx/xls file input stream
			Workbook workbook = null;
			if (fileName.toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (fileName.toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			}

			// Get the number of sheets in the xlsx file
			int numberOfSheets = workbook.getNumberOfSheets();

			// loop through each of the sheets
			for (int i = 0; i < numberOfSheets; i++) {

				// Get the nth sheet from the workbook
				Sheet sheet = workbook.getSheetAt(i);

				// every sheet has rows, iterate over them
				Iterator<Row> rowIterator = sheet.iterator();
				while (rowIterator.hasNext()) {
					String firstName = "";
					String lastName = "";

					// Get the row object
					Row row = rowIterator.next();

					// Every row has columns, get the column iterator and
					// iterate over them
					Iterator<Cell> cellIterator = row.cellIterator();

					while (cellIterator.hasNext()) {
						// Get the Cell object
						Cell cell = cellIterator.next();

						// check the cell type and process accordingly
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_STRING:
							if (firstName.equalsIgnoreCase("")) {
								firstName = cell.getStringCellValue().trim();
							} else if (lastName.equalsIgnoreCase("")) {
								// 2nd column
								lastName = cell.getStringCellValue().trim();
							} else {
								// random data, leave it
								System.out.println("Random data::" + cell.getStringCellValue());
							}
							break;
						case Cell.CELL_TYPE_NUMERIC:
							System.out.println("Random data::" + cell.getNumericCellValue());
						}
					} // end of cell iterator
					UserData userData = new UserData(firstName, lastName);
					userList.add(userData);
				} // end of rows iterator

			} // end of sheets for loop

			// close file input stream
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
			logger.info(e);
		} catch (Exception e) {
			logger.info(e);
		}
		logger.info("user list: " + userList);

		return Response.ok("File uploaded successfully at " + uploadFilePath).build();
	}

	@GET
	@Path("zipFile")
	@Produces("application/zip")
	public Response getFile() {
		String ZIP_FILE_PATH = "/home/santosh/excel/zip/test.zip";

		File f = new File(ZIP_FILE_PATH);

		if (!f.exists()) {
			// throw new WebApplicationException(404);
		}

		return Response.ok(f).header("Content-Disposition", "attachment; filename=server.zip").build();
	}

	/**
	 * write input stream to file server
	 * 
	 * @param inputStream
	 * @param fileName
	 * @throws IOException
	 */
	private String writeToFileServer(InputStream inputStream, String fileName) throws IOException {

		OutputStream outputStream = null;
		String qualifiedUploadFilePath = UPLOAD_FILE_SERVER + fileName;

		try {
			outputStream = new FileOutputStream(new File(qualifiedUploadFilePath));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			outputStream.flush();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			// release resource, if any
			outputStream.close();
		}
		return qualifiedUploadFilePath;
	}

}
