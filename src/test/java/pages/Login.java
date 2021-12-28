package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	WebDriver driver;
	
	public void setUserName(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	

}
