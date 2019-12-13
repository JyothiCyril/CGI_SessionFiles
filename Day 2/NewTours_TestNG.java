package com.qa.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTours_TestNG {
//	1. Open new tours application "http://www.newtours.demoaut.com/"
//	2. Validate the title of the page
//	3. Check if the title is in upper case
//	4. Check if the user name and password text box exists
//	5. Check if the signin button is enabled by default
//	6. Login to the application with mercury as user name and password
//	7. Check the title of the page "Book a flight"
//	8. Check if round trip option is selected by default
//	8. Fill all the details to book a flight
//	9. Click on continue booking
	
	WebDriver Driver;
	
	
	@BeforeTest
	public void Start_Up() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
		Driver = new ChromeDriver();				
			Driver.manage().deleteAllCookies();
		//Driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	//	Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		Driver.get("http://www.newtours.demoaut.com/");
		
	}
	
	@AfterTest
	public void Tear_Down() throws IOException, InterruptedException {
//		String DriverScreeenshot = "NewTours";
//		
//		TakesScreenshot sshot = (TakesScreenshot)Driver;
//		File DriverSS = sshot.getScreenshotAs(OutputType.FILE);
//		String Dest = System.getProperty("user.dir") + "/DriverScreenshot" + DriverScreeenshot + ".png";
//		FileUtils.copyFile(DriverSS, new File(Dest));
//		Thread.sleep(2000);
		Driver.quit();
	}
	
//	2. Validate the title of the page
	@Test(priority = 0, groups = "Title")
	public void validate_Title() {
		String ttl = Driver.getTitle();
		Assert.assertEquals(ttl, "Welcome: New Tours");
		
	}
//	3. Check if the title is in upper case	
	@Test(priority = 1, groups = "Title")
	
	public void Title_Uppercase() {
		String ttl = Driver.getTitle();
		String U_ttl = ttl.toUpperCase();
		Assert.assertEquals(ttl, U_ttl);
		
	}
	
//	4. Check if the user name and password text box exists
	
	@Test(priority = 2, groups = "Asserts")
	public void Element_exists() {
		
		boolean Un_displayed = Driver.findElement(By.name("userName")).isDisplayed();
		boolean Pwd_displayed = Driver.findElement(By.name("password")).isDisplayed();
		Assert.assertTrue(Un_displayed, "User name text box is present");
		Assert.assertTrue(Pwd_displayed, "Password text box is present");
		
		
		
	}
//	5. Check if the signin button is enabled by default
	
	@Test(priority = 3, groups = "Asserts")
	public void SignIn_enabled() {
		
		boolean enabled = Driver.findElement(By.name("login")).isEnabled();
		//Assert.assertTrue(enabled);
		Assert.assertTrue(enabled, "Button is enabled");
	}
	
//	6. Login to the application with mercury as user name and password
	
	@Test(priority = 4)
	public void Login() {
		
		
		Driver.findElement(By.name("userName")).sendKeys("mercury");
		Driver.findElement(By.name("password")).sendKeys("mercury");
		Driver.findElement(By.name("login")).click();
	}
	
//	7. Check the title of the page "Book a flight"
	@Test(priority = 5, groups = "Title")
	public void Get_Title_BookaFlight() throws InterruptedException {
		Thread.sleep(3000);
		Reporter.log(Driver.getTitle());
		
	}
//	8. Check if round trip option is selected by default	
	
	@Test(priority = 6, groups = "Asserts" )
	public void Check_RadioBtn() throws IOException  {
		String Screenshotname = null ;
		File Src = Driver.findElement(By.xpath("//input[@value = 'roundtrip']")).getScreenshotAs(OutputType.FILE);
		
		
		FileUtils.copyFile(Src,new File("C:\\Users\\jyothilp\\Desktop\\All Docs\\QA Training\\sshot.png"));
		
		
		String Destination = System.getProperty("user.dir") + "/ScreenShots/" + Screenshotname + ".png";
		FileUtils.copyFile(Src, new File(Destination));
		
		boolean selected = Driver.findElement(By.xpath("//input[@value = 'roundtrip']")).isSelected();
		Assert.assertTrue(selected, "Button is selected");
		
	}
	
	
//	9. Fill all the details to book a flight
	
	@Test(priority = 7, dependsOnMethods = "Login")
	public void Fill_Details() throws InterruptedException {
		Select Pass_Sel = new Select(Driver.findElement(By.name("passCount")));
		Pass_Sel.selectByIndex(2);
		Thread.sleep(2000);
		Select Departure_loc = new Select(Driver.findElement(By.name("fromPort")));
		Departure_loc.selectByValue("London");
		Thread.sleep(2000);
		Select Arrival_Loc = new Select(Driver.findElement(By.name("toPort")));
		Arrival_Loc.selectByVisibleText("Paris");
		Thread.sleep(2000);
		
		
	}
	
//	10. Click on continue booking
	
	@Test(priority = 8)
	public void Click_ContinueBooking() {
		Driver.findElement(By.name("findFlights")).click();
	}
	
}
