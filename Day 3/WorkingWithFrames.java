package com.qa.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithFrames {
	WebDriver Driver;
	
	@BeforeTest
	
	public void Start() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://docs.oracle.com/javase/7/docs/api/");
	}
	
	@AfterTest
	
	public void Close() {
		Driver.quit();
	
	}
	
	@Test
	
	
	public void framesbyIndex()
	{

		
		int count = Driver.findElements(By.tagName("frame")).size();
		
			for(int i=0; i<count; i++) 
			{
			
			WebDriver frame = Driver.switchTo().frame(i);
			
			System.out.println(frame.getTitle());
			
			Driver.switchTo().defaultContent();
			
		}	
			

	}
	
	@Test
	
	public void framebyName() {
		
		
		WebElement frame_name = Driver.findElement(By.name("packageListFrame"));
		String name = frame_name.getAttribute("name");
		
		WebDriver frame2 = Driver.switchTo().frame(name);
		frame2.getTitle();
		
		Driver.switchTo().defaultContent();
		
	}
	
	@Test
	
	public void framebyElement() {
		
		//Switch to a frame based on the web element
		WebDriver frame = Driver.switchTo().frame(Driver.findElement(By.xpath("//frame[@name = 'classFrame']")));
		//System.out.println(frame.getTitle());
		frame.findElement(By.linkText("Description")).click();
		Driver.switchTo().defaultContent();
		
	}
	

}
