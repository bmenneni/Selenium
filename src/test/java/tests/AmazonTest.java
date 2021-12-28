package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {
	WebDriver driver;
	String browserType = "Chrome";
	
	@Test
	public void amazonSearch() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("computer");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[3]/h2/a/span")).click();
		
	}
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
	}
	
	@AfterMethod
	public void tearDown() {
	//	driver.quit();
	}
}
