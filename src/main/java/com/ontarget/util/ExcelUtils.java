package com.ontarget.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ontarget.request.bean.ActivityTaskRecord;
import com.ontarget.request.bean.UploadActivityRequest;

public class ExcelUtils {
	public static Workbook getWorkbook(String fileName, FileInputStream fis) {
		Workbook workbook = null;

		try {
			if (fileName.toLowerCase().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(fis);
			} else if (fileName.toLowerCase().endsWith("xls")) {
				workbook = new HSSFWorkbook(fis);
			}
			return workbook;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static UploadActivityRequest getActivityRecords(Workbook workbook, Integer projectId, String filename) {

		UploadActivityRequest request = new UploadActivityRequest();
		request.setProjectId(projectId);
		request.setFilename(filename);

		List<ActivityTaskRecord> activityTaskRecords = new ArrayList<ActivityTaskRecord>();

		int numberOfSheets = workbook.getNumberOfSheets();

		for (int i = 0; i < numberOfSheets; i++) {

			Sheet sheet = workbook.getSheetAt(i);

			Iterator<Row> rowIterator = sheet.iterator();

			int index = 1;
			int rowIndex = 0;
			while (rowIterator.hasNext()) {
				ActivityTaskRecord activityTaskRecord = new ActivityTaskRecord();
				try {
					Row row = rowIterator.next();

					rowIndex++;

					if (rowIndex == 1) {
						continue;
					}

					activityTaskRecord.setIndex(String.valueOf(index));

					for (int cellIndex = 0; cellIndex < 12; cellIndex++) {

						Cell cell = row.getCell(cellIndex);
						cell.setCellType(Cell.CELL_TYPE_STRING);

						if (cellIndex == 0) {
							activityTaskRecord.setActivityCode(cell.getStringCellValue().trim());
						} else if (cellIndex == 1) {
							activityTaskRecord.setActivityName(cell.getStringCellValue().trim());
						} else if (cellIndex == 2) {
							activityTaskRecord.setActivityStartDate(cell.getStringCellValue().trim());
						} else if (cellIndex == 3) {
							activityTaskRecord.setActivityEndDate(cell.getStringCellValue().trim());
						} else if (cellIndex == 4) {
							activityTaskRecord.setTaskCode(cell.getStringCellValue().trim());
						} else if (cellIndex == 5) {
							activityTaskRecord.setTaskName(cell.getStringCellValue().trim());
							activityTaskRecord.setTaskDescription(activityTaskRecord.getTaskName());
						} else if (cellIndex == 6) {
							activityTaskRecord.setTaskStartDate(cell.getStringCellValue().trim());
						} else if (cellIndex == 7) {
							activityTaskRecord.setTaskEndDate(cell.getStringCellValue().trim());
						} else if (cellIndex == 8) {
							activityTaskRecord.setEstimatedCost(cell.getStringCellValue().trim());
						} else if (cellIndex == 9) {
							activityTaskRecord.setActualCost(cell.getStringCellValue().trim());
						} else if (cellIndex == 10) {
							activityTaskRecord.setPriority(cell.getStringCellValue().trim());
						} else if (cellIndex == 11) {
							activityTaskRecord.setPercentageComplete(cell.getStringCellValue().trim());
						}
					}
				} catch (NullPointerException nre) {
					nre.printStackTrace();
				}
				index++;
				activityTaskRecords.add(activityTaskRecord);
			}
		}
		request.setActivityTaskRecords(activityTaskRecords);
		return request;
	}

}
