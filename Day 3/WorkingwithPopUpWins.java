package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingwithPopUpWins {
	
	
WebDriver Driver;
	
	@BeforeTest
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
	}
	
	@AfterTest
	public void End_Test() {
		Driver.quit();
	}

	
	@Test
	public void Login_Test() throws InterruptedException {
		
		Driver.findElement(By.name("proceed")).click();
		System.out.println(Driver.switchTo().alert().getText());
		Driver.switchTo().alert().dismiss();
		Thread.sleep(2000);
		
	}
}
