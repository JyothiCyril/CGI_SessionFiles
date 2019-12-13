package com.qa.selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon_ReadDataExcel {
	
	WebDriver Driver;
	FileInputStream FileLoc;
	XSSFWorkbook XWorkbook;
	XSSFSheet XSheet;
	
	@BeforeTest
	
	public void Init_test() throws IOException {
		FileLoc = new FileInputStream("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Data.xlsx");
		
		XWorkbook = new XSSFWorkbook(FileLoc);
			
		
				
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		Driver.get("https://www.amazon.in/");
		
	}
	
	@AfterTest
	
	public void End_Test() {
		
		Driver.quit();
	}
	
	
	@Test
	
	public void DDT_Excel() throws InterruptedException {
		
		XSheet = XWorkbook.getSheet("Sheet3");
		int lastRowNum = XSheet.getLastRowNum();
		for(int i=1; i<=lastRowNum; i++) {
			
			XSSFRow row = XSheet.getRow(i);
			
			String Bookname = row.getCell(0).getStringCellValue();
			Driver.findElement(By.id("twotabsearchtextbox")).clear();
			Driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Bookname);
			Thread.sleep(1000);
			Driver.findElement(By.xpath("//input[@tabindex = '10']")).click();
			
			List<WebElement> Items = Driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			
			System.out.println("Total no. of items loaded: " + Items.size());
			
			for(WebElement itm: Items) {
			Reporter.log(itm.getText());
				Reporter.log(itm.getText());
			}
			
		}
		
		
		
		
		
	}
	
	

}
