package com.qa.selenium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Screenshots {
	
	WebDriver Driver;
	
	@BeforeTest
	public void start_up() throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Drivers\\\\Chrome78\\\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		Driver.get("https://www.amazon.in/");
		
	}
	
	
	@Test
	
	public void screenshot_Byelement() throws IOException {
		
		System.out.println("Screen shot of Amazon Logo");
		String Screenshotname = null ;
		File Src = Driver.findElement(By.xpath("//a[@tabindex = '6']")).getScreenshotAs(OutputType.FILE);
		// to copy the file in local drive
		FileUtils.copyFile(Src,new File("C:\\Users\\jyothilp\\Desktop\\All Docs\\QA Training\\sshot.png"));
				
		// to copy the file into the current project folder
		String Destination = System.getProperty("user.dir") + "/ScreenShots/" + Screenshotname + ".png";
		FileUtils.copyFile(Src, new File(Destination));
		
		
		
	}
	
	
	@Test
	
	public void screenshot_Driver() throws IOException, InterruptedException {
		
		
		System.out.println("Screenshot of Amazon page");
		
		String DriverScreeenshot = "Amazon";
		
		TakesScreenshot sshot = (TakesScreenshot)Driver;
		File DriverSS = sshot.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir") + "/DriverScreenshot" + DriverScreeenshot + ".png";
		FileUtils.copyFile(DriverSS, new File(Dest));
		Thread.sleep(2000);
	}
	
	@Test
	
	public void screenshot_Ashot() throws IOException {
		
		System.out.println("Screenshot of full page");
		String Fullpage = "Amazon";
		
		AShot Screen = new AShot();
		Screenshot sshot = Screen.shootingStrategy(ShootingStrategies.viewportPasting(200)).takeScreenshot(Driver);
		ImageIO.write(sshot.getImage(), "jpg", new File("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Selenium Jars\\Screenshots\\Ashotscree.jpg"));
				
		String Dest = System.getProperty("user.dir") +"/FullPageScreenshot/" + Fullpage + ".jpg";
		
		File FinalDestination = new File(Dest);
		ImageIO.write(sshot.getImage(), "jpg", FinalDestination);
		
		
	}
	@AfterTest
	
	public void EndTest() {
		Driver.quit();
	}

}
