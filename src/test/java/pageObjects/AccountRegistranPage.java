package pageObjects;

import javax.security.auth.login.AccountException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@SuppressWarnings("unused")
public class AccountRegistranPage extends BasePage{

	public AccountRegistranPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath ="//input[@id='input-firstname']") 	WebElement firstName;
	@FindBy(xpath ="//input[@id='input-lastname']") 	WebElement lastName;
	@FindBy(xpath ="//input[@id='input-email']") 		WebElement emailAdd;
	@FindBy(xpath ="//input[@id='input-telephone']") 	WebElement telePhone;
	
	@FindBy(xpath ="//input[@id='input-password']") 	WebElement passwd;
	@FindBy(xpath ="//input[@id='input-confirm']") 		WebElement conPass; 	
	
	//@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']") 	WebElement subscribe;
	
	@FindBy(xpath ="//input[@name='agree']") 		WebElement confirmChkBox;
	@FindBy(xpath ="//input[@value='Continue']") 	WebElement continueBtn;
	
	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']") 	WebElement success;

	
public void FirstName(String fname) {
		
	firstName.sendKeys(fname);
	}	

public void LastName(String lname) {
	
	lastName.sendKeys(lname);
	}	
	
public void Email(String eml) {
	
	emailAdd.sendKeys(eml);
	}	
	
public void TelePhone(String tel) {
	
	telePhone.sendKeys(tel);
	}	
		
	
public void PassWord(String pass) {
	
	passwd.sendKeys(pass);
	}	
public void ConPass(String conpasswd) {
	
	conPass.sendKeys(conpasswd);
	}	
	
public void ConfirmCheck() {
	
	confirmChkBox.click();
	}	

public void ConfirmBtn() {
	
	continueBtn.click();
	}	
	
public String Confirmationmsg() {
	
	try {		
		return (success.getText()); 
		}catch (Exception e) {
		return e.getMessage();	
			
		
	}
}
	
}




