package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitExample {
WebDriver driver;
	
	@Test
	public void WebDriverWaitTest() throws InterruptedException {
		driver = utilities.DriverFactory.open("Chrome");
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.cssSelector("#start > button")).click();
		//WebDriverWait begin
		WebDriverWait myWait = new WebDriverWait(driver,5); 
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
		//WebDriverWait end
		String confirmationText = driver.findElement(By.id("finish")).getText();
		Assert.assertTrue(confirmationText.contains("Hello World"));
		driver.quit();
	}
	
}