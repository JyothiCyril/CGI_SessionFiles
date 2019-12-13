import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport_Example {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static WebDriver Driver;
	
	@BeforeTest
	public static void startTest() {
		
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows 10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("Testername", "Kim Smith");	
	}
	
	@AfterTest
	
	public static void endTest() {
		extent.flush();
		
	}
	
	
	@BeforeMethod
	
	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jyothilp\\Desktop\\Selenium Training Softwares\\Drivers\\Chrome78\\chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get("https://www.amazon.in/");
		
	}	
		
	@Test
	
	public static void GetTitle() {
		test = extent.createTest("GetTitle");
		
		String ttl = Driver.getTitle();
		Assert.assertEquals(ttl, "Online Shopping site in India:  Amazon.in");
	}
				
	@Test
	
	public static void Search_Item() {
		test = extent.createTest("Search_Item");
		Select Sel = new Select(Driver.findElement(By.id("searchDropdownBox")));
		Sel.selectByVisibleText("Books");
		String Srch_Term = "Da vinci code";
		Driver.findElement(By.name("field-keywords")).sendKeys(Srch_Term);
		Driver.findElement(By.xpath("//input[@tabindex = '10']")).click();
	
		List<WebElement> Titles = Driver.findElements(By.xpath("//span[@class = 'a-size-medium a-color-base a-text-normal']"));
		
		for(WebElement ttl : Titles) {
			Reporter.log(ttl.getText());
		}
	}
	
	@AfterMethod
	
	public static void tearDown(ITestResult results) throws IOException {
		
		if(results.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test failed is :" + results.getName());
			test.log(Status.FAIL, "Test failed is :" + results.getThrowable());
			
			String screenshotPath = ExtentReport_Example.getScreenshot(Driver, results.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		}else if(results.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Skipped is:" + results.getName());
		}else if(results.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Passed is:" + results.getName());
		}
		
		Driver.quit();
	}
	
	
	public static String getScreenshot(WebDriver Driver, String ScreenshotName) throws IOException {
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot)Driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		String Destination = System.getProperty("user.dir") + "/screenshots/" + ScreenshotName + dateName + ".png";
		
		File FinalDestination = new File(Destination);
		FileUtils.copyFile(Source, FinalDestination);
		return Destination;			
	}
	
}
