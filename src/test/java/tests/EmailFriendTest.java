package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	EmailPage emailObject;

	//Registration

	@Test(priority=1, alwaysRun=true)
	public void userCanRegisterSuccessfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Abdelrahman", "El-Rayan", "testmaill@test1100.com", "test123");

		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	//Search
	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
		} catch (Exception e) {
			System.out.println("Error Occurred" +e.getMessage());
		}
	}

	//Send Email
	@Test(priority=3)
	public void registeredUserCanSendEmailToFriend() {
		detailsObject.openSendEmail();
		emailObject = new EmailPage(driver);
		emailObject.sendEmailToFriend("abdelrahman.ios.2018@gmail.com", "Test Mail");
		Assert.assertTrue(emailObject.messageNotification.getText()
				.contains("Your message has been sent."));
	}

	//Log Out
	@Test(priority=4)
	public void registeredUserCanLogOut() {
		registerObject.userLogout();
	}

}
