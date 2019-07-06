package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndExcel extends TestBase{

	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;

	@DataProvider(name="ExcelData")
	public static Object[][] userRegisterData() throws IOException {

		// get data from Excel Reader class
		ExcelReader ER = new ExcelReader();
			return ER.getExcelData();
		
		
	}



	@Test(priority=1, alwaysRun=true,dataProvider="ExcelData")
	public void userCanRegisterSuccessfully(String fname, String lname, String email, String password) {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration(fname, lname, email, password);

		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));

		registerObject.userLogout();

		homeObject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.userLogin(email,password);
		Assert.assertTrue(registerObject.logoutLink.getText().contains("Log out"));

		registerObject.userLogout();
	}
}