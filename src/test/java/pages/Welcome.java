package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Welcome {
	WebDriver driver;
	
	public Welcome(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ClickFormAuth() {
		driver.findElement(By.linkText("Form Authentication")).click();
	}
}
