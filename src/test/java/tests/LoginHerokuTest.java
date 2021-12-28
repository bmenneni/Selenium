package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Confirmation;
import pages.Login;
import pages.LoginPageFactory;
import pages.Welcome;

public class LoginHerokuTest {

		WebDriver driver;
		String username = "tomsmith";
		String password = "SuperSecretPassword!";

		@Test
		public void loginTestPOM() throws InterruptedException {
						
			//1. Initialize driver
			driver = utilities.DriverFactory.open("Chrome");
			driver.get("https://the-internet.herokuapp.com/");
			
			
			// 2. Click on Form Authentication (Login Page)
			Welcome welcome = new Welcome(driver);	
			welcome.ClickFormAuth();
			
			// 3. Enter login information
			//Login login = new Login(driver); 
			LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
			loginPageFactory.setUserName(username);
			loginPageFactory.setPassword(password);
			loginPageFactory.clickSubmit();
			
			// 4. Get confirmation (Dashboard Page)
			Confirmation confirmation = new Confirmation(driver);
			Assert.assertTrue(confirmation.getConfirmationText().contains("You logged into a secure area!"));
		
			
			// 5. Close the driver
			Thread.sleep(5000);
			driver.quit();

		}
}
