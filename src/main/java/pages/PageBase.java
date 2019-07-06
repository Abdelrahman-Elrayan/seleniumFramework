package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	//Protected to be available only @this package
	protected WebDriver driver;
	public JavascriptExecutor js;
	public Select select;
	
	//Create Constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickButton(WebElement button) {
		button.click();
	}
	
	protected static void setTxtElementTxt(WebElement txtElement, String value) {
		txtElement.sendKeys(value);
	}
	
	//Scroll by java script
	public void scrollToBottom() {
		js.executeScript("scrollBy(0,2500)");
	}
}
