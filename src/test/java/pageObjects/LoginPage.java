package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
			
		super(driver);
		}

	@FindBy(xpath ="//input[@id=\"input-email\"]") 	WebElement emailLogin;
	@FindBy(xpath ="//input[@id=\"input-password\"]") 	WebElement passLogin;
	@FindBy(xpath ="///input[@value='Login']]") 		WebElement btnLogin;
	
	
	public void EmailLogin(String email) {
		emailLogin.sendKeys(email);
	}
	public void PassLogin(String pass) {
		passLogin.sendKeys(pass);
	}
		public void ClickLogin() {
		btnLogin.click();
	}
	
}
