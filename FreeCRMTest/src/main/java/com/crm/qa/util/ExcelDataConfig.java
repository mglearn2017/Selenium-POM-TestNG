package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet1;

	public ExcelDataConfig(String excelPath) {

		try {
			File src = new File(excelPath);
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getData(int sheetNumber, int row, int column) {
		sheet1 = workbook.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex){
		int row=workbook.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}
	
	

}
