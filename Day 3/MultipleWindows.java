package com.qa.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleWindows {
	WebDriver Driver;
	
	@BeforeTest
	public void start() {
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
//		Driver = new FirefoxDriver();
		
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
	public void MultipleWin() throws InterruptedException {
		
		Driver.findElement(By.linkText("Disclaimer")).click();
		Thread.sleep(3000);
		Driver.findElement(By.linkText("Privacy Policy")).click();
		Thread.sleep(3000);
		
		Set<String> WinID = Driver.getWindowHandles();
				
		Iterator<String> iter = WinID.iterator();
		
		String id = iter.next();
		
		//System.out.println(Driver.getTitle());
		Driver.switchTo().window(id).getTitle();
		
		
		String id1 = iter.next();
		
		System.out.println(Driver.getTitle());
		Driver.switchTo().window(id1).getTitle();
		
		List<WebElement> links = Driver.switchTo().window(id1).findElements(By.tagName("a"));
		for(WebElement e: links) {
			System.out.println(e.getText());
		}
		
		String id2 = iter.next();
		
		System.out.println(Driver.getTitle());
		Driver.switchTo().window(id2).getTitle();
		
		
	}


}
