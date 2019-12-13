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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class WebDriver_Introduction {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		/*1. Open a browser (Chrome / FF/ IE..)
		2. Open a url --> amazon.in
		3. Select the books category -->  id="searchDropdownBox"
		4. Type 'Da vinci code' books into search text box --> name="field-keywords"
		5. Click on magnifier button --> //input[@tabindex = '10']
		6. Get the title of the page
		7. Check if the title is matching with the search term
		8. Close the webpage*/
		
 // Working with Chrome Driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\Chrome78\\chromedriver.exe");
		WebDriver Driver = new ChromeDriver();
		

// Working with Firefox driver

		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		//WebDriver Driver = new FirefoxDriver();


// Working with IE driver
		
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\IEDriverServer_x64_2.45.0\\IEDriverServer.exe");
		//WebDriver Driver = new InternetExplorerDriver();
		

		Driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Driver.manage().window().maximize();
		Driver.manage().deleteAllCookies();
		Driver.get("https://www.amazon.in/");
		
		//Thread.sleep(3000);
		//WebElement ACC = Driver.findElement(By.xpath("//span[@class='nav-line-4']"));
		
		//Thread.sleep(3000);
		//Actions action = new Actions(Driver);
		//action.moveToElement(ACC).build().perform();
		
		//action.moveToElement(ACC).click();
		//Thread.sleep(3000);
	
		//Driver.findElement(By.linkText("Start here.")).click();
		//Thread.sleep(3000);
		
		System.out.println(Driver.getTitle());
		
//		
//		Select Sel = new Select(Driver.findElement(By.id("searchDropdownBox")));
//		Sel.selectByVisibleText("Books");
//	
//		String Srch_Term = "Da vinci code";
//		Driver.findElement(By.name("field-keywords")).sendKeys(Srch_Term);
//		File screenshotAs2 = Driver.findElement(By.name("field-keywords")).getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(screenshotAs2, new File("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Selenium Jars\\Screen123.png"));	
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		Driver.findElement(By.xpath("//input[@tabindex = '10']")).click();
//		
//		String TTL = Driver.getTitle();
//		System.out.println("The title is:" + TTL);
//		if(TTL.contains(Srch_Term)) {
//		//if(TTL.equals(Srch_Term)) {
//			System.out.println("Title is same");
//		}else {
//			System.out.println("Title is not same");
//		}
//		File src= ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);  
//		
//		try {
//			FileUtils.copyFile(src, new File("C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Selenium Jars\\Screen.png"));	
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println("the Screenshot is taken");
//		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Driver);
//		boolean writtten= ImageIO.write(screenshot.getImage(), "jpg", new File("C:\\\\Users\\\\jyothilp\\\\Desktop\\\\Selenium Training Softwares\\\\Selenium Jars\\\\fullimage.jpg"));
//		if(writtten)
//				System.out.println("image Saved");
		Driver.close();
	}

}
