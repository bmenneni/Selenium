package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
WebDriver driver;
	
	@FindBy(id="username")
	WebElement usernameElement;
	
	@FindBy(id="password")
	WebElement passwordElement;
	
	@FindBy(css="button[type='submit']")
	WebElement submitBox;
	
	
	public void setUserName(String username) {
		usernameElement.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordElement.sendKeys(password);
	}
	
	public void clickSubmit() {
		submitBox.click();
	}
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
