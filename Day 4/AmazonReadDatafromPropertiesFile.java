package com.qa.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class AmazonReadDatafromPropertiesFile {
	//Validate the title of the page
	//Search for an item
	//Get the footer links
	//Search for existence of element
	//Pre condition : Open the browser, Navigate to URL
	//Post condition : delete the cookies , Close the browser
	
	WebDriver Driver;
	FileInputStream fileloc;
	Properties prop;
	
	@Test
	public void Check_title() {
		String ttl = Driver.getTitle();
		Assert.assertEquals(ttl, "Welcome to Amazon");
	}
	
	
	
	@Test
	public void Search_item() {
		Driver.findElement(By.id("twotabsearchtextbox")).sendKeys(prop.getProperty("bookname"));
		Driver.findElement(By.xpath("//input[@tabindex = '10']")).click();
		
	List<WebElement> Items = Driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		
	System.out.println("Total no. of items loaded: " + Items.size());
		
		for(WebElement itm: Items) {
		System.out.println(itm.getText());
			Reporter.log(itm.getText());
		}
		
	}

//	@Test
//	
//	public void get_Footerlink() {
//		
//		List<WebElement> footerlinks = Driver.findElements(By.cssSelector(".nav_a"));
//	
//		for(WebElement links: footerlinks) {
//			System.out.println(links.getText());
//			Reporter.log(links.getText());
//			
//		}
//	}
	
//	@Test
//	public void Search_element() {
//		Assert.assertTrue(true);
//		
//	}
	
	@BeforeTest
	public void start_up() throws IOException {
		fileloc = new FileInputStream("C:\\Users\\jyothilp\\Desktop\\All Docs\\QA Training\\SeleniumWorkSpace\\Selenium_WebDriverr\\src\\com\\qa\\utils\\Data.properties");
		prop = new Properties();
		prop.load(fileloc);
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
		Driver = new ChromeDriver();
	//	Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		
		Driver.get(prop.getProperty("url"));
		//String Destination =  System.getProperty("user.dir") + "/Ashotscreens/" + "Full page" + ".jpg";
//		AShot SShot1 = new AShot();
//		Screenshot sshot = SShot1.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(Driver);
//		ImageIO.write(sshot.getImage(), "jpg" , new File("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Selenium Jars\\Ashotscreen.jpg"));
//		
		
		AShot Screen = new AShot();
		Screenshot sshot = Screen.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(Driver);
	
		
		ImageIO.write(sshot.getImage(), "jpg", new File("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Selenium Jars\\Screenshots\\Ashotscree.jpg"));
	}
	
	@AfterTest
	
	public void tear_down() throws InterruptedException {
		//Driver.manage().deleteAllCookies();
		
		Reporter.log("End Test");
		//Driver.close();
		//Thread.sleep(10000);
	}
	
	
	
	
	

}
