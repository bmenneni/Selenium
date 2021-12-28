package tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String username;
	String password;
	
	@Test
	public void newAccountTest() throws InterruptedException {
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		Thread.sleep(5000);
		driver.close();
		System.out.println(username + " , " + password);
	}
	
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get("C:\\Users\\bmenn\\Documents\\SeleniumJavaPractice\\heroku_test_login_csv.csv");
	}
	
	// Constructor that passes parameters to the test method.
	public NewAccountDDT(String username, String password) {
		this.username = username;
		this.password = password;
	}
}
