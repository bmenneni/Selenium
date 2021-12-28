package smoketests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class PageTitleJUnit {
//Declare variables and objects at CLASS level so that multiple methods can access them.
	
	WebDriver driver;
	String webURL = "https://the-internet.herokuapp.com";
	
	@Test
	public void pageTitleTest() {
		driver = utilities.DriverFactory.open("chrome");
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "The Internet";
		
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Before
	public void setUp() {
		System.out.println("Setting up the test");
		System.out.println("Initializing the driver");
	}
		
	@After
	public void tearDown() {
		System.out.println("Closing the test");
		System.out.println("Closing the driver");
		driver.close();
	}
}
