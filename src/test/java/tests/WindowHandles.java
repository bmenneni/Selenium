package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandles {
	WebDriver driver;
	String browserType = "Chrome";
	
	@Test
	public void windowOpen() {
		driver.findElement(By.linkText("Click Here")).click();
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		String textFromNewWindow = driver.findElement(By.cssSelector("body > div > h3")).getText();
		System.out.println(textFromNewWindow);
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.linkText("Click Here")).click();
	}
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
	}
	
	@AfterMethod
	public void tearDown() {
	//	driver.quit();
	}
}
