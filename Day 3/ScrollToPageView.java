package com.qa.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AmazonCareers {
	
	
	WebDriver Driver;
	
	@Test
	
	public void Jobs_Link() {
		
	
	
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
	Driver = new ChromeDriver();
	Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Driver.manage().window().maximize();
	Driver.get("https://www.amazon.in/");
	
	WebElement element = Driver.findElement(By.xpath("//a[@href='https://amazon.jobs']"));
	System.out.println(element.getText());
	
	//element.click();
	
		
	
	//WebElement myelement = Driver.findElement(By.xpath("//a[@href='https://amazon.jobs']"));
	JavascriptExecutor jse2 = (JavascriptExecutor)Driver;
	jse2.executeScript("arguments[0].scrollIntoView()", element);
	
	element.click();
	
	
	Driver.quit();
	}
}
