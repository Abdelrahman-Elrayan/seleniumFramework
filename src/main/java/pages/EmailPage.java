package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends PageBase{

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="FriendEmail")
	WebElement friendEmailTxt;
	
	@FindBy(id="PersonalMessage")
	WebElement personnalMessageTxt;
	
	@FindBy(name="send-email")
	WebElement sendEmailBtn;
	
	@FindBy(css="div.result")
	public WebElement messageNotification;
	
	public void sendEmailToFriend(String friendEmail, String personalMessage) {
		setTxtElementTxt(friendEmailTxt, friendEmail);
		setTxtElementTxt(personnalMessageTxt, personalMessage);
		clickButton(sendEmailBtn);
	}

}
