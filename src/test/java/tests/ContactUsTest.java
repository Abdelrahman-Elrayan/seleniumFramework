package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homeObject;
	ContactUsPage contactObject;
	String fullName = "Rayan";
	String email = "email@test.com";
	String message = "test test test";

	@Test
	public void userCanUseContactUs() {
		homeObject = new HomePage(driver);
		homeObject.openContactUsPage();
		contactObject = new ContactUsPage(driver);
		contactObject.contactUs(fullName, email, message);
		Assert.assertTrue(contactObject.successMessage.getText()
				.contains("Your enquiry has been successfully sent to the store owner."));
	}

}
