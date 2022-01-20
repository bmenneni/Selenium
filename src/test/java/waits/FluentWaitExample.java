package waits;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FluentWaitExample {
	WebDriver driver;

	@Test
	public void FluentWaitTest() {
		driver = utilities.DriverFactory.open("Chrome");
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.linkText("Example 1: Element on page that is hidden")).click();
		driver.findElement(By.cssSelector("#start > button")).click();
	
		//FluentWait begin
		Wait<WebDriver> myWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).
				pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
	
		WebElement myElement = myWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.id("finish")).isDisplayed())
				{
					return driver.findElement(By.id("finish"));
				}
				else
					return null;
			}		
		});
		//FluentWait end
		String confirmationText = driver.findElement(By.id("finish")).getText();
		Assert.assertTrue(confirmationText.contains("Hello World"));
		driver.quit();
	}
}
