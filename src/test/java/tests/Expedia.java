package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	WebDriver driver;
	String browserType = "Chrome";
	String originCity = "Des Moines";
	String destinationCity = "Denver";
	
	@Test
	public void flightReservation() throws InterruptedException {
		// 1. Search
		driver.findElement(By.linkText("Flights")).click();
		//Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("button[aria-label='Leaving from']")).click(); // Origin
		driver.findElement(By.id("location-field-leg1-origin")).sendKeys(originCity);
		//Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[aria-label='Search for “Des Moines”']")).click();
		
		driver.findElement(By.cssSelector("button[aria-label='Going to']")).click(); // Destination
		driver.findElement(By.id("location-field-leg1-destination")).sendKeys(destinationCity);
		//Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[aria-label='Search for “Denver”']")).click();
		
		driver.findElement(By.id("d1-btn")).click(); // Flight dates
		driver.findElement(By.cssSelector("button[data-day='20']")).click();
		driver.findElement(By.cssSelector("button[data-day='23']")).click();
		driver.findElement(By.cssSelector("button[data-stid='apply-date-picker']")).click();
		
		// Submit Search
		driver.findElement(By.cssSelector("button[data-testid='submit-button']")).click();
		
		
		// 2. Modify the search results page, give criteria
		
		
		// 3. Analyze the results and make our selection
		
		// 4. Book reservation
		
		// 5. Fill out contact/billing
		
		// 6. Get confirmation
		Thread.sleep(5000);
	}
	
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public void setUp() {
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.expedia.com/");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
