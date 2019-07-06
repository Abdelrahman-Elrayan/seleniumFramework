package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	MyAccountPage myAccountObject;
	String oldPassword = "test1234";
	String newPassword = "test123456";
	String firstName = "Abdelrahman";
	String lastName = "El-Rayan";
	String email = "testmaill12@yahoo1.com";
	
	
	@Test(priority=1)
	public void userCanRegisterSuccessfully() {
	
		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();
		
		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(firstName, lastName, email, oldPassword);
		
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
	}

	@Test(priority=2)
	public void registeredUserCanChangePAssword(){
		myAccountObject = new MyAccountPage(driver);
		registerObject.openMyAccountPage();
		myAccountObject.openChangePasswordPAge();
		myAccountObject.changePassword(oldPassword, newPassword);
		Assert.assertTrue(myAccountObject.resultLb1.getText().contains("Password was changed"));
	}
	
	@Test(priority=3)
	public void registeredUserCanLogOut() {
		registerObject.userLogout();
	}
	
	@Test(priority=4)
	public void registeredUserCanLogIn() {
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email, newPassword);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));
	}

}
