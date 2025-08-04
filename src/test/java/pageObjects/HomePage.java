package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

		
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath ="//span[normalize-space()='My Account']") 	WebElement linkMyaccount;
	@FindBy(xpath ="//a[normalize-space()='Register']") 		WebElement accRegister;
	@FindBy(xpath ="//a[normalize-space()='Login']") 			WebElement accLogin;
	
	
	
	public void ClickMyAccount() {
		
		linkMyaccount.click();
	}	
		public void ClickAccountRegister() {
		
		accRegister.click();
	}
		public void ClickLogin() {
			
			accLogin.click();
	}
}
