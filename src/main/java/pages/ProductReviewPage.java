package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="AddProductReview_Title")
	WebElement reviewTitleTxt;
	
	@FindBy(id="AddProductReview_ReviewText")
	WebElement reviewTxt;
	
	@FindBy(id="addproductrating_4")
	WebElement rating4RdoBtn;
	
	@FindBy(name="add-review")
	WebElement submitReviewBtn;
	
	@FindBy(css="div.result")
	public WebElement reviewNotification;
	
	public void addProductReview(String reviewTitle, String reviewMessage) {
		setTxtElementTxt(reviewTitleTxt, reviewTitle);
		setTxtElementTxt(reviewTxt, reviewMessage);
		clickButton(rating4RdoBtn);
		clickButton(submitReviewBtn);
	}

}
