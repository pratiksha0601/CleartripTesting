package com.qa.utilities;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelUtilities {
	
	
	
	// row count
	
	// column count
	
	//reach the cell data
	
	
	XSSFWorkbook WorkBook;
	XSSFSheet Sheet;

	
	public ExcelUtilities(String ExcelPath, String SheetName) {
		
		try{
			FileInputStream file = new FileInputStream (new File(ExcelPath));
			WorkBook = new XSSFWorkbook(file);
			Sheet = WorkBook.getSheet(SheetName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public int getRowCount() {
		
		int rowCount = Sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
		return rowCount;
		
	}
	
	public int getColCount() {
		
		int colCount = Sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colCount);
		return colCount;
		
	}
	
	public String getCellData(int rowNum, int ColNum) {
		String stringCellValue = Sheet.getRow(rowNum).getCell(ColNum).toString();
		return stringCellValue;
	
	}

}
