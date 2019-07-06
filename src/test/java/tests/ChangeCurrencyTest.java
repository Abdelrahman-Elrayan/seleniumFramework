package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrencyTest extends TestBase{

	HomePage homeObject;
	ProductDetailsPage detailsObject;
	String productName = "Apple MacBook Pro 13-inch";
	SearchPage searchObject;
	
	@Test(priority=1)
	public void userCanChangeCurrency() {
		homeObject = new HomePage(driver);
		homeObject.changeCurrency();
		}
	
	@Test(priority=2)
	public void userCanSearchWithAutoSuggest() {
		try {
			searchObject = new SearchPage(driver);
			searchObject.productSearchUsingAutoSuggest("MacB");
			detailsObject = new ProductDetailsPage(driver);
			Assert.assertTrue(detailsObject.productNameBreadCrumb.getText().equalsIgnoreCase(productName));
			System.out.println(detailsObject.productPriceLbl.getText());
			Assert.assertTrue(detailsObject.productPriceLbl.getText().contains("Ђ"));
		} catch (Exception e) {
			System.out.println("Error Occurred" +e.getMessage());
		}
			}

}
