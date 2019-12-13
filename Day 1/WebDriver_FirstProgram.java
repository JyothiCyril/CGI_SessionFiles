package com.qa.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_FirstProgram {

	public static void main(String[] args) {
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
		//WebDriver Driver = new InternetExplorerDriver();
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		//WebDriver Driver = new FirefoxDriver();
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\Chrome78\\chromedriver.exe");
		// invoke the Driver
		WebDriver Driver = new ChromeDriver();
		// Maximize the browser
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		//Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		 // Run the URL on the browser
		Driver.get("http://www.amazon.in/");
		// Get the title and print
		String ttl = Driver.getTitle();
		System.out.println(ttl);
		
		if(ttl.contains("Amazon23")) {
			System.out.println("Title has Amazon word");
		}else {
			System.out.println("Title does not have amazon word");
		}
		
		Driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Da vinci code");
	
		Driver.findElement(By.xpath("//input[@tabindex = '10']")).click();
		
		
		List<WebElement> Items = Driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
		System.out.println("Total no. of items loaded: " + Items.size());
		
		for(WebElement itm: Items) {
			System.out.println(itm.getText());
		}
		
		//Driver.close();
		
		Driver.quit();

	}

}
