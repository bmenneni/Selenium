package stepImplementations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BDDLoginTest {
	WebDriver driver;
	String username = "tomsmith";
	String password = "SuperSecretPassword!";
	
	@Given("^user is on the login page$")
	public void user_is_on_the_login_page() {
		System.out.println("User is on the login page.");
		driver = utilities.DriverFactory.open("Chrome");
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Form Authentication")).click();
	}
	
	@When("^user enters correct username and correct password$")
	public void user_enters_correct_username_and_correct_password() {
		System.out.println("User enters username and password.");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	@Then("^user gets confirmation$")
	public void user_gets_confirmation() {
		System.out.println("User gets confirmation.");
		Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
		driver.quit();
	}
	
}
