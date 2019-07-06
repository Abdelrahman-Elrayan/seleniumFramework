package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProvider extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	
	@Test(priority=1, alwaysRun=true)
	public void userCanRegisterSuccessfully() {
	
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Abdelrahman", "El-Rayan", "testmaill@test1295.com", "test123");
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods= {"userCanRegisterSuccessfully"})
	public void registeredUserCanLogOut() {
		registerObject.userLogout();
	}
	
	@Test(dependsOnMethods= {"registeredUserCanLogOut"})
	public void registeredUserCanLogIn() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin("testmaill@test95.com", "test123");
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}
}
