package testCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBaseClass;
import utilities.DataProviders;

public class TC_002LoginTest extends TestBaseClass{

	

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)// Using DataProvider for DDT
	public void verifyLoginTestDDT(String email, String password, String validation) throws IOException, InterruptedException {
		
		
		try {
			System.out.println("Running login test...");
			loggers.info(".................Running/Starting login test.....................");
			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			MyAccountPage map = new MyAccountPage(driver);

			hp.ClickMyAccount();
			hp.ClickLogin();
			
			Thread.sleep(2000); // Wait for the login page to load
			
			lp.EmailLogin(email); // Add the email to login
			lp.PassLogin(password); // Add the password to login
			Thread.sleep(3000); 
			lp.ClickLogin();
			
			
			loggers.info(".................Login test in validation.....................");
			boolean targetPage = map.isMyAccountPageDisplayed();
			Thread.sleep(2000); // Wait for the My Account page to load
			
			if (validation.equalsIgnoreCase("valid")) {
				if (targetPage==true) {
					loggers.info("1Login test passed with valid credentials");
					map.ClickLogout(); // Logout after successful login
					Assert.assertTrue(true);
					
					
				} else {
					loggers.error("2Login test failed with valid credentials");
					
					Assert.assertTrue(false);
				}
			} else if (validation.equalsIgnoreCase("invalid")) {
				if (targetPage==true) {
					loggers.info("3Login test failed with invalid credentials");
					map.ClickLogout();
					Assert.assertTrue(false);
				} else {
					loggers.error("4Login test passed as its not login with invalid credentials");
					
					Assert.assertTrue(true);
				}
			}			
			
			
	} catch (Exception e) {
			loggers.error("5An error occurred during the login test: " + e.getMessage());
			Assert.fail("Login test failed due to an exception: " + e.getMessage());
		} 
		loggers.info(".................Login test DDT completed.....................");
		
		
	}


	

}