package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	//Constructor -- created in BasePage
	public HomePage(WebDriver driver) {
		super(driver); //used to call superclass methods, and to access the superclass constructor. 
	}	
	
	
	//Locators
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement lnkMyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") WebElement lnkRegister;
	
	@FindBy(linkText = "Login") WebElement loginLink; //login link
	
	
	
	//Action Methods
	public void clickMyAccount() {
		lnkMyaccount.click();
	}
	
	public void clickMyRegister() {
		lnkRegister.click();
	}
	
	public void clickLoginLink() {
		loginLink.click();
	}
	
}
