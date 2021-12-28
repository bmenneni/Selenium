package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	WebDriver driver;

	public static WebDriver open(String browserType) {
		if (browserType.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\TestDrivers\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if (browserType.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\TestDrivers\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver", "C:\\TestDrivers\\chromedriver.exe");
			return new ChromeDriver();
		}
	}
}
