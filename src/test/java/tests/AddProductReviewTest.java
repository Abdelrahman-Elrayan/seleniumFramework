package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{

	/* 1- Registration
	 * 2- Search for product
	 * 3- Add Review
	 * 4- Log out
	 * */
	
	HomePage homeObject;
	UserRegistrationPage registerObject;
	LoginPage loginObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	ProductDetailsPage detailsObject;
	ProductReviewPage reviewObject;

	//Registration

	@Test(priority=1, alwaysRun=true)
	public void userCanRegisterSuccessfully() {

		homeObject = new HomePage(driver);
		homeObject.openRegistrationPage();

		registerObject = new UserRegistrationPage(driver);
		registerObject.userRegistration("Abdelrahman", "El-Rayan", "testmaill@test2001.com", "test123");

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

	//Add Review
	@Test(priority=3)
	public void registeredUserCanReviewProduct() {
		detailsObject.openAddReviewPage();
		reviewObject = new ProductReviewPage(driver);
		reviewObject.addProductReview("New Review", "The Product is very good");
		Assert.assertTrue(reviewObject.reviewNotification.getText().contains("Product review is"));
	}

	//Log Out
	@Test(priority=4)
	public void registeredUserCanLogOut() {
		registerObject.userLogout();
	}


}
