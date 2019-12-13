package org.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewToursRegistrationExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\Chrome78\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		
		FileInputStream File = new FileInputStream("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Data.xlsx");
		XSSFWorkbook WorkBook = new XSSFWorkbook(File);
		
		XSSFSheet WorkSheet = WorkBook.getSheet("Sheet2");
		int lastRowNum = WorkSheet.getLastRowNum();
		
		for(int i=1; i<=lastRowNum; i++) {
		
			XSSFRow row = WorkSheet.getRow(i);
			System.out.println(row.getCell(0).getStringCellValue());
			System.out.println(row.getCell(1).getStringCellValue());
			
			int Phone = (int) row.getCell(2).getNumericCellValue();
			System.out.println(Phone);
			// Convert the int to String before passing as input value in sendKeys().
			System.out.println(String.valueOf(Phone));
			
			System.out.println(row.getCell(3).getStringCellValue());
			System.out.println(row.getCell(4).getStringCellValue());
			System.out.println(row.getCell(5).getStringCellValue());
			System.out.println(row.getCell(6).getStringCellValue());
			System.out.println(row.getCell(7).getStringCellValue());
			
			System.out.println("Generic tostring() is:	" + row.getCell(8).toString());
			
			int Pincode = (int)row.getCell(8).getNumericCellValue();
			System.out.println(Pincode);
			System.out.println(String.valueOf(Pincode));
			
			
			System.out.println(row.getCell(9).getStringCellValue());
			System.out.println(row.getCell(10).getStringCellValue());
			System.out.println(row.getCell(11).getStringCellValue());
			System.out.println("********************************");
		}
		
	}

}
