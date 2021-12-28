package bm.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGTest {
	WebDriver driver;
	
	@Test (priority = 2)
	public void myFirstTest(){
		System.out.println("This is the first test.");
		boolean ContextMenu = driver.findElement(By.linkText("Context Menu")).isDisplayed();
		Assert.assertTrue(ContextMenu);
		//Assert.assertFalse(ContextMenu, "Expecting false, but got true.");
		
	}
	
	@Test (priority = 1)
	public void mySecondTest(){
		System.out.println("This is the second test.");
		boolean ContextMenu = driver.findElement(By.linkText("Context Menu")).isDisplayed();
		Assert.assertTrue(ContextMenu);
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get("https://the-internet.herokuapp.com");
		System.out.println("Starting test");
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}
	
}
