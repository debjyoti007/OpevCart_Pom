package testCases;


import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBaseClass;

public class TC_003LoginTestDDT extends TestBaseClass{

	

	@Test
	public void verifyLoginTest() throws IOException, InterruptedException {
		
				
			
			System.out.println("Running login test...");
			loggers.info(".................Running/Starting login test.....................");
			HomePage hp = new HomePage(driver);
			LoginPage lp = new LoginPage(driver);
			MyAccountPage ap = new MyAccountPage(driver);

			hp.ClickMyAccount();
			hp.ClickLogin();
			
			Thread.sleep(2000); // Wait for the login page to load
			
			lp.EmailLogin(p.getProperty("email")); // Add the email to login
			lp.PassLogin(p.getProperty("password")); // Add the password to login
			Thread.sleep(3000); 
			lp.ClickLogin();
			
			
			
			loggers.info(".................Login test in validation.....................");
			boolean targetPage = ap.isMyAccountPageDisplayed();
			Thread.sleep(2000); // Wait for the My Account page to load
			
			
			
			Assert.assertTrue(targetPage, "Login Failed");//Assert.assertEquals(targetPage,true, "Login Fauled");
			loggers.info(".................Login test completed.....................");
			
		
		
	}

	

}