package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistranPage;
import pageObjects.HomePage;
import testBase.TestBaseClass;

public class TC_001AccountRegistration extends TestBaseClass{

	
	@Test	
	public void verify_Account_Registration() {
		
		HomePage hp =new HomePage(driver);
		AccountRegistranPage arp = new AccountRegistranPage(driver);
		String passcode=randomAlphanumeric();
		
		loggers.info("Starting Account Registration Test............");
				
		try {
			hp.ClickMyAccount();
			loggers.info("Click on My Account");
			
			hp.ClickAccountRegister();
			loggers.info("Click on Register Account");
			
			arp.FirstName(randomString().toUpperCase());
			arp.LastName(randomString().toUpperCase());
			arp.Email(randomString().toLowerCase()+"@gmail.com");
			arp.TelePhone(randomNumber());
					
			loggers.info("Entering Account Details");
			
			arp.PassWord(passcode);
			arp.ConPass(passcode);
			
			loggers.info("Entering Password Details");
			
			arp.ConfirmCheck();
			arp.ConfirmBtn();
			loggers.info("Click on Confirm CheckBox and Continue Button");
			
			Thread.sleep(3000);
			String confirmMSG= arp.Confirmationmsg();
			Assert.assertEquals(confirmMSG, "Your Account Has Been Created!");
			loggers.info("Account Registration Successful");
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
