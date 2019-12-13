package com.qa.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcel {

	public static void main(String[] args) throws IOException {


		// Open the excel file in read mode
		
		
		FileInputStream File = new FileInputStream("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Data.xlsx");
		XSSFWorkbook Workbook = new XSSFWorkbook(File);
		XSSFSheet WSheet = Workbook.getSheet("Sheet3");
		
		int lastRowNum = WSheet.getLastRowNum();
		
		int lastCellNum = WSheet.getRow(0).getLastCellNum();
		
		for(int i=0 ; i<=lastRowNum; i++) {
			XSSFRow row = WSheet.getRow(i);
			for(int j=0; j<lastCellNum; j++) {
				String CellValue = row.getCell(j).toString();
				System.out.print(" " +CellValue);
			}System.out.println();
			
		}
		
		

	}

}
