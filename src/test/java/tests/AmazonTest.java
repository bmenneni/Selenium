package tests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AmazonTest {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest extentTest;
	String browserType = "Chrome";
	
	@Test
	public void amazonSearch() throws IOException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("computer");
		driver.findElement(By.id("nav-search-submit-button")).click();
	    //File src = (File) ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
		//String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//TakesScreenshot ts = (TakesScreenshot) driver;
		//File source = ts.getScreenshotAs(OutputType.FILE);
//		String destination = "C://SeleniumScreenshots//ss.png";
//		File finalDestination = new File(destination);
//		FileUtils.copyFile(src, finalDestination);
		
		
		driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[3]/h2/a/span")).click();
	}
	
//	@BeforeTest
//	public void setExtent() {
//		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
//		extent.addSystemInfo("Environment", "QA");
//	}
	
//	@AfterTest
//	public void endReport() {
//		extent.flush();
//		extent.close();
//	}
	
	public static void getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/FailedTestScreenshots" + "testScreenshot.png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	}
	
//	@AfterMethod
//	public void tearDown(ITestResult result) throws IOException {
//		if (result.getStatus()==TestResult.FAILURE) {
//			extentTest.log(LogStatus.FAIL, "TEST CASE " + result.getName() + " HAS FAILED");
//			extentTest.log(LogStatus.FAIL, "TEST CASE " + result.getThrowable() + " HAS FAILED");
//			String screenshotPath = AmazonTest.getScreenshot(driver, result.getName());
//			extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
//		}
//		else if(result.getStatus()==ITestResult.SKIP) {
//			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
//		}
//		
//		extent.endTest(extentTest);
//		driver.quit();
//	}
}
