package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Confirmation {
	WebDriver driver;
	
	public Confirmation(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getConfirmationText() {
		return driver.findElement(By.id("flash")).getText();
	}
}


