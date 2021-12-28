package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void loginTest(String username, String password) throws InterruptedException {
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(2000);
		System.out.println(username + " , " + password);
	}
	
	@BeforeMethod
	public void SetUp() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData() {
		return utilities.Excel.get("C:\\Users\\bmenn\\Documents\\SeleniumJavaPractice\\herokuData2.xls");
	}

}
