package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistranPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBaseClass;

public class TC_002LoginTest extends TestBaseClass{

	@Test
	public void verifyLoginTest() {
		
		try {
			System.out.println("Running login test...");
			loggers.info(".................Running/Starting login test.....................");
			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			MyAccountPage ap = new MyAccountPage(driver);
			hp.ClickMyAccount();
			hp.ClickLogin();
			
			lp.EmailLogin(""); // Add the email to login
			lp.PassLogin(""); // Add the password to login
			lp.ClickLogin();
			boolean targetPage = ap.isMyAccountPageDisplayed();
			
			
			
			Assert.assertTrue(targetPage, "Login Failed");//Assert.assertEquals(targetPage,true, "Login Fauled");
			loggers.info(".................Login test completed.....................");
			}  
		
		catch (Exception e) {
			loggers.error(".................Browser is not opened.....................");
			e.printStackTrace();
		}
		// Implement the login test logic here
		
		
	}

	

}
