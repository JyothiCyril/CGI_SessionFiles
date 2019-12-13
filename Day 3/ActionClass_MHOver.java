package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionClass_MHOver {

	
	WebDriver Driver;
	@BeforeTest
	public void Start_Up(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
		Driver = new ChromeDriver();
	
		Driver.manage().window().maximize();
		Driver.get("https://www.amazon.in/");
	}
	
	
	
	@Test
	
	public void MOver() {
		
				
		Actions act = new Actions(Driver);
		WebElement ele = Driver.findElement(By.id("nav-link-accountList"));
		
		act.moveToElement(ele).build().perform();
			
		Driver.findElement(By.linkText("Start here.")).click();
		System.out.println(Driver.getTitle());
		
	}
	
	@AfterTest
	
	public void End_Test() {
		
		Driver.quit();
	}

}
