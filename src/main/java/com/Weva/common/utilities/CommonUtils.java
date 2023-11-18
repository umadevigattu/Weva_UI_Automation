package com.Weva.common.utilities;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CommonUtils {
	public static ArrayList<String> list = new ArrayList<String>();

	public static String getCurrentDate() { // TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);

	}

	public static <list> ArrayList<list> ExcelReader() throws Exception {
		String path = "C:\\Users\\91944\\Downloads\\LoginTestData.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();
		Cell cell = null;
		for (int i = 0; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			int lastcell = row.getLastCellNum();
			for (int j = 0; j <= lastcell; j++) {
				cell = row.getCell(1);

			}
			list.add(cell.getStringCellValue());
		}
		System.out.println(list);
		return null;
	}

}
