package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Change password")
	WebElement changePasswordLink;
	
	@FindBy(id="OldPassword")
	WebElement oldPasswordTxt;
	
	@FindBy(id="NewPassword")
	WebElement newPasswordTxt;
	
	@FindBy(id="ConfirmNewPassword")
	WebElement confirmPasswordTxt;
	
	@FindBy(css="input.button-1.change-password-button")
	WebElement changePasswordBtn;
	
	@FindBy(css="div.result")
	public WebElement resultLb1;
	
	public void openChangePasswordPAge() {
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		setTxtElementTxt(oldPasswordTxt, oldPassword);
		setTxtElementTxt(newPasswordTxt, newPassword);
		setTxtElementTxt(confirmPasswordTxt, newPassword);
		clickButton(changePasswordBtn);
	}

}
